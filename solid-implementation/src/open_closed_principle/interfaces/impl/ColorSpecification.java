package open_closed_principle.interfaces.impl;

import open_closed_principle.enumeration.Color;
import open_closed_principle.interfaces.Specification;
import open_closed_principle.model.Product;

public class ColorSpecification implements Specification<Product> {

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getColor() == this.color;
    }
}
