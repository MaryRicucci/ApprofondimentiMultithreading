package ConditionLockAPI;
import java.util.concurrent.locks.*;

public class Buffer {
    private final int[] values;
    private final Lock l;
    private final Condition notFull;  // Condizione per il buffer pieno
    private final Condition notEmpty; // Condizione per il buffer vuoto
    private int count = 0;

    public Buffer() {
        l = new ReentrantLock();
        notFull = l.newCondition();
        notEmpty = l.newCondition();
        values = new int[10];
    }

    public void put(int v) throws InterruptedException {
        l.lock();
        try {
            while (count == values.length) {
                notFull.await(); // Aspetta spazio disponibile nel buffer
            }
            values[count] = v;
            count++;
            System.out.println("Il produttore " + Thread.currentThread().getName() + " ha inserito " + v);
            notEmpty.signal(); // Notifica il consumatore che c'è un nuovo dato
        } finally {
            l.unlock();
        }
    }

    public int take() throws InterruptedException {
        l.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // Aspetta un valore nel buffer
            }
            int value = values[count - 1]; // Preleva l'ultimo valore
            values[count - 1] = 0; // Pulisce la posizione nel buffer
            count--;
            System.out.println(Thread.currentThread().getName() + " ha prelevato " + value);
            notFull.signal(); // Notifica il produttore che ora c'è spazio
            return value;
        } finally {
            l.unlock();
        }
    }
}