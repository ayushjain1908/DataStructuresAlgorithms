import java.util.*;
public class StackMinimumConstantTime {

	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minimumStack = new Stack<>();
	public void push(int data){
		int min = data;
		if(!minimumStack.empty()){
			if(minimumStack.peek() < min){
				min = minimumStack.peek();
			}
		}
		dataStack.push(data);
		minimumStack.push(min);
	}
	public int pop(){
		minimumStack.pop();
		return dataStack.pop();
	}
	public int peek(){
		return dataStack.peek();
	}
	public int getMinimum(){
		return minimumStack.peek();
	}
	public static void main(String[] args) {
		StackMinimumConstantTime minimumStack = new StackMinimumConstantTime();
		minimumStack.push(2);
        minimumStack.push(4);
        minimumStack.push(10);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(1);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(0);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());

        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
	}
}	