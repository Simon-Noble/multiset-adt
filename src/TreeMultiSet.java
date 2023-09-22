public class TreeMultiSet<E extends Comparable<E>> implements MultiSet<E> {


    private final Tree<E> tree;

    public TreeMultiSet(){
        this.tree = new Tree<>();
    }

    @Override
    public boolean add(E item) {
        this.tree.insert(item);
        return true;
    }

    @Override
    public void remove(E item) {
    this.tree.deleteItem(item);
    }

    @Override
    public boolean contains(E item) {
        return this.tree.contains(item);
    }

    @Override
    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    @Override
    public int count(E item) {
        return this.tree.count(item);
    }

    @Override
    public int size() {
        return this.tree.length();
    }
}
