import java.util.*;
public class NextGreaterElement {
	 public static void printArray(int[] arr){
		 for(int i = 0 ; i < arr.length ; i++ ){
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println();
	}
    public static void printNextGreaterElement(int[] arr){
    	if(arr ==  null || arr.length == 0){
    		return;
    	}
    	Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);
        for(int i = 1 ; i < arr.length ; i++){
        	while(!stack.empty() && arr[i] > stack.peek()){
        		System.out.println("Next greater element of " + stack.pop() + " : " + arr[i]);
        	}
        	stack.push(arr[i]);
        }
        while(!stack.empty()){
        	System.out.println("Next greater element of " + stack.pop() + " : " + null);
        }
    }
    public static void main(String[] args) {
		int[] arr = {2,6,7,4,3,5,1};
		printArray(arr);
		printNextGreaterElement(arr);
	}
}
