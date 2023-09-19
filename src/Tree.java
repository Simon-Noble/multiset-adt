import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class Tree<E> {

    private E root;

    private ArrayList<Tree<E>> subTrees;

    public Tree(E root, ArrayList<Tree<E>> subTrees ){
        this.root = root;

        this.subTrees = new ArrayList<>();

        if (subTrees != null){
            this.subTrees.addAll(subTrees);
        }
    }

    public Tree(E root){
        this.root = root;

        this.subTrees = new ArrayList<>();

    }

    public Tree(){
        this.root = null;

        this.subTrees = new ArrayList<>();

    }





    public boolean isEmpty() {
        return (this.root == null);
    }

    public int length(){
        if (this.isEmpty()){
            return 0;
        }
        int size = 1;

        for (Tree<E> subtree: subTrees){
            size += subtree.length();
        }
        return size;
    }

    public int count(E item){
        if (this.isEmpty()){
            return 0;
        }
        int num = 0;
        if (this.root == item){
            num ++;
        }

        for (Tree<E> subtree: this.subTrees){
            num += subtree.count(item);
        }
        return num;

    }

    public String string(){
        return this.strIndented(0);
    }


    private String strIndented(int depth){
        StringBuilder s = new StringBuilder();

        if (this.isEmpty()){
            return s.toString();
        }

        s.append(" ".repeat(Math.max(0, depth)));

        s.append(this.root.toString());
        s.append("\n");

        for (Tree<E> subtree: this.subTrees){
            s.append(subtree.strIndented(depth + 1));
        }
        return s.toString();
    }

    public float average(){

        if (this.isEmpty()){
            return 0.0f;
        }
        int[] helper = this.average_helper();
        int total = helper[0];
        int count = helper[1];
        return (float) total/count;

    }

    private int[] average_helper() {
        if (this.isEmpty()){
            return new int[]{0,0};
        }
        int total = (int) this.root;
        int size = 1;
        for (Tree<E> subtree: this.subTrees){
            int[] helper = subtree.average_helper();
            total += helper[0];
            size += helper[1];
        }
        return new int[]{total, size};

    }

    public boolean equals(Tree<E> other){

        if (this.isEmpty() && other.isEmpty()){
            return true;
        } else if (this.isEmpty() || other.isEmpty()){
            return false;
        }

        if (this.root != other.root){
            return false;
        }

        if(this.length() != other.length()){
            return false;
        }
        return this.subTrees.equals(other.subTrees);
    }
}
