package ReentrantLock;
import java.util.concurrent.locks.*;
public class Buffer {
    private int v;
    private final ReentrantLock lock = new ReentrantLock();

    //Risorsa condivisa da tutti i thread
    public Buffer() {
        v = 0;
    }

    public int add(int n) { // I thread aggiungono uno alla volta un valore alla variabile della risorsa
        lock.lock(); // Acquisizione del lock
        try {
            v += n; // Modifica della variabile condivisa
            System.out.println(Thread.currentThread().getName() + " ha acquisito il lock, incrementa di " + n + " il buffer");
            return v; // Restituisce il valore aggiornato
        } finally {
            lock.unlock(); // Rilascio del lock
        }

    }
}
