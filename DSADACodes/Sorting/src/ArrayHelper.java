

public class ArrayHelper {

	 public static void printArray(int[] arr){
		 for(int i = 0 ; i < arr.length ; i++ ){
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println();
	 }
	 public static void swap(int[] arr, int i, int j){
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
	 public static void main(String[] args){
		 //int[] arr = {5,1,9,7,2,5,11,17,3,6,4,4,8,0,10};
		 int[] arr = {0,1,1,1,2,3,4,0,3,2,4,4,2,1,0,2,1,1,4,3,3,0,0};
		 int[] aux = new int[arr.length];
		 System.out.println("The original array : ");
		 printArray(arr);
		 System.out.println(" 3-Way Quick Sort running .....");
		 AllSorts.threeWayQuickSort(arr,0,arr.length - 1);;
		 System.out.println("Sorting done. The array becomes..");
		 printArray(arr);
		 
	 }
}
