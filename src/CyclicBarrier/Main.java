package CyclicBarrier;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
