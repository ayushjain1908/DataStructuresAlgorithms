import java.util.Arrays;

public class TwoNonRepeatingElements {

//	Given an array in which all numbers except two are repeated once. (i.e. we have 2n+2 numbers and n numbers
//	are occurring twice and remaining two have occurred once).
//	Find those two numbers in the most efficient way.
	public static void printNonRepeating(int[] array){
		int xor = 0;
		for(int i = 0; i < array.length; i++){
			xor = xor ^ array[i];
		}
		int rsetBit = xor & (~(xor - 1));
		int x = 0;
		int y = 0;
		for(int i = 0 ; i < array.length ; i++){
			if((array[i] & rsetBit) == rsetBit){
				x  = x ^ array[i];
			}
			else{
				y = y ^ array[i];
			}
		}
		System.out.println("The non-repeating elements are " + x + "," + y);
	}
	public static void main(String[] args) {
		int[] array = {2,4,6,4,8,8,1,6,7,7};
		System.out.println(Arrays.toString(array));
		printNonRepeating(array);
	}
}

