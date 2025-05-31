package ConditionLockAPI;
import java.util.Random ;
public class ProducerThread extends Thread {
    private Buffer b ;
    private Random r  ;

    public ProducerThread (Buffer b) {
        this.b = b ;
        r = new Random () ;
    }

    @Override
    public void run () {
        while (true) {
            try {
                b.put(r.nextInt(1,100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
