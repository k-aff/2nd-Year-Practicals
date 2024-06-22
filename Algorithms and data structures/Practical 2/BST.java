/*
    Outcomes for practical 2:

    • Recursion
    • Standard Binary Search Trees (BST) including:
        – Inserting data into BSTs
        – Simple traversals of BSTs
        – Removing data from BSTs– Special/Niche traversals of BST
*/

/* 
    Binary Search Tree class that implements a BST data structure using recursion.
    Uses the node class to create node objects contained in the tree.
    Provides basic BST methods and some niche traversals .
*/

public class BST<T extends Comparable<T>> {

    //Root of the BST
    public BinaryNode<T> root;


    //Default constructor - intialises root to null
    public BST() {
        root = null;
    }

    //Deletes selected node from the tree 
    public void delete(T data) {

        if (contains(data))
            deleteHelper(root, data);
    }

    //Checks if a certain value is contained in the tree
    public boolean contains(T data) {

        return containsHelper(root, data);
    }

    //Inserts a new node with the given data 
    public void insert(T data) {

        if (root == null) { // tree is empty;
            root = new BinaryNode<T>(data);
            return;
        } else {
            insertHelper(root, data);
        }
    }

    //Calculates the height of the tree
    public int getHeight() {

        if (root == null) {
            return 0;
        } else {
            return getHeightHelper(root);
        }
    }

    //Determines the path taken to find a node with the given value in the tree
    public String printSearchPath(T data) {
        
        return printSearchPathHelper(root,data);
    }

    //Counts the number of leaf nodes in the tree 
    public int getNumLeaves() {
        
        return getNumLeavesHelper(root);
    }

    //Extracts biggest superficially balanced tree (tree in which for each subtree, the left branch has the same number of nodes as the right branch)
    public BST<T> extractBiggestSuperficiallyBalancedSubTree() {
        
        if(root==null)
        {
            return null;
        }
        else
        {
            int[] MaxSubNodes = {0};
            BinaryNode<T>[] specialNode = null;
            return extractBiggestSuperficiallyBalancedSubTreeH1(root,specialNode,MaxSubNodes);
        }
    }

    //Gets the node with the given data if such a node exists 
    public BinaryNode<T> getNode(T data) {
        
        if (!contains(data)) {
            return null;
        } else {
            return getNodeHelper(root, data);
        }
    }

    //Determines whether for each subtree the left and right branches have the same number of nodes
    public boolean isSuperficiallyBalanced() {
        
        if (root == null) {
            return false;
        }

        int numR[] = { 0 };
        int numL[] = { 0 };

        if (root.right != null) {

            numR[0]++;
            numR = isSuperficiallyBalancedHelper(root.right, numR);
        }

        if (root.left != null) {
            numL[0]++;
            numL = isSuperficiallyBalancedHelper(root.left, numL);
        }

        return (numR[0] == numL[0]);
    }

    //Finds the node with the largest value
    public BinaryNode<T> findMax() {
        
        if(root==null)
            return null;
        else
            return findMaxHelper(root);
    }

    //Finds the node with the smallest value 
    public BinaryNode<T> findMin() {
        
        if(root==null)
            return null;
        else
            return findMinHelper(root);
    }

    //Helper functions

    public BinaryNode<T> insertHelper(BinaryNode<T> p, T data) {

        if (p == null) {
            return new BinaryNode<T>(data);
        }

        int result = data.compareTo(p.data);

        if (result < 0) {

            p.left = insertHelper(p.left, data);

        } else if (result > 0) {
            p.right = insertHelper(p.right, data);

        }

        return p;
    }

    public BinaryNode<T> deleteHelper(BinaryNode<T> n, T data) {

        if (n == null)
            return n;

        int result = data.compareTo(n.data);

        if (result < 0) {

            n.left = deleteHelper(n.left, data);

        } else if (result > 0) {

            n.right = deleteHelper(n.right, data);

        } else if (n.left != null && n.right != null) {

            n.data = findMinHelper(n.right).data;
            n.right = deleteHelper(n.right, n.data);

        } else 
            n = (n.left != null) ? n.left : n.right;

        return n;
        
    }

    public boolean containsHelper(BinaryNode<T> n, T data) {

        if (n == null) {
            return false;
        }

        int result = data.compareTo(n.data);

        if (result < 0) {
            return containsHelper(n.left, data);
        } else if (result > 0) {
            return containsHelper(n.right, data);
        } else
            return true;
    }

    public int getHeightHelper(BinaryNode<T> n) {

        int[] minHeight = { 1 };
        int[] maxHeight = { 1 };

        findMaxHelperForHeight(n, maxHeight);

        findMinHelperForHeight(n, minHeight);

        return (maxHeight[0] > minHeight[0]) ? maxHeight[0] : minHeight[0];

    }

