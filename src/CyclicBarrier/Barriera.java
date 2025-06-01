package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barriera {
    /*
    Classe BarrieraSincronizzata:
Questa classe deve tenere traccia di quanti thread sono in attesa sulla barriera e del valore massimo di thread gestibili
Fino a che il numero di thread in attesa sulla barriera è minore della soglia fissata bisognerà fermare i thread. ⬇️
Quando il numero di thread in attesa supera la soglia si dovranno svegliare tutti i thread in attesa sulla barriera.
     */
    private CyclicBarrier cb ;

    public Barriera (int nAttesa) {
        cb = new CyclicBarrier(nAttesa);
    }

    public void attiva () throws BrokenBarrierException, InterruptedException {
        System.out.println(Thread.currentThread().getName()+" è in pausa...");
        cb.await();
        System.out.println(Thread.currentThread().getName()+" ha ripreso a lavorare...");
    }
}
