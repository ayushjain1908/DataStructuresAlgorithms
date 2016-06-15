
public class MyStack<T> {
   private static int MAX_SIZE = 50;
   private Node<T> top;
   private int size = 0;
   
   public void push(T data)  throws StackOverflowException{
	  if(size == MAX_SIZE){
		  throw new StackOverflowException();
	  } 
	  Node<T> ele = new Node<T> (data, top);
	  top = ele;
	  size++;
   }
   
   public T peek() throws StackUnderflowException {
	   if(size == 0){
		   throw new StackUnderflowException();
	   }
	   return top.getData();
   }  
   public T pop() throws StackUnderflowException{
	   if(size == 0){
		   throw new StackUnderflowException();
	   }
	   T data  = top.getData();
	   top = top.getNext();
	   size--;
	   return data;
   }
   public boolean isFull(){
	   return size == MAX_SIZE;
   }
   public boolean isEmpty(){
	   return size == 0;
   }
   public int getSize(){
	   return size;
   }
   public void printStack(){
	   if(size == 0){
		   System.out.println("Stack is empty");
	   }
	   else{
		   System.out.println("************-----Top to Bottom-------*******************");
		   Node ele = top;
		   while(ele != null){
			   System.out.print(ele.getData() + " ");
			   ele = ele.getNext();
		   }
	   }
   }
   public static class StackOverflowException extends Exception{
	   
   }
   public static class StackUnderflowException extends Exception{
	   
   }
   public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
	MyStack<Integer> stack = new MyStack<Integer>();
	MAX_SIZE = 5;
	stack.push(1);
	stack.push(2);
	stack.push(3);
	stack.push(4);
	System.out.println("Stack size: " + stack.getSize());
    System.out.println("Stack full?: " + stack.isFull());
    System.out.println("Stack empty?: " + stack.isEmpty());
    stack.push(5);
    System.out.println("Stack size: " + stack.getSize());
    System.out.println("Stack full?: " + stack.isFull());
    System.out.println("Stack empty?: " + stack.isEmpty());
    System.out.println("Stack peek: " + stack.peek());
    int data = stack.pop();
    System.out.println("Popped element: " + data);

    System.out.println("Peek again: " + stack.peek());
    try {
        stack.push(5);
        stack.push(6);
    } catch (StackOverflowException soe) {
        System.out.println("Stack is full! No room available.");
    }
    System.out.println("Peek again: " + stack.peek());
    
   }
}
