package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Integer> {
    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        FactorialSquareCalculator calculator
                = new FactorialSquareCalculator(n - 1);
        calculator.fork();
        Integer value = calculator.join();
        System.out.println("value " + value);
        return n * n + value;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(3);
        forkJoinPool.execute(calculator);
        System.out.println(calculator.get());

    }
}
