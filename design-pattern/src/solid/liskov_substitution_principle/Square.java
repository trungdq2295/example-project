package solid.liskov_substitution_principle;

public class Square extends Rectangle {

    public Square(int size) {
        super(size, size);
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }
}
