
public abstract class MultiSet <E> {
    public abstract boolean add(E item);
    public abstract void remove(E item);

    public abstract boolean contains (E item);

    public abstract boolean isEmpty(E item);
    public abstract int count(E item);

    public abstract int size(E item);
}
