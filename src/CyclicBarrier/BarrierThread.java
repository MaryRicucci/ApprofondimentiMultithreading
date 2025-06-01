package CyclicBarrier;
import java.util.Random ;
import java.util.concurrent.BrokenBarrierException;

public class BarrierThread extends Thread{
    /*
    Classe BarrierThread:
Questa classe ha il seguente comportamento:
Lavora per un tempo randomico tra i 2 e i 5 secondi (simulabile con Thread.sleep(randomVal))
raggiunge la barriera
     */
    private Barriera b ;
    private Random r ;
    public BarrierThread (Barriera b,String name) {
        this.b = b ;
        setName(name);
        r = new Random ();
    }

    @Override
    public void run () {
        System.out.println(getName()+ "sta lavorando...");
        try {
            Thread.sleep(r.nextInt(2000,5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            b.attiva();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
