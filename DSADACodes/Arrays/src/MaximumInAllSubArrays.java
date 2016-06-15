import java.util.Arrays;
import java.util.LinkedList;

public class MaximumInAllSubArrays {
   
	// Brute-force Approach O(kn)
	public static void printMaxK(int[] array,int k){
		int n = array.length;
		for(int i = 0 ; i <= n - k ; i++){
			int max = array[i];
			for(int j = 1; j < k;j++){
				if(array[i + j] > max){
					max = array[i + j];
				}
			}
			System.out.print(max + " ");
		}
	}
	
	// Optimized Approach using DeQueue O(n)
	public static void printMaxKOptimized(int[] array, int k){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < k ; i++){
			while(!list.isEmpty() && array[list.getLast()] < array[i]){
				list.removeLast();
			}
			list.addLast(i);;
		}
		for(int i = k ; i < array.length ; i++){
			System.out.print(array[list.getFirst()] + " ");
			while(!list.isEmpty() && list.getFirst() < (i - k + 1)){
				list.removeFirst();
			}
			while(!list.isEmpty() && array[list.getLast()] < array[i]){
				list.removeLast();
			}
			list.addLast(i);
		}
		System.out.println(array[list.getFirst()]);
	}
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		System.out.println(Arrays.toString(arr1));
		printMaxK(arr1, 3);
		System.out.println();
		printMaxKOptimized(arr1, 3);
		int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		System.out.println();
		System.out.println(Arrays.toString(arr2));
		printMaxK(arr2, 4);
		System.out.println();
		printMaxKOptimized(arr2, 4);
	}
}
