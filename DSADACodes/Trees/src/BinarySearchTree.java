
public class BinarySearchTree {
     public static TNode<Integer> constructBinSearchTree(){
//	
//								      8
//								     /  \
//								    4   14
//								   /    / \
//								  2    9   16
//								 / \         \
//								1   3         19

		
		TNode<Integer> a = new TNode<Integer>(8);
		TNode<Integer> b = new TNode<Integer>(4);
		TNode<Integer> c = new TNode<Integer>(14);
		TNode<Integer> d = new TNode<Integer>(2);
		TNode<Integer> e = new TNode<Integer>(9);
		TNode<Integer> f = new TNode<Integer>(16);
		TNode<Integer> g = new TNode<Integer>(1);
		TNode<Integer> h = new TNode<Integer>(3);
		TNode<Integer> i = new TNode<Integer>(19);
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
//   --------------------- Searching a BST----------------------------------------
     public static TNode<Integer> search(TNode<Integer> root, int key){
    	 while(root != null){
    		 if(root.getData() == key){
    			 return root;
    		 }
    		 else if (root.getData() > key){
    			 root = root.getLeftChild();
    		 }
    		 else{
    			 root = root.getRightChild();
    		 }
    	 }
    	 return root;
     }
      
     //-----------------------------Inserting in a BST ----------------------------------------
     public static TNode<Integer> insert(TNode<Integer> root,int value){
    	 if(root == null){
    		 return new TNode<Integer>(value);
    	 }
    	 if(root.getData() >= value){
    		 root.setLeftChild(insert(root.getLeftChild(), value));
    	 }
    	 else{
    		 root.setRightChild(insert(root.getRightChild(),value));
    	 }
    	 return root;
     }
     
     // ---------------------- Finding the Minimum Element ---------------------------------------
     public static TNode<Integer> getMinimum(TNode<Integer> root){
    	 if(root == null){
    		 return null;
    	 }
    	 while(root.getLeftChild() != null){
    		 root = root.getLeftChild();
    	 }
    	 return root;
     }
     
     // ----------------------- Finding the Maximum Element ---------------------------------------
     public static TNode<Integer> getMaximum(TNode<Integer> root){
    	 if(root == null){
    		 return null;
    	 }
    	 while(root.getRightChild() != null){
    		 root = root.getRightChild();
    	 }
    	 return root;
     }
     
     //-------------------------- Finding the Floor of Element -----------------------------------
     public static TNode<Integer> getFloor(TNode<Integer> root, int key){
    	 if(root == null){
    		 return null;
    	 }
    	 if(root.getData() == key){
    		 return root;
    	 }
    	 if(key < root.getData()){
    		 return getFloor(root.getLeftChild(), key);
    	 }
    	 else{
    		 TNode<Integer> t = getFloor(root.getRightChild(),key);
    		 if(t != null){
    			 return t;
    		 }
    		 else{
    			 return root;
    		 }
    	 }
     }
     
     // -----------------------Finding the Ceiling of Element ------------------------------------
     public static TNode<Integer> getCeiling(TNode<Integer> root, int key){
    	 if(root == null){
    		 return null;
    	 }
    	 if(root.getData() == key){
    		 return root;
    	 }
    	 if(key > root.getData()){
    		 return getCeiling(root.getRightChild(),key);
    	 }
    	 else{
    		 TNode<Integer> t = getCeiling(root.getLeftChild(),key);
    		 if(t != null){
    			 return t;
    		 }
    		 else{
    			 return root;
    		 }
    	 }
     }
     
     //------------------------ Deleting the Minimum Element -------------------------------------
     public static TNode<Integer> deleteMin(TNode<Integer> root){
    	 if(root.getLeftChild() == null){
    		 return root.getRightChild();
    	 }
    	 root.setLeftChild(deleteMin(root.getLeftChild()));
    	 return root;
     }
     
     // ------------------------Deleting the Maximum Element -------------------------------------
     public static TNode<Integer> deleteMax(TNode<Integer> root){
    	 if(root.getRightChild() == null){
    		 return root.getLeftChild();
    	 }
    	 root.setRightChild(deleteMax(root.getRightChild()));
    	 return root;
     }
     
     // ----------------------- Deletion (Hibbard Deletion)--------------------------------------
     public static TNode<Integer> delete(TNode<Integer> root, int key){
       if(root == null){
    	   return null;
       }
       if(key < root.getData()){
    	   root.setLeftChild(delete(root.getLeftChild(),key));
       }
       else if(key > root.getData()){
    	   root.setRightChild(delete(root.getRightChild(),key));
       }
       else{
    	   if(root.getRightChild() == null){
    		   return root.getLeftChild();
    	   }
    	   if(root.getLeftChild() == null){
    		   return root.getRightChild();
    	   }
    	   TNode<Integer> t = root;
    	   root = getMinimum(t.getRightChild());
    	   root.setRightChild(deleteMin(t.getRightChild()));
    	   root.setLeftChild(t.getLeftChild());
       }
       return root;
     }
     
     public static void main(String[] args) {
		TNode<Integer> root = constructBinSearchTree();
		System.out.println("In-Order Traversal");
		BinaryTreeTraversals.inOrderTraversal(root);
		System.out.println();
//		System.out.println("16 exists? " + (search(root, 16) != null ? "yes" : "no"));
//		System.out.println("15 exists? " + (search(root, 15) != null ? "yes" : "no"));
//		System.out.println("19 exists? " + (search(root, 19) != null ? "yes" : "no"));
//		System.out.println("24 exists? " + (search(root, 24) != null ? "yes" : "no"));
		TNode<Integer> min = getMinimum(root);
		System.out.println("The minimum element is " + min.getData());
		TNode<Integer> max = getMaximum(root);
		System.out.println("The maximum element is " + max.getData());
		System.out.println("Removing the minimum and maximum element");
		deleteMin(root);
		deleteMax(root);
		System.out.println("In-Order Traversal");
		BinaryTreeTraversals.inOrderTraversal(root);
		System.out.println();
		System.out.println("Inserting 5");
		root = insert(root, 5);
		System.out.println("Inserting 25");
		root = insert(root, 25);
		System.out.println("Inserting -4");
		root = insert(root, -4);
		System.out.println("In-Order Traversal");
		BinaryTreeTraversals.inOrderTraversal(root);
		System.out.println();
//		System.out.println("15 exists? " + (search(root, 15) != null ? "yes" : "no"));
//		System.out.println("25 exists? " + (search(root, 25) != null ? "yes" : "no"));
		min = getMinimum(root);
		max = getMaximum(root);
		System.out.println("The minimum element is " + min.getData());
		System.out.println("The maximum element is " + max.getData());
//		TNode<Integer> floor;
//		floor = getFloor(root,11);
//		System.out.println("The floor of 11 is " + floor.getData());
//		TNode<Integer> ceiling = getCeiling(root,3);
//		System.out.println("The ceilng if 3 is " + ceiling.getData());
		System.out.println("Deleting 14");
		delete(root, 14);
		System.out.println("In-Order Traversal");
		BinaryTreeTraversals.inOrderTraversal(root);
		System.out.println();
	}
}
