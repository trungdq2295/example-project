package example.utils;

public class ThreadUtils {

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 100);
        } catch (Exception e) {

        }
    }
}
