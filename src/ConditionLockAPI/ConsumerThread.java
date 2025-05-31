package ConditionLockAPI;

public class ConsumerThread extends Thread{
    private Buffer b ;

    public ConsumerThread (Buffer b) {
        this.b = b ;

    }
    @Override
    public void run () {
        while (true) {
            try {
                b.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
