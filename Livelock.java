public class Livelock {
    private static Person person1 = new Person("Person 1");
    private static Person person2 = new Person("Person 2");
    private static volatile boolean isPerson1Turn = true;

    private static final Object DOOR = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(person1::goThroughDoor);
        Thread thread2 = new Thread(person2::goThroughDoor);

        thread1.start();
        thread2.start();
    }

    static class Person {
        private final String name;
        private boolean isPassed;

        public Person(String name) {
            this.name = name;
        }

        public void goThroughDoor() {
            while (!isPassed) {
                if (this == person1 && isPerson1Turn || this == person2 && !isPerson1Turn) {
                    synchronized (DOOR) {
                        System.out.println("Turn of " + name);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(name + " looked around");
                        if (this == person1 && person2.isPassed == false
                            || this == person2 && person1.isPassed == false) {
                            System.out.println(name + " decided to wait for another person");
                        } else {
                            isPassed = true;
                            System.out.println(name + " notified that door is passed");
                        }
                        isPerson1Turn = !isPerson1Turn;
                    }
                }
            }
        }
    }
}
