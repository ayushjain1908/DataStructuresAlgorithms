
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

      // Create sample tree 3
//                             12
//                           /   \
//                          10    30
//                               / \
//                             25   26
//
//
   public static TNode createSampleTree3(){
       TNode root = new TNode(12);
       TNode a = new TNode(10);
       TNode b = new TNode(30);
       TNode c = new TNode(25);
       TNode d = new TNode(26);
       root.setLeft(a);
       root.setRight(b);
       b.setLeft(c);
       b.setRight(d);
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

    // Sum of all Nodes
    public static int sumOfNodes(TNode root){
        if(root == null){
            return 0;
        }
        int lSum = sumOfNodes(root.getLeft());
        int rSum = sumOfNodes(root.getRight());
        return (root.getData() + lSum + rSum);
    }

    // Count Leaves
    public static int countLeaves(TNode root){
        if(root == null){
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        int lCount = countLeaves(root.getLeft());
        int rCount = countLeaves(root.getRight());
        return lCount + rCount;
    }

    // Sum of Leaves
    public static int sumOfLeaves(TNode root){
        if(root == null){
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return root.getData();
        }
        int lSum = sumOfLeaves(root.getLeft());
        int rSum = sumOfLeaves(root.getRight());
        return lSum + rSum;
    }

    // Check if the node is a leaf node
    public static boolean isLeaf(TNode node){
        if(node== null){
            return false;
        }
        if(node.getLeft() == null && node.getRight() == null ){
            return true;
        }
        return false;
    }

    // Sum of left leaves
    public static int sumOfLeftLeaves(TNode root){
        int res = 0;
        if(root == null){
            return 0;
        }
        if(isLeaf(root.getLeft())){
            res += root.getLeft().getData();
        }
        else{
            res += sumOfLeftLeaves(root.getLeft());
        }
        res += sumOfLeftLeaves(root.getRight());
        return res;
    }

    // Sum of right leaves
    public static int sumOfRightLeaves(TNode root){
        int res = 0;
        if(root == null){
            return 0;
        }
        if(isLeaf(root.getRight())){
            res += root.getRight().getData();
        }
        else{
            res += sumOfRightLeaves(root.getRight());
        }
        res += sumOfRightLeaves(root.getLeft());
        return res;
    }

    // Left View of a Tree
    public static void leftView(TNode root){
        IntegerWrapper maxLevel = new IntegerWrapper();
        maxLevel.value = -1;
        leftViewUtil(root,0,maxLevel);
    }
    // Util for Left View of Tree
    public static void leftViewUtil(TNode root,int level,IntegerWrapper maxLevel){
        if(root == null){
            return;
        }
        if(level > maxLevel.value){
            maxLevel.value = level;
            System.out.print(root.getData() + " ");
        }
        leftViewUtil(root.getLeft(),level + 1,maxLevel);
        leftViewUtil(root.getRight(),level + 1,maxLevel);
    }

    // Left View of a tree using Level Order Traversal
    public static void leftViewUsingLevelOrder(TNode root){
        if(root == null){
            return;
        }
        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            TNode node = queue.remove();
            count--;
            System.out.print(node.getData() + " ");
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if(node.getRight() != null){
                queue.add(node.getRight());
            }
            while(count > 0){
                node =  queue.remove();
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

    // Right View of a Tree
    public static void rightView(TNode root){
        IntegerWrapper maxLevel = new IntegerWrapper();
        maxLevel.value = -1;
        rightViewUtil(root,0,maxLevel);
    }
    // Util for Right View of Tree
    public static void rightViewUtil(TNode root,int level,IntegerWrapper maxLevel){
        if(root == null){
            return;
        }
        if(level > maxLevel.value){
            maxLevel.value = level;
            System.out.print(root.getData() + " ");
        }
        rightViewUtil(root.getRight(),level+1,maxLevel);
        rightViewUtil(root.getLeft(),level + 1,maxLevel);
    }

    // Right View of a tree using Level Order Traversal
    public static void rightViewUsingLevelOrder(TNode root){
        if(root == null){
            return;
        }
        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            TNode node = queue.remove();
            count--;
            System.out.print(node.getData() + " ");
            if(node.getRight() != null){
                queue.add(node.getRight());
            }
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }

            while(count > 0){
                node =  queue.remove();
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                count--;
            }
        }
    }

    // Vertical Order of Tree , Print from left to right and top to bottom
    //  TreeMap instead of HashMap must be used because TreeMap puts and gets the keys in sorted order which is required for
    //  left to right printing
    public static void verticalOrder(TNode root){
        if(root == null){
            return;
        }
        TreeMap<Integer,ArrayList<Integer>> vMap = new TreeMap<>();
        fillVerticalOrderMap(root,0,vMap);
        for(Map.Entry<Integer,ArrayList<Integer>> entry : vMap.entrySet()){
            ArrayList<Integer> l = entry.getValue();
            System.out.print("Horizontal Distance " + entry.getKey() + " : ");
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    // Helper Method to fill up the Vertical Order Map,Only Level Order Traversal can print the result in correct order
    private static void fillVerticalOrderMap(TNode root,int hd,TreeMap<Integer,ArrayList<Integer>> vMap){
        LinkedList<QueueEntry> queue = new LinkedList<>();
        QueueEntry entry = new QueueEntry(hd,root);
        queue.add(entry);
        while(!queue.isEmpty()){
           entry = queue.remove();
            TNode node = entry.node;
            int dist = entry.hd;
            ArrayList<Integer> list = vMap.get(dist);
            if(list == null){
                list = new ArrayList<>();
                list.add(node.getData());
                vMap.put(dist,list);
            }
            else{
                list.add(node.getData());
                vMap.put(dist,list);
            }
            if(node.getLeft() != null){
                queue.add(new QueueEntry(dist-1,node.getLeft()));
            }
            if(node.getRight() != null){
                queue.add(new QueueEntry(dist + 1,node.getRight()));
            }
        }
    }

    // Vertical Sum of a tree
    public static void verticalSum(TNode root){
        HashMap<Integer,Integer> map = new HashMap<>();
        verticalSumUtil(root,0,map);
        System.out.println(map.entrySet());
    }
    // Util for Vertical Sum
    public static void verticalSumUtil(TNode root,int hd,HashMap<Integer,Integer> map){
        if(root == null){
            return;
        }
        if(map.get(hd) == null){
            map.put(hd,root.getData());
        }
        else{
            map.put(hd,root.getData() + map.get(hd));
        }
        verticalSumUtil(root.getLeft(),hd - 1,map);
        verticalSumUtil(root.getRight(),hd + 1,map);

    }

    // Bottom View of Tree
    public static void bottomViewUsingLevelOrder(TNode root){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        bottomViewUsingLevelOrderUtil(root,0,map);
//        System.out.println(map.entrySet());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
    }
    // Util for Bottom View
    private static void bottomViewUsingLevelOrderUtil(TNode root,int hd,TreeMap<Integer,Integer> map){
        if(root == null){
            return;
        }
        LinkedList<QueueEntry> queue = new LinkedList<>();
        queue.add(new QueueEntry(hd,root));
        while(!queue.isEmpty()){
            QueueEntry entry = queue.remove();
            TNode node = entry.node;
            hd = entry.hd;
            map.put(hd,node.getData());
            if(node.getLeft() != null){
                queue.add(new QueueEntry(hd - 1,node.getLeft()));
            }
            if(node.getRight() != null){
                queue.add(new QueueEntry(hd + 1, node.getRight()));
            }
        }
    }

    // Top View of Tree,Not Printing from left to right
    public static void topViewAnyOrderUsingLevelOrder(TNode root){
        if(root == null){
            return;
        }
        int hd = 0;
        HashSet<Integer> set = new HashSet<>();
        LinkedList<QueueEntry> queue = new LinkedList<>();
        queue.add(new QueueEntry(hd,root));
        while(!queue.isEmpty()){
            QueueEntry entry = queue.remove();
            TNode node = entry.node;
            hd = entry.hd;
            if(!set.contains(hd)){
                System.out.print(node.getData() + " ");
                set.add(hd);
            }
            if(node.getLeft() != null){
                queue.add(new QueueEntry(hd - 1,node.getLeft()));
            }
            if(node.getRight() != null){
                queue.add(new QueueEntry(hd + 1, node.getRight()));
            }
        }
    }

    // Top View of Tree Using Level Order,printing from left to right
    public static void topViewUsingLevelOrder(TNode root){
        if(root == null)
            return;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        topViewUsingLevelOrderUtil(root,0,map);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
    }

    // Util for Top View Using Level Order Traversal
    private static void topViewUsingLevelOrderUtil(TNode root,int hd,TreeMap<Integer,Integer> map){
        LinkedList<QueueEntry> queue = new LinkedList<>();
        queue.add(new QueueEntry(hd,root));
        while(!queue.isEmpty()){
            QueueEntry entry = queue.remove();
            TNode node = entry.node;
            hd = entry.hd;
            if(!map.containsKey(hd)){
                map.put(hd,node.getData());
            }
            if(node.getLeft() != null){
                queue.add(new QueueEntry(hd - 1,node.getLeft()));
            }
            if(node.getRight() != null){
                queue.add(new QueueEntry(hd + 1,node.getRight()));
            }
        }

    }

    // Bottom View Of Tree Using DFS
    public static void bottomViewUsingDFS(TNode root){
        if(root == null){
            return;
        }
        TreeMap<Integer,MapEntry> map = new TreeMap<>();
        bottomViewUsingDFSUtil(root,0,0,map);
        for(Map.Entry<Integer,MapEntry> entry : map.entrySet()){
            System.out.print(entry.getValue().nodeValue + " ");
        }
    }
    // Util for Bottom View Of Tree Using DFS
    private  static void bottomViewUsingDFSUtil(TNode root,int hd,int level,TreeMap<Integer,MapEntry> map){
        if(root == null){
            return;
        }
        MapEntry entry = map.get(hd);
        if(entry == null){
            map.put(hd,new MapEntry(level,root.getData()));
        }
        else{
            if(entry.nodeLevel <= level){
                map.put(hd,new MapEntry(level,root.getData()));
            }
        }
        bottomViewUsingDFSUtil(root.getLeft(),hd - 1,level + 1,map);
        bottomViewUsingDFSUtil(root.getRight(),hd + 1,level + 1,map);

    }

    // Top View Of Tree Using DFS
    public static void topViewUsingDFS(TNode root){
        if(root == null){
            return;
        }
        TreeMap<Integer,MapEntry> map = new TreeMap<>();
        topViewUsingDFSUtil(root,0,0,map);
        for(Map.Entry<Integer,MapEntry> entry : map.entrySet()){
            System.out.print(entry.getValue().nodeValue + " ");
        }
    }
    // Util for Top View Of Tree Using DFS
    private  static void topViewUsingDFSUtil(TNode root,int hd,int level,TreeMap<Integer,MapEntry> map){
        if(root == null){
            return;
        }
        MapEntry entry = map.get(hd);
        if(entry == null){
            map.put(hd,new MapEntry(level,root.getData()));
        }
        else{
            if(entry.nodeLevel >= level){
                map.put(hd,new MapEntry(level,root.getData()));
            }
        }
        topViewUsingDFSUtil(root.getLeft(),hd - 1,level + 1,map);
        topViewUsingDFSUtil(root.getRight(),hd + 1,level + 1,map);

    }

    // Helper Class
    static class QueueEntry{
        int hd;
        TNode node;
        QueueEntry(int hd,TNode node){
            this.hd = hd;
            this.node = node;
        }
    }
    // Helper Class
    static class MapEntry{
        int nodeValue;
        int nodeLevel;
        MapEntry(int nodeLevel,int nodeValue){
            this.nodeLevel = nodeLevel;
            this.nodeValue = nodeValue;
        }
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
//        System.out.println("Size of tree " + sizeOfTree(tree.getRoot()));
//        System.out.println("Size of tree2 " + sizeOfTree(tree2.getRoot()));
//        System.out.println("Sum of nodes in tree " + sumOfNodes(tree.getRoot()));
//        System.out.println("Sum of nodes in tree2 " + sumOfNodes(tree2.getRoot()));
//        System.out.println("Number of leaves in tree " + countLeaves(tree.getRoot()));
//        System.out.println("Number of leaves in tree2 " + countLeaves(tree2.getRoot()));
//        System.out.println("Sum of  leaves in tree " + sumOfLeaves(tree.getRoot()));
//        System.out.println("Sum of leaves in tree2 " + sumOfLeaves(tree2.getRoot()));
//        System.out.println("Sum of  left leaves in tree " + sumOfLeftLeaves(tree.getRoot()));
//        System.out.println("Sum of left leaves in tree2 " + sumOfLeftLeaves(tree2.getRoot()));
//        System.out.println("Sum of  right leaves in tree " + sumOfRightLeaves(tree.getRoot()));
//        System.out.println("Sum of right leaves in tree2 " + sumOfRightLeaves(tree2.getRoot()));
//        BinaryTree tree3 = new BinaryTree();
//        tree3.setRoot(createSampleTree3());
//        System.out.println("Left view of tree3 ");
//        System.out.println();
//        leftView(tree3.getRoot());
//        System.out.println();
//        System.out.println("Right View of tree2 ");
//        System.out.println();
//        rightView(tree2.getRoot());
//        System.out.println();
//        System.out.println("Left view of tree3 using Level Order ");
//        System.out.println();
//        leftViewUsingLevelOrder(tree3.getRoot());
//        System.out.println();
//        System.out.println("Right View of tree2 using Level Order ");
//        System.out.println();
//        rightViewUsingLevelOrder(tree2.getRoot());
//        System.out.println("Vertical Order of tree ");
//        verticalOrder(tree.getRoot());
//        System.out.println("Vertical Sum of tree ");
//        verticalSum(tree.getRoot());
//        System.out.println("Bottom View of tree");
//        bottomViewUsingLevelOrder(tree.getRoot());
//        System.out.println("Top View of tree using Level Order");
//        topViewUsingLevelOrder(tree.getRoot());
//        System.out.println();
//        System.out.println("Top View of tree2 using Level Order");
//        topViewUsingLevelOrder(tree2.getRoot());

//        System.out.println("Bottom View of tree using DFS ");
//        bottomViewUsingDFS(tree.getRoot());
//        System.out.println();
//        System.out.println("Bottom View of tree2 using DFS ");
//        bottomViewUsingDFS(tree2.root);
        System.out.println("Top View of tree using DFS ");
        topViewUsingDFS(tree.getRoot());
        System.out.println();
        System.out.println("Top View of tree2 using DFS ");
        topViewUsingDFS(tree2.root);

    }
}
