package design_pattern.structure.composite;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class Excercise {
    public static void main(String[] args) {
        List<ValueContainer> list = new ArrayList<>();
        ManyValues manyValues = new ManyValues();
        manyValues.add(5);
        manyValues.add(6);
        manyValues.add(7);
        list.add(new SingleValue(4));
        list.add(manyValues);
        MyList myList = new MyList(list);
        System.out.println(myList.sum());
    }
}


interface ValueContainer extends Iterable<Integer> {
    default int sum() {
        int result = 0;
        for (Integer integer : this) {
            result = result + integer;
        }
        return result;
    }
}

class SingleValue implements ValueContainer {
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value) {
        this.value = value;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(this.value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(this.value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
}


class MyList extends ArrayList<ValueContainer> {
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        int result = 0;
        for (ValueContainer valueContainer : this) {
            result = result + valueContainer.sum();
        }
        return result;
    }
}