/**
 * Created by ayush on 16/6/16.
 */
import  java.util.*;

public class BinaryTree {
    private TNode root;
    public TNode getRoot(){
        return root;
    }
    public void setRoot(TNode root){
        this.root = root;
    }

    // Create a sample Binary Tree
//                          1
//                        /   \
//                       2     3
//                      /     /  \
//                     4     5    6
//                    / \     \   /
//                   7   8     9 10

    public static TNode createSampleTree(){
        TNode root = new TNode(1);
        TNode a = new TNode(2);
        TNode b = new TNode(3);
        TNode c = new TNode(4);
        TNode d = new TNode(5);
        TNode e = new TNode(6);
        TNode f = new TNode(7);
        TNode g = new TNode(8);
        TNode h = new TNode(9);
        TNode i = new TNode(10);
        root.setLeft(a);
        root.setRight(b);
        a.setLeft(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        d.setRight(h);
        e.setLeft(i);
        return root;
    }

    // Recursive InOrder Traversal
    public static void inOrderTraversal(TNode root){
        if(root != null){
            inOrderTraversal(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderTraversal(root.getRight());
        }
    }

    // Level Order Traversal
    public static void levelOrderTraversal(TNode root){
        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TNode node = queue.remove();
            System.out.print(node.getData() + " ");
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if(node.getRight() != null){
                queue.add(node.getRight());
            }
        }
    }

    // Spiral Order Traversal Using Two Stacks (stackEven & stackOdd)
    public static void spiralOrderTraversalUsingTwoStacks(TNode root){
        Stack<TNode> stackEven = new Stack<TNode>();
        Stack<TNode> stackOdd = new Stack<TNode>();
        boolean evenLevel  = true;
        stackEven.push(root);
        while(!stackEven.isEmpty() || !stackOdd.isEmpty()){
            if(evenLevel){
                while(!stackEven.isEmpty()){
                    TNode node = stackEven.pop();
                    System.out.print(node.getData() + " ");
                    if(node.getRight() != null){
                        stackOdd.push(node.getRight());
                    }
                    if(node.getLeft() != null){
                        stackOdd.push(node.getLeft());
                    }
                }
            }
            else{
                while(!stackOdd.isEmpty()){
                    TNode node = stackOdd.pop();
                    System.out.print(node.getData() + " ");
                    if(node.getLeft() != null){
                        stackEven.push(node.getLeft());
                    }
                    if(node.getRight() != null){
                        stackEven.push(node.getRight());
                    }
                }
            }
            evenLevel = !evenLevel;
        }
    }

    // Height of Binary Tree
    public static int heightOfTree(TNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.getLeft());
        int rightHeight = heightOfTree(root.getRight());
        return 1 + Math.max(leftHeight,rightHeight);
    }

    // Driver Method AKA Main Method
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.setRoot(createSampleTree());
//        System.out.println("In Order Traversal");
//        inOrderTraversal(tree.root);
//        System.out.println("Level Order Traversal");
//        levelOrderTraversal(tree.root);
//        System.out.println("Spiral Order Traversal");
//        spiralOrderTraversalUsingTwoStacks(tree.root);
        System.out.println("Height of tree : " + heightOfTree(tree.root));
    }
}
