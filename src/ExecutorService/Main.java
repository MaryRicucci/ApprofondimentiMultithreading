package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        
        ExecutorService es = Executors.newFixedThreadPool(3); //Crea  il pool di thread in automaico

        for (int i = 0; i < 3; i++) {
            es.execute(new Runner("Run" + (i + 1))); //assegna il compito di Runner ai thread
        }
        es.shutdown();//chiude il pool dopo aver complentato di compito
    }
}