import java.util.ArrayList;

public class Tree<E> {

    private E root;

    private ArrayList<Tree> subTrees;

    public Tree(E root, ArrayList<Tree> subTrees ){
        this.root = root;

        this.subTrees = new ArrayList<>();

        if (subTrees != null){
            for (Tree tree: subTrees){
                this.subTrees.add(tree);
            }
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
    }


}
