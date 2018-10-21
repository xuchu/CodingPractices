package DataStructure;

import java.util.Stack;

public class BinarySearchTree {
    private Node root;

    public Boolean validateBST(Node root){
        Node current = root;
        Node prevous = null;
        Stack<Node> stack = new Stack<>();
        while( current != null || stack.size() > 0 ){
            while(current != null){
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            if( prevous == null ){
                prevous = current;
            }
            else if( prevous.getKey() < current.getKey() ){
                prevous = current;
            }
            else{
                return false;
            }
            current = current.getRight();
        }
        return true;
    }
}
