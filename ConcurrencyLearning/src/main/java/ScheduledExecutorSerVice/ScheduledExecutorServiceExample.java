package ScheduledExecutorSerVice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService
                = Executors.newScheduledThreadPool(1);
//
//        Future<String> future = executorService.schedule(() -> {
//            // ...
//            return "Hello world";
//        }, 1, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Abcccc");
            // ...
        }, 0, 1, TimeUnit.SECONDS);



    }
}
