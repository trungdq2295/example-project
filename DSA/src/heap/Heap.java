package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {


    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return leftChild(index) + 1;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        int parentIndex = parent(currentIndex);
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parentIndex)) {
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = parent(currentIndex);
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int maxHeap = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return maxHeap;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(maxIndex);
            int rightIndex = rightChild(maxIndex);
            if (leftIndex < heap.size() && heap.get(maxIndex) < heap.get(leftIndex)) {
                maxIndex = leftChild(maxIndex);
            }
            if (rightIndex < heap.size() && heap.get(maxIndex) < heap.get(rightIndex)) {
                maxIndex = rightChild(maxIndex);
            }
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }

    }
}
