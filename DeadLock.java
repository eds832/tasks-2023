
public class DeadLock {


    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Runnable rn1 = () -> {
            synchronized (a) {
                System.out.println("inside a");
                synchronized (b) {
                    System.out.println("Insida b into a");
                }
            }
        };
        Thread th1 = new Thread(rn1);
        Runnable rn2 = () -> {
            synchronized (b) {
                System.out.println("inside b");
                synchronized (a) {
                    System.out.println("Inside a into b");
                }
            }
        };
        Thread th2 = new Thread(rn2);
        th1.start();
        th2.start();
    }
}