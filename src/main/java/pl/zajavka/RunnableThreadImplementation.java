package pl.zajavka;

public class RunnableThreadImplementation implements Runnable{
    @Override
    public void run() {
        System.out.println("Siema po raz drugi runnable");
    }
}
