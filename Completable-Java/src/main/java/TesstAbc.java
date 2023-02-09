import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TesstAbc {


    private static double LogAbc(double a, int i) {
        try {
            System.out.println("a: " + a + ", index: " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            completableFutures.add(
                    CompletableFuture.runAsync(() -> {
                        double result = LogAbc(Math.random(), finalI);
                        System.out.println("finali: " + finalI + ", result: "+ result);
                    })
            );
        }
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).get();
        System.out.println("12312312312312321");
    }
}
