//BST node class to create node objects for the tree 

public class BinaryNode<T extends Comparable<T>> {

    //Value of the node 
    public T data;

    //Left child
    public BinaryNode<T> left;

    //Right child
    public BinaryNode<T> right;

    //Constructor 
    public BinaryNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Copy constructor 
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    //Converts node to string representation
    public String toString() {
        String leftString = (left == null) ? "N" : left.data.toString();
        String rightString = (right == null) ? "N" : right.data.toString();
        String out = "[" + leftString + "]<-[" + data.toString() + "]->[" + rightString + "]";

        return out;
    }

}