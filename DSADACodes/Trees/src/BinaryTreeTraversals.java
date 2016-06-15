import java.util.*;
public class BinaryTreeTraversals {

	
	

	 private static TNode<Integer> constructBinaryTree(){
		 
		 
		 
//	
//                                        1
//                                      /   \
//                                     2 	 3
//                                    /     / \
//                                   4     5   6
//                                  / \         \
//                                 7   8         9
		 
		 		 
		 TNode<Integer> a = new TNode<Integer>(1);
		 TNode<Integer> b = new TNode<Integer>(2);
		 TNode<Integer> c = new TNode<Integer>(3);
		 TNode<Integer> d = new TNode<Integer>(4);
		 TNode<Integer> e = new TNode<Integer>(5);
		 TNode<Integer> f = new TNode<Integer>(6);
		 TNode<Integer> g = new TNode<Integer>(7);
		 TNode<Integer> h = new TNode<Integer>(8);
		 TNode<Integer> i = new TNode<Integer>(9);
		 a.setLeftChild(b);
		 a.setRightChild(c);
		 b.setLeftChild(d);
		 c.setLeftChild(e);
		 c.setRightChild(f);
		 d.setLeftChild(g);
		 d.setRightChild(h);
		 f.setRightChild(i);
		 return a;
	 }
	 // ----------------*************Breadth First Traversal ------------------------**********
	 public static void breadthFirstTraversal(TNode root){
		 if(root == null){
			 return;
		 }
		 Queue<TNode> queue = new LinkedList<TNode>();
		 queue.add(root);
		 while(!queue.isEmpty()){
			 TNode node = queue.remove();
			 System.out.print(node.getData() + " ");
			 if(node.getLeftChild() != null){
				 queue.add(node.getLeftChild());
			 }
			 if(node.getRightChild() != null){
				 queue.add(node.getRightChild());
			 }
		 }
	 }
	 
	 // ---------------******** Pre-Order Traversal ***************------------------------------
	 public static void preOrderTraversal(TNode root){
		 if(root ==  null){
			 return;
		 }
		 System.out.print(root.getData() + " ");
		 preOrderTraversal(root.getLeftChild());
		 preOrderTraversal(root.getRightChild());
	 }
	 
	// ---------------******** In-Order Traversal ***************------------------------------
		 public static void inOrderTraversal(TNode root){
			 if(root ==  null){
				 return;
			 }
			 inOrderTraversal(root.getLeftChild());
			 System.out.print(root.getData() + " ");
			 inOrderTraversal(root.getRightChild());
		 }
		 
	// ---------------******** 		Post-Order Traversal ***************------------------------------
		public static void postOrderTraversal(TNode root){
			if(root ==  null){
				return;
			}
			postOrderTraversal(root.getLeftChild());
			postOrderTraversal(root.getRightChild());
			System.out.print(root.getData() + " ");
		 } 
		 
	 public static void main(String[] args) {
		TNode<Integer> root = constructBinaryTree();
		System.out.println("Breadth First Traversal");
		breadthFirstTraversal(root);
		System.out.println();
		System.out.println("Pre-Order Traversal");
		preOrderTraversal(root);
		System.out.println();
		System.out.println("In-Order Traversal");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("Post-Order Traversal");
		postOrderTraversal(root);
	}
}
