package streamexample;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {


    public static void main(String[] args) {
        int[][] iaa = { {1, 2}, {3, 4}, { 5, 6} };
        var count = Stream.of(iaa).flatMapToInt(x -> IntStream.of(x))
                .map(i -> i + 1)
                .filter(i -> i%2 != 0)
                .peek(System.out::print)
                .count();
        System.out.println(count);
    }
}
