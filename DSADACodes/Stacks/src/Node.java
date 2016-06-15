
public class Node<T> {
  private T data;
  private Node next;
  public Node(T data,Node next){
	  this.data = data;
	  this.next = next;
  }
  public T getData(){
	  return data;
  }  
  public void setData(T data){
	  this.data = data;
  }
  public void setNext(Node next){
	  this.next = next;
  }
  public Node getNext(){
	  return next;
  }
//  public static void main(String[] args) {
//	Node<Integer> n1 = new Node<Integer>(5,null);
//	Node<String> n2 = new Node<String>("ayush",null);
//	n1.setNext(n2);
//  }
}
