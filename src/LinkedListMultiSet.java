import java.security.cert.TrustAnchor;

public class LinkedListMultiSet extends MultiSet{

    private class Node{
        public Object item;
        public Node next;

        public Node(Object item){
            this.item = item;
            this.next = null;
        }
    }

    private Node front;
    private int size;


    @Override
    public boolean add(Object item) {
        Node newNode = new Node(item);
        newNode.next = this.front;
        this.front = newNode;
        this.size ++;
        return true;
    }

    @Override
    public void remove(Object item) {
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
        return;

    }

    @Override
    public boolean contains(Object item) {
        Node curr = this.front;
        while (curr != null){
            if (curr.item == item){
                return true
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty(Object item) {
        return this.size == 0;
    }

    @Override
    public int count(Object item) {
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
    public int size(Object item) {
        return this.size;
    }
}
