package solid.open_closed_principle.interfaces;

public interface Specification<T> {

    boolean isSatisfied(T item);

}
