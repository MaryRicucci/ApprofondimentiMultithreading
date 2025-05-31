package ConditionLockAPI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer();
        ProducerThread p = new ProducerThread(b);
        ConsumerThread c = new ConsumerThread(b);

        p.start();
        c.start();

        p.join();
        c.join();

        System.out.println("Fine");
    }
}
