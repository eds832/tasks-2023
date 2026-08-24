// java 25+ only
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

void main(String[] args) throws Exception {
    // If already launched with restricted heap — run tests directly
    if (args.length > 0 && args[0].equals("--child")) {
        testOOM();
        IO.println("\n" + "=".repeat(55) + "\n");
        testMiddleInsertPerformance();
        return;
    }

    long maxHeapMb = Runtime.getRuntime().maxMemory() / 1024 / 1024;
    IO.println("Current max heap: " + maxHeapMb + " MB");
    IO.println("Relaunching self with -Xmx256m...\n");

    // Find the path to this source file relative to the JVM working dir
    String javaExe = ProcessHandle.current().info().command().orElse("java");
    String srcFile = new File("src/LinkedListVsArrayList.java").getAbsolutePath();

    Process child = new ProcessBuilder(javaExe, "-Xmx256m", srcFile, "--child")
            .inheritIO()   // pipe child's stdout/stderr straight to our console
            .start();

    int exit = child.waitFor();
    System.exit(exit);
}

// Byte array sizes to test: from 1 byte (overhead dominates) to 64 KB (payload dominates)
static final int[] ELEMENT_SIZES = {1, 16, 64, 256, 1024, 4096, 16384, 65536};

void testOOM() {
    IO.println("=== OOM Test: ArrayList vs LinkedList at different element sizes ===");
    IO.println("Each element is a byte array of the given size.");
    IO.println("LinkedList node overhead: ~48 bytes (header + prev + next + data ref).");
    IO.println("The smaller the element, the bigger the relative overhead for LinkedList.\n");

    IO.println(String.format("%-10s %15s %15s %12s", "Size", "ArrayList", "LinkedList", "AL/LL ratio"));
    IO.println("-".repeat(55));

    for (int elementSize : ELEMENT_SIZES) {
        System.gc();
        long alCount = fillUntilOOM(new ArrayList<>(), elementSize);
        System.gc();
        long llCount = fillUntilOOM(new LinkedList<>(), elementSize);
        System.gc();

        String ratio = llCount == 0 ? "N/A" : String.format("%.2f", (double) alCount / llCount);
        String sizeLabel = elementSize >= 1024
                ? (elementSize / 1024) + " KB"
                : elementSize + " B ";
        IO.println(String.format("%-10s %15d %15d %12s", sizeLabel, alCount, llCount, ratio));
    }

    IO.println("\n--- What to notice ---");
    IO.println("Small elements (1-64 B): AL/LL ratio is high — node overhead is large vs payload.");
    IO.println("Large elements (16+ KB): ratio approaches 1.0 — payload drowns out overhead.");
}

long fillUntilOOM(List<byte[]> list, int elementSize) {
    long count = 0;
    try {
        while (true) {
            list.add(new byte[elementSize]);
            count++;
        }
    } catch (OutOfMemoryError e) {
        list.clear();
        System.gc();
    }
    return count;
}

void testMiddleInsertPerformance() {
    IO.println("\n=== Sequential ListIterator: add & remove at different list sizes ===");
    IO.println("Iterator walks the list; every 10 steps adds an element, every 20 removes one.");
    IO.println("ArrayList.add/remove shifts all elements right of cursor — O(n) per op.");
    IO.println("LinkedList.add/remove rewires two pointers — O(1) per op.\n");

    int[] sizes = {1_000, 5_000, 10_000, 25_000, 50_000, 100_000, 250_000};

    IO.println(String.format("%-12s %12s %12s %20s", "List size", "ArrayList", "LinkedList", "ratio"));
    IO.println("-".repeat(50));

    for (int size : sizes) {
        ArrayList<Integer> al = new ArrayList<>(size);
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < size; i++) { al.add(i); ll.add(i); }

        long alTime = benchmarkSequential(new ArrayList<>(al));
        long llTime = benchmarkSequential(new LinkedList<>(ll));

        String alStr = alTime == 0 ? "<1 ms" : alTime + " ms";
        String llStr = llTime == 0 ? "<1 ms" : llTime + " ms";
        long llForRatio = Math.max(llTime, 1);
        String ratio = String.format("AL ~%.1fx slower", (double) alTime / llForRatio);

        IO.println(String.format("%-12d %12s %12s %20s", size, alStr, llStr, ratio));
    }

    IO.println("\n--- What to notice ---");
    IO.println("Small lists: both fast, ratio near 1 (GC noise dominates).");
    IO.println("Large lists: ArrayList time grows quadratically; LinkedList stays nearly flat.");
}

// Walks the full list sequentially; adds every 10 steps, removes every 20 steps.
// The iterator is never re-created — this is the case where LinkedList wins.
long benchmarkSequential(List<Integer> list) {
    long start = System.currentTimeMillis();
    ListIterator<Integer> it = list.listIterator();
    int step = 0;
    boolean lastWasAdd = false;

    while (it.hasNext()) {
        it.next();
        step++;

        if (step % 20 == 0 && !lastWasAdd) {
            it.remove();   // remove current — O(1) for LinkedList, O(n) for ArrayList
            lastWasAdd = false;
        } else if (step % 10 == 0) {
            it.add(step * -1);  // insert after current — O(1) for LinkedList, O(n) for ArrayList
            lastWasAdd = true;
        } else {
            lastWasAdd = false;
        }
    }
    return System.currentTimeMillis() - start;
}

/*
Current max heap: 8088 MB
Relaunching self with -Xmx256m...

=== OOM Test: ArrayList vs LinkedList at different element sizes ===
Each element is a byte array of the given size.
LinkedList node overhead: ~48 bytes (header + prev + next + data ref).
The smaller the element, the bigger the relative overhead for LinkedList.

Size             ArrayList      LinkedList  AL/LL ratio
-------------------------------------------------------
1 B                9230100         5499414         1.68
16 B               7055976         4704887         1.50
64 B               3095679         2542186         1.22
256 B               951044          890130         1.07
1 KB                252032          248030         1.02
4 KB                 64112           63799         1.00
16 KB                15856           15872         1.00
64 KB                 3777            3777         1.00

--- What to notice ---
Small elements (1-64 B): AL/LL ratio is high � node overhead is large vs payload.
Large elements (16+ KB): ratio approaches 1.0 � payload drowns out overhead.

=======================================================


=== Sequential ListIterator: add & remove at different list sizes ===
Iterator walks the list; every 10 steps adds an element, every 20 removes one.
ArrayList.add/remove shifts all elements right of cursor � O(n) per op.
LinkedList.add/remove rewires two pointers � O(1) per op.

List size       ArrayList   LinkedList                ratio
--------------------------------------------------
1000                 1 ms         1 ms      AL ~1.0x slower
5000                 1 ms         1 ms      AL ~1.0x slower
10000                1 ms         2 ms      AL ~0.5x slower
25000                5 ms         7 ms      AL ~0.7x slower
50000               12 ms         2 ms      AL ~6.0x slower
100000              66 ms         4 ms     AL ~16.5x slower
250000             448 ms         3 ms    AL ~149.3x slower

--- What to notice ---
Small lists: both fast, ratio near 1 (GC noise dominates).
Large lists: ArrayList time grows quadratically; LinkedList stays nearly flat.

Process finished with exit code 0
 */
