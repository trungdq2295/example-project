package solid.open_closed_principle.interfaces.impl;

import solid.open_closed_principle.interfaces.Filter;
import solid.open_closed_principle.interfaces.Specification;
import solid.open_closed_principle.model.Product;

import java.util.List;
import java.util.stream.Stream;

public class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> item) {
        return items.stream().filter(item::isSatisfied);
    }
}
