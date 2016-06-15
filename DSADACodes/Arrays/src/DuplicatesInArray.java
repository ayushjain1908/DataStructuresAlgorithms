
public class DuplicatesInArray {
  
	// Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. 
	// Find these repeating numbers in O(n) and using only constant memory space.
	// This approach does not work if 0 is present in the array
	// Elements occuring as index of array approach
	public static void printDuplicates(int[] array){
		int n = array.length;
		System.out.println("Duplicate elements are : ");
		for(int i = 0 ; i < n; i++){
			if(array[Math.abs(array[i])] > 0){
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];	
			}
			else{
				System.out.print(Math.abs(array[i]) + " ");
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {2,4,5,2,7,1,8,4,7,8};
		printDuplicates(array);
	}
}
