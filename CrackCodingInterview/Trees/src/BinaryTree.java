
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

    // Create sample tree 2
//                             1
//                           /   \
//                          2     3
//                         /     / \
//                        4     5   6
//                       /  \
//                      7    8
//                          / \
//                         9   10

    public static TNode createSampleTree2(){
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
        g.setLeft(h);
        g.setRight(i);
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
        if(root == null){
            return;
        }
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
    // Level Order Traversal Line by Line
    public static void levelOrderTraversalLineByLine(TNode root){
        if(root == null){
            return;
        }
        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                TNode node = queue.remove();
                System.out.print(node.getData() + " ");
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
                count--;
            }
            System.out.println();
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

    // Height of Binary Tree using Level Order Traversal
    public static int heightOfTreeUsingLevelOrder(TNode root){
        if(root == null){
            return 0;
        }
        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(root);
        int height = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            height++;
            while(count > 0){
                TNode node = queue.remove();
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
                count--;
            }
        }
        return height;
    }

    // Minimum depth of tree (Number of nodes in the shortest path from root to any leaf)
    public static int minDepth(TNode root){

        // This case will be hit only if the function is called initially with null root
        if(root == null){
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        if(root.getLeft() == null){
            return 1 + minDepth(root.getRight());
        }
        if(root.getRight() == null){
            return 1 + minDepth(root.getLeft());
        }
        return 1 + Math.min(minDepth(root.getLeft()),minDepth(root.getRight()));
    }

    // Minimum depth of tree using Level Order Traversal
    public static int minDepthUsingLevelOrderTraversal(TNode root){
        if(root == null){
            return 0;
        }
        int minDepth = 0;
        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(root);
        while(true){
            int count = queue.size();
            minDepth++;
            while(count > 0){
                TNode node = queue.remove();
                if(node.getLeft() == null && node.getRight() == null){
                    return minDepth;
                }
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
                count--;
            }
        }
    }

    // Size of tree (Number of Nodes in the tree)
    public static int sizeOfTree(TNode root){
        if(root == null){
            return 0;
        }
        int leftSize = sizeOfTree(root.getLeft());
        int rightSize = sizeOfTree(root.getRight());
        return 1 + leftSize + rightSize;
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
//        System.out.println("Height of tree : " + heightOfTree(tree.root));
        BinaryTree tree2 = new BinaryTree();
        tree2.setRoot(createSampleTree2());
//        System.out.println("Height of tree2 using Level Order " + heightOfTreeUsingLevelOrder(tree2.getRoot()));
//        System.out.println("Height of tree2 using recursion " + heightOfTree(tree2.getRoot()));
//        System.out.println("Level Order traversal line by line of tree2 ");
//        levelOrderTraversalLineByLine(tree2.getRoot());
//        System.out.println();
//        System.out.println("Minimum Depth of tree2 using Level Order Traversal " + minDepthUsingLevelOrderTraversal(tree2.getRoot()));
//        System.out.println("Minimum Depth of tree using Level Order Traversal " + minDepthUsingLevelOrderTraversal(tree.getRoot()));
//        System.out.println("Minimum Depth of tree using recursion " + minDepth(tree.getRoot()));
//        System.out.println("Minimum Depth of tree2 using recursion " + minDepth(tree2.getRoot()));
        System.out.println("Size of tree " + sizeOfTree(tree.getRoot()));
        System.out.println("Size of tree2 " + sizeOfTree(tree2.getRoot()));


    }
}
