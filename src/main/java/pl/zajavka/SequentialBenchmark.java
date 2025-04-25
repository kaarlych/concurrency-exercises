package pl.zajavka;

public class SequentialBenchmark {

    // Simulates heavy CPU work: counts primes up to a certain limit
    private static int countPrimes(int max) {
        int count = 0;
        for (int i = 2; i <= max; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int primeLimit = 500_000;

        System.out.println("Running sequential tasks...");

        long start = System.currentTimeMillis();

        // Sequential execution: tasks run one after another
        int primes = countPrimes(primeLimit);

        long end = System.currentTimeMillis();
        System.out.println("Finished counting primes in " + (end - start) + " ms");
    }
}

