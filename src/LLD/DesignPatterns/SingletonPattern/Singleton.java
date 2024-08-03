package LLD.DesignPatterns.SingletonPattern;

public class Singleton {
    public static void main(String[] args) {
        // Test 1: Basic Singleton Instance test
        DBConnection conObject1 = DBConnection.getInstance();
        DBConnection conObject2 = DBConnection.getInstance();

        if (conObject1 == conObject2) {
            System.out.println("Test 1 Passed: Both instances are the same");
        } else {
            System.out.println("Test 1 Failed: Instances are different");
        }

        // Test 2: Multi-threaded Singleton Test
        final DBConnection[] instance1 = new DBConnection[1];
        final DBConnection[] instance2 = new DBConnection[1];

        Thread thread1 = new Thread(() -> instance1[0] = DBConnection.getInstance());
        Thread thread2 = new Thread(() -> instance2[0] = DBConnection.getInstance());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (instance1[0] == instance2[0]) {
            System.out.println("Test 2 Passed: Both instances are the same in a multi-threaded environment");
        } else {
            System.out.println("Test 2 Failed: Instances are different in a multi-threaded environment");
        }
    }
}
