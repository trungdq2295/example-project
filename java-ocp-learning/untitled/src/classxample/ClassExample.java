package classxample;

import java.util.*;

public class ClassExample {
}


class Book {
    protected final int pages = 100;

    final void mA() {
        System.out.println("In B.mA " + pages);
    }

    private void mb(){

    }
}

class Encyclopedia extends Book {
    public int pages = 200; //1

    public void mb(){

    }


    public void m6(ArrayList<Book> strList){
        List<? extends Book> list = new ArrayList<>();
        strList.addAll(list);
    }
}