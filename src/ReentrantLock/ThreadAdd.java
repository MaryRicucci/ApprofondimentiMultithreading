package ReentrantLock;
import java.util.Random ;
public class ThreadAdd extends Thread {
    private Buffer b ;
    private Random r ;
    public ThreadAdd (Buffer b) {
        this.b = b ;
        r = new Random () ;
    }

    @Override
    public void run () {
        System.out.println("Valore: "+b.add((r.nextInt(1,20))));

    }
}
