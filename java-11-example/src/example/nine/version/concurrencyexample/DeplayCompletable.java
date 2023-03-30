package example.nine.version.concurrencyexample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class DeplayCompletable {
    public static void main(String[] args) throws InterruptedException {
        var future = new CompletableFuture<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Executor executor = (runnable) -> System.out.println("abc");

        var delayExecutor = CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS,executor);
        var delayExecutorWithoutExecutor = CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS);


        future.completeAsync(() -> {
            System.out.println("Processing data");
            return "process success";
        }, delayExecutor)
                .thenAccept(r -> System.out.println("Result: " + r));

        future.completeAsync(() -> {
            System.out.println("Processing data without executor");
            return "process success";
        }, delayExecutorWithoutExecutor)
                .thenAccept(r -> System.out.println("Result: " + r));

        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            System.out.println("Running outside... " + i + " s");
        }
    }
}
