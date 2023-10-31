package open_closed_principle.interfaces.impl;

import open_closed_principle.enumeration.Color;
import open_closed_principle.enumeration.Size;
import open_closed_principle.interfaces.Specification;
import open_closed_principle.model.Product;

public class SizeSpecification implements Specification<Product> {

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getSize() == this.size;
    }
}
