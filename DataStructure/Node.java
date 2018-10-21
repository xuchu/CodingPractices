package DataStructure;

public class Node {
    private int key;
    private Node left, right;

    public Node(int i){
        key = i;
    }

    public int getKey(){
        return key;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }
}
