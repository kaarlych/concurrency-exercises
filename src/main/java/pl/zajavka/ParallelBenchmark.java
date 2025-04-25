package pl.zajavka;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ParallelBenchmark {

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

    public static void main(String[] args) throws InterruptedException {
        int threads = Runtime.getRuntime().availableProcessors(); // should be 16 on your CPU
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        int taskCount = threads;
        int primeLimit = 500_000;

        System.out.println("Running " + taskCount + " parallel tasks on " + threads + " threads...");

        long start = System.currentTimeMillis();

        CountDownLatch latch = new CountDownLatch(taskCount);

        for (int i = 0; i < taskCount; i++) {
            executor.submit(() -> {
                int primes = countPrimes(primeLimit);
                System.out.println(Thread.currentThread().getName() + " done. Primes found: " + primes);
                latch.countDown();
            });
        }

        latch.await();
        executor.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("Finished in " + (end - start) + " ms");
    }
}

