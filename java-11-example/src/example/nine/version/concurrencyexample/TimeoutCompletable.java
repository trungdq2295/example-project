package example.nine.version.concurrencyexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class TimeoutCompletable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var taskTimeout = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Finish";
        });

        var taskCompleteOnTime = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Finish";
        });

        BiConsumer<String, Throwable> onComplete = (result, error) -> {
            if (error == null) {
                System.out.println("The result is: " + result);
                return;
            }
            System.out.println("Time is over");
        };

        /*
            Will throw exception if passed time allow
         */
        var future = taskTimeout
                .orTimeout(3, TimeUnit.SECONDS)
                .whenComplete(onComplete);

        /*
            Will return defaul value if passed time allow
         */
        var timeOut = taskCompleteOnTime
                                            .completeOnTimeout("Default Value", 2, TimeUnit.SECONDS)
                                            .whenComplete(onComplete);
        System.out.println("abcc: " + timeOut.get());
        var content = future.get();
        System.out.println("Result: " + content);
    }
}
