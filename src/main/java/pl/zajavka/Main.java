package pl.zajavka;

public class Main {
    public static void main(String[] args) {

        Runnable myRunnable = new RunnableThreadImplementation();

        Thread firstThread = new Thread("thread-siemanko");
        Thread secondThread = new Thread(myRunnable, "thread-siemanko-z-runnable");
    }
}