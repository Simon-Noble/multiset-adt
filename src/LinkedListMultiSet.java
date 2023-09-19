import java.util.*;

public class LinkedListMultiSet <E> extends MultiSet <E>{

    private class Node{
        public E item;
        public Node next;

        public Node(E item){
            this.item = item;
            this.next = null;
        }
    }

    private Node front;
    private int size;


    public LinkedListMultiSet(){
        this.front = null;
        this.size = 0;
    }

    @Override
    public boolean add(E item) {
        Node newNode = new Node(item);
        newNode.next = this.front;
        this.front = newNode;
        this.size ++;
        return true;
    }

    @Override
    public void remove(E item) {
        Node curr = this.front;
        Node prev = null;

        while (curr != null){
            if (curr.item == item){
                this.size -= 1;
                if (prev != null){
                    prev.next = curr.next;
                }
                else {
                    this.front = curr.next;
                }
                return;

            }
            prev = curr;
            curr = curr.next;
        }


    }

    @Override
    public boolean contains(E item) {
        Node curr = this.front;
        while (curr != null){
            if (curr.item == item){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int count(E item) {
        int numSeen = 0;
        Node cur = this.front;
        while (cur != null){
            if (cur.item == item){
                numSeen ++;
            }
            cur = cur.next;
        }
        return numSeen;
    }

    @Override
    public int size() {
        return this.size;
    }
}