    public String printSearchPathHelper(BinaryNode<T> n,T data){
        
        if (n == null) {
            return "Null";
        }
        
        int result = data.compareTo(n.data);

        if (result < 0) {

            return ( n.data.toString() + " -> " +printSearchPathHelper(n.left, data));

        } else if (result > 0) {
            
            return ( n.data.toString() +  " -> " +printSearchPathHelper(n.right, data));
        }
        else if(result == 0){

            return data.toString();
        }
        else{

            return " -> Null";
        }

    }

    public int getNumLeavesHelper(BinaryNode<T> n) {

        if(n==null){
            return 0;
        }
        else if (n.left==null && n.right==null) {
            return 1;
        } 
        else if (n.left != null) {
            //n = n.left;
            return (getNumLeavesHelper(n.left) + getNumLeavesHelper(n.right));
        }
        else if (n.right != null) {
            //n = n.right;
            return (getNumLeavesHelper(n.left) + getNumLeavesHelper(n.right));
        }

        return 0;
    }

    public BinaryNode<T> getNodeHelper(BinaryNode<T> n, T data) {

        if (n == null) {
            return null;
        } else if (n.data.compareTo(data) == 0) {
            return n;
        } else if (data.compareTo(n.data) < 0) {
            return getNodeHelper(n.left, data);

        } else if (data.compareTo(n.data) > 0) {
            return getNodeHelper(n.right, data);
        }
        return null;
    }

    public BST<T> extractBiggestSuperficiallyBalancedSubTreeH1(BinaryNode<T> n, BinaryNode<T> specialNode[], int[] MaxSubNodes) {

        BST<T> toReturn = new BST<T>();
            
        biggestSFBSubTree(n, specialNode, MaxSubNodes);

        if(specialNode[0]!= null){
            return createBiggestSFBSubTree(specialNode[0],toReturn);
        }else{
            return null;
        }
    }


    public void biggestSFBSubTree(BinaryNode<T> n, BinaryNode<T>[] specialNode, int[] subNodes){

        if(n != null){
            if(SFBSubTree(n)){
                int numLeaves = getNumLeavesHelper(n);
                if(numLeaves > subNodes[0]){
                    subNodes[0] = numLeaves;
                    specialNode[0] = n;
                }
            }
            biggestSFBSubTree(n.left, specialNode, subNodes);
            biggestSFBSubTree(n.right, specialNode, subNodes);
        }
    }

    public BST<T> createBiggestSFBSubTree(BinaryNode<T> n, BST<T> tree){

        if(n!=null){
            tree.insert(n.data);
            createBiggestSFBSubTree(n.left, tree);
            createBiggestSFBSubTree(n.right, tree);
        }
        return tree;
    }

    public boolean SFBSubTree(BinaryNode<T> n) {

        if (n == null) {
            return false;
        }

        int numR[] = { 0 };
        int numL[] = { 0 };

        if (n.right != null) {

            numR[0]++;
            numR = isSuperficiallyBalancedHelper(n.right, numR);
        }

        if (n.left != null) {
            numL[0]++;
            numL = isSuperficiallyBalancedHelper(n.left, numL);
        }

        return (numR[0] == numL[0]);
    }

    public int[] isSuperficiallyBalancedHelper(BinaryNode<T> n, int[] num) {

        if (n.right != null) {
            num[0]++;
            n = n.right;
            isSuperficiallyBalancedHelper(n, num);
        }

        if (n.left != null) {
            num[0]++;
            n = n.left;
            isSuperficiallyBalancedHelper(n, num);
        }

        return num;
    }

    public BinaryNode<T> findMaxHelper(BinaryNode<T> n) {

        if (n == null) {
            return null;
        } else if (n.right == null) {
            return n;
        }

        return findMaxHelper(n.right);
    }

    public BinaryNode<T> findMinHelper(BinaryNode<T> n) {

        if (n == null) {
            return null;
        } else if (n.left == null) {
            return n;
        }
        return findMinHelper(n.left);
    }

    public int[] findMaxHelperForHeight(BinaryNode<T> n, int[] num) {

        if (n != null) {

            if (n.right != null) {
                num[0]++;
                n = n.right;
                findMaxHelperForHeight(n, num);
            } else if (n.left != null) {
                num[0]++;
                n = n.left;
                findMinHelperForHeight(n, num);
            }
        }

        return num;
    }

    public int[] findMinHelperForHeight(BinaryNode<T> n, int[] num) {

        if (n != null) {

            if (n.left != null) {
                num[0]++;
                n = n.left;
                findMinHelperForHeight(n, num);
            } else if (n.right != null) {
                num[0]++;
                n = n.right;
                findMaxHelperForHeight(n, num);
            }
        }

        return num;
    }


    ///////////////

    private StringBuilder toString(BinaryNode<T> node, StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (node.right != null) {
            toString(node.right, new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.data.toString()).append("\n");
        if (node.left != null) {
            toString(node.left, new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return root == null ? "Empty tree" : toString(root, new StringBuilder(), true, new StringBuilder()).toString();
    }

}
