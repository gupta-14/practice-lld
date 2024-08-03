package LLD.DesignPatterns.SingletonPattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void testSingletonInstance() {
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();

        // Test that both instances are the same
        Assertions.assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    public void testMultiThreadedSingleton() throws InterruptedException {
        final DBConnection[] instance1 = new DBConnection[1];
        final DBConnection[] instance2 = new DBConnection[1];

        Thread thread1 = new Thread(() -> instance1[0] = DBConnection.getInstance());
        Thread thread2 = new Thread(() -> instance2[0] = DBConnection.getInstance());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Test that both instances are the same even in multi-threaded environment
        Assertions.assertSame(instance1[0], instance2[0], "Both instances should be the same in a multi-threaded environment");
    }
}
