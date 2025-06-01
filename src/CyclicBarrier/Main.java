package CyclicBarrier;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        Barriera sincronizzata 🚧
Descrizione:
Simula una barriera sincronizzata che ferma tutti i thread in arrivo fino al raggiungimento di una soglia fissata, per poi svegliarli tutti insieme.
Requisiti:
Classe BarrieraSincronizzata:
Questa classe deve tenere traccia di quanti thread sono in attesa sulla barriera e del valore massimo di thread gestibili
Fino a che il numero di thread in attesa sulla barriera è minore della soglia fissata bisognerà fermare i thread. ⬇️
Quando il numero di thread in attesa supera la soglia si dovranno svegliare tutti i thread in attesa sulla barriera.
Classe BarrierThread:
Questa classe ha il seguente comportamento:
Lavora per un tempo randomico tra i 2 e i 5 secondi (simulabile con Thread.sleep(randomVal))
raggiunge la barriera
Una volta svegliato stampa a schermo il suo nome seguito dalla stringa “ riprende a lavorare”.

         */
        Barriera b = new Barriera (10);
        ArrayList <BarrierThread> operai = new ArrayList<>();

        for (int i = 1 ; i<11; i++) {
            operai.add(new BarrierThread(b,("Op"+i)));
        }
        for (BarrierThread o: operai) {
            o.start();
        }
        for (BarrierThread o: operai) {
            o.join();
        }
        System.out.println("Turno finito");
    }
}
