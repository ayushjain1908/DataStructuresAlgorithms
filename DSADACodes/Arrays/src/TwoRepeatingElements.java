
public class TwoRepeatingElements {
	
//	You are given an array of n+2 elements. All elements of the array are in range 1 to n. 
//	And all elements occur once except two numbers which occur twice.
//	Find the two repeating numbers
	// We can also use array elements as indices approach(same as duplicates in array problem)
	// Using XOR
	public static void printRepeating(int[] array){
		int xor = 0;
		int n = array.length - 2;
		for(int i = 1; i <= n ;i++){
			xor =  xor ^ i;
		}
		for(int i = 0; i < array.length; i++){
			xor = xor ^ array[i];
		}
		// now xor contains x ^ y
	    int rSetBit = xor & (~(xor - 1)); // getting the right most set bit in xor
	    int x = 0;
	    int y = 0;
	    for(int i = 0 ; i < array.length; i++){
	    	if((array[i] & rSetBit) == rSetBit){
	    		x = x ^ array[i];
	    	}
	    	else{
	    		y = y ^ array[i];
	    	}
	    }
	    for(int i = 1; i <= n; i++){
	    	if((i & rSetBit) == rSetBit){
	    		x = x ^ i;
	    	}
	    	else{
	    		y = y ^ i;
	    	}
	    }
	    System.out.println("The repeating elements are " + x + "," + y);
	}
	public static void main(String[] args) {
		int[] array = {1,2,4,3,5,2,3,6};
		printRepeating(array);
	}

}
