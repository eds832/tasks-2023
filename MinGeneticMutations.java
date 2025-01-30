import java.util.ArrayList;
import java.util.List;

public class MinGeneticMutations {

    public static void main(String[] args) {
        System.out.println(
                new MinGeneticMutations.Solution().minMutation(
                        "AACCGGTT", "AAACGGTA",
                        new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}
                ));
    }

    static class Solution {
        /*
        A gene string can be represented by an 8-character long string,
        with choices from 'A', 'C', 'G', and 'T'.
        Suppose we need to investigate a mutation from a gene string startGene
        to a gene string endGene where one mutation is defined as one single
        character changed in the gene string.
        For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
        There is also a gene bank bank that records all the valid gene mutations.
        A gene must be in bank to make it a valid gene string.
        Given the two gene strings startGene and endGene and the gene bank bank,
        return the minimum number of mutations needed to mutate from startGene to endGene.
        If there is no such a mutation, return -1.
        Note that the starting point is assumed to be valid,
        so it might not be included in the bank.
         */
        public int minMutation(String startGene, String endGene, String[] bank) {
            if (startGene.equals(endGene)) {
                return 0;
            }
            int min = -1;
            for (String s : bank) {
                if (diff(startGene, s) == 1) {
                    List<String> lt = new ArrayList<>(List.of(bank));
                    lt.remove(s);
                    String[] b = lt.toArray(String[]::new);
                    int minMutation = minMutation(s, endGene, b);
                    if (minMutation > -1) {
                        if (min > -1) {
                            min = Math.min(min, 1 + minMutation);
                        } else {
                            min = 1 + minMutation;
                        }
                    }
                }
            }
            return min;
        }

        private int diff(String a, String b) {
            char[] c1 = a.toCharArray();
            char[] c2 = b.toCharArray();
            int diff = 0;
            for (int i = 0; i < a.length(); i++) {
                if (c1[i] != c2[i]) {
                    diff++;
                }
            }
            return diff;
        }
    }
}
