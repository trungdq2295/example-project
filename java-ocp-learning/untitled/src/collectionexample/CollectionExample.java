package collectionexample;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CollectionExample {
}


class Base {
    public <T> List<T> transform(List<T> list) {
        return new ArrayList<T>();
    }
}

class Derived extends Base{

    public <T> ArrayList<T> transform(List<T> list) {
        return new ArrayList<T>();
    }


    public <T> Collection<T> transform(Collection<T> list) { return new HashSet<T>(); };
}