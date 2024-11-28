package ExampleClassCast;

import java.util.List;

class Booby {
}

class Dooby extends Booby {
}

class Tooby extends Dooby {
}

public class ExampleClassCast {
    Booby b = new Booby();
    Tooby t = new Tooby();

    public void do1(List<Booby> dataList) {
        dataList.add(t);
    }

    public void do2(List<? extends Dooby> dataList) {
        b = dataList.get(0);
    }
}

