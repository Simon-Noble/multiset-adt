import java.util.ArrayList;

public class ArrayListMultiSet <E extends Comparable<E>> implements MultiSet<E> {


    ArrayList<E> list;

    public ArrayListMultiSet(){
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(E item) {
        this.list.add(item);
        return true;
    }

    @Override
    public void remove(E item) {
        this.list.remove(item);

    }

    @Override
    public boolean contains(E item) {
        return this.list.contains(item);
    }



    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int count(E item) {
        int count = 0;
        for (E i : this.list){
            if (i == item){
                count ++;
            }
        }
        return count;
    }


    @Override
    public int size() {
        return this.list.size();
    }
}
