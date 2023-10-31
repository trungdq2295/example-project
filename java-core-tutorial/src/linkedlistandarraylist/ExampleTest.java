package linkedlistandarraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExampleTest {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>(1);
        List<Integer> linkedList = new LinkedList<Integer>();

        // Thêm phần tử vào ArrayList
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            arrayList.add(0,i);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("ArrayList thêm:  " + duration);

        // Thêm phần tử vào LinkedList
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            linkedList.add(0,i);
        }

        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("LinkedList thêm: " + duration);
        System.out.println("LinkedList thêm: " + linkedList.get(5));
    }
}
