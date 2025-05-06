package pl.zajavka;

public class MyVeryOwnThreadImplementation extends Thread {

    @Override
    public void run() {
        System.out.println("Siemanko MyVeryFirstThreadImplementation");
    }
}
