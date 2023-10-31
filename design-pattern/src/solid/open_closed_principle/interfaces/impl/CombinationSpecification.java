package solid.open_closed_principle.interfaces.impl;

import solid.open_closed_principle.interfaces.Specification;

public class CombinationSpecification<T> implements Specification<T> {

    private Specification<T> firstSpecification;
    private Specification<T> secondSpecification;

    public CombinationSpecification(Specification<T> firstSpecification, Specification<T> secondSpecification) {
        this.firstSpecification = firstSpecification;
        this.secondSpecification = secondSpecification;
    }

    @Override
    public boolean isSatisfied(T item) {
        return firstSpecification.isSatisfied(item) && secondSpecification.isSatisfied(item);
    }
}
