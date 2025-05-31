package ReentrantLock;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer () ;
        ArrayList <ThreadAdd> threads = new ArrayList<>();

        for (int i = 1 ; i<11; i++) {
            threads.add(new ThreadAdd(b));
        }
        for (ThreadAdd t : threads) {
            t.start();
        }
        for (ThreadAdd t : threads) {
            t.join();
        }

        System.out.println("fine");
    }
}
