package open_closed_principle;

import open_closed_principle.enumeration.Color;
import open_closed_principle.enumeration.Size;
import open_closed_principle.interfaces.impl.BetterFilter;
import open_closed_principle.interfaces.impl.ColorSpecification;
import open_closed_principle.interfaces.impl.CombinationSpecification;
import open_closed_principle.interfaces.impl.SizeSpecification;
import open_closed_principle.model.Product;
import open_closed_principle.model.ProductFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        var tree = new Product("Tree", Color.BLUE, Size.HUGE);
        var apple = new Product("Apple", Color.RED, Size.LARGE);
        var mango = new Product("Mango", Color.GREEN, Size.SMALL);

        List<Product> list = new ArrayList<>();
        list.add(tree);
        list.add(apple);
        list.add(mango);

        // Work but wrong since the more filter we have, the more function we have
        System.out.println("Filter By Size: " + ProductFilter.filterByColor(list, Color.BLUE).collect(Collectors.toList()).get(0).getName());

        BetterFilter bf = new BetterFilter();
        bf.filter(list, new ColorSpecification(Color.BLUE)).forEach(p -> System.out.println("p: " + p.getName()));

        bf.filter(list,
                new CombinationSpecification<>(
                        new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.HUGE))
        ).forEach(p -> System.out.println("p123: " + p.getName()));
    }
}
