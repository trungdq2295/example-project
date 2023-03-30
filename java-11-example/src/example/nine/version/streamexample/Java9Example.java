package example.nine.version.streamexample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Java9Example {

    /*
        Stream the list until the element doesn't pass the predicate
     */
    public static void takeWhileExample(List<Integer> list, Predicate<Integer> predicate) {
        System.out.println("Take While");
        list.stream().takeWhile(predicate).forEach(System.out::println);
    }

    /*
        Stream the list and remove the element which passed the predicate until the element which doesn't pass
     */
    public static void dropWhileExample(List<Integer> list, Predicate<Integer> predicate) {
        System.out.println("Drop While");
        list.stream().dropWhile(predicate).forEach(System.out::println);
    }

    /*
        Stream to iterate a lít
     */
    public static void iterateExample(List<Integer> list) {
        System.out.println("Drop While");
//        list.stream().iterate(2, x -> x < 30, x -> 2 * x).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
        integerList.add(8);
        integerList.add(2);
        integerList.add(4);
        integerList.add(1);
        integerList.add(6);
        takeWhileExample(integerList, isEvenNumber);
        dropWhileExample(integerList, isEvenNumber);
    }
}
