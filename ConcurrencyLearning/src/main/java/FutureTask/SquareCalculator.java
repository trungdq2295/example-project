package FutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {
    private ExecutorService executor
            = Executors.newFixedThreadPool(2);

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> future1 = squareCalculator.calculate(5);
        Future<Integer> future2 = squareCalculator.calculate(10);
//        boolean canceled = future.cancel(false);
        while (!(future1.isDone() && future2.isDone())) {
            System.out.printf(
                    "future1 is %s and future2 is %s%n",
                    future1.isDone() ? "done" : "not done",
                    future2.isDone() ? "done" : "not done"
            );
            Thread.sleep(300);
        }
        System.out.println(future1.get());
        System.out.println(future2.get());
        squareCalculator.executor.shutdown();
    }
}
