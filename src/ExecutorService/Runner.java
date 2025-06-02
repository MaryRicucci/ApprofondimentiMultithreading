package ExecutorService;
import java.util.Random ;
public class Runner extends Thread {
    private Random r ;
    public Runner (String name) {
        setName(name);
        r = new Random ();
    }
    @Override
    public void run () {
        for (int i = 0; i<5;i++){
            System.out.println(getName()+" sta correndo...");
            try {
                Thread.sleep(r.nextInt(100,500));
            } catch (InterruptedException e) {
                System.out.println(getName()+" è stato interrotto");
            }
        }
        System.out.println(getName()+" taglia il traguardo");
    }
}
