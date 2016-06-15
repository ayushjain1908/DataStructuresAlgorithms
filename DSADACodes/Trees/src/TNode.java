
public class TNode<T> {
   private T data;
   private TNode<T> leftChild;
   private TNode<T> rightChild;
   public TNode(T data){
	   this.data = data;
   }
   public T getData(){
	   return data;
   }
   public void setData(T data){
	   this.data = data;
   }
   public TNode<T> getLeftChild(){
	   return leftChild;
   }
   public TNode<T> getRightChild(){
	   return rightChild;
   }
   public void setLeftChild(TNode<T> leftChild){
	   this.leftChild = leftChild;
   }
   public void setRightChild(TNode<T> rightChild){
	   this.rightChild = rightChild;
   }
}
