import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    public static Future<Void> calculateAsync(int t) throws InterruptedException {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(500);

                for (int i = 0; i < t; i++) {
                    int abc = i;
                    CompletableFuture.runAsync(() -> {
                        try {

                            System.out.println(Thread.currentThread().getName()+ " "+t+" " + Thread.currentThread().getId());
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }, Executors.newCachedThreadPool());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        return completableFuture;
    }

    public static void main(String[] args) throws Exception {
        testFutures();

    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static CompletableFuture<Void> task1() {

        return CompletableFuture.runAsync(() -> {
            System.out.println(" task1 start");
            sleep(5);
            System.out.println(" task1 done");
        });
    }

    private static CompletableFuture<Void> task2() {
        return CompletableFuture.runAsync(() -> {
            System.out.println(" task2 start");
            sleep(2);
            System.out.println(" task2 done");
        });
    }
    private static void testFutures() throws Exception {
        CompletableFuture<Void> both = task1().thenCompose(ignoreMe -> task2());
        both.get();
        System.out.println("both done");

    }
}
