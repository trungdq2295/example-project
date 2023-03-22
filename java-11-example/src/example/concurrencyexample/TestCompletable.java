package example.concurrencyexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class TestCompletable {
    public static void main(String[] args) throws InterruptedException {
        var future = new CompletableFuture<>();
        var delayExecutor = CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS);
        future.completeAsync(() -> {
            System.out.println("Processing data");
            return "process success";
        }, delayExecutor)
                .thenAccept(r -> System.out.println("Result: " + r));

        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            System.out.println("Running outside... " + i + " s");
        }
    }
}
