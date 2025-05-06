package pl.zajavka;

public class Main {
    public static void main(String[] args) {
        Thread myVeryFirstThread = new MyVeryOwnThreadImplementation();
        myVeryFirstThread.start();
        System.out.println("Siemanko main");

    }
}