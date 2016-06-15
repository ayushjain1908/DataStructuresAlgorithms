
public class Selection {

	private static void swap(int[] arr, int i, int j){
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	}
	private static int partition(int[] arr, int low, int high){
		   int i = low + 1;
		   int j = high;
		   int pe = arr[low];
		   while(true){
			   while(arr[i] < pe){
				   i++;
				   if(i > high){
					   break;
				   }
			   }
			   while(arr[j] > pe){
				   j--;
				   if(j < low){
					   break;
				   }
			   }
			   if(i>j){
				   break;
			   }
			   swap(arr, i, j);
			   i++; // critical to increase i and decrease j,otherwise it may lead to infinite loop
			   j--;
		   }
		   swap(arr,low,j);
		   return j;
	   }
	public static void printArray(int[] arr){
		 for(int i = 0 ; i < arr.length ; i++ ){
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println();
	 }
	public static int findKthLargest(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;
        while(high > low){
        	int j = partition(arr, low, high);
        	if(k > j){
        		low = j + 1;
        	}
        	else if(k < j){
        		high = j - 1;
        	}
        	else{
        		return arr[j];
        	}
        }
        return arr[k];
	}
	public static void main(String[] args){
		int[] arr = {2,3,0,4,6,1,9,7,8,5};
//		printArray(arr);
//		int j = partition(arr,0,arr.length - 1);
//		System.out.println("The element " + arr[j] + " is placed at its proper place at index " + j);
//        printArray(arr);
		int ele = findKthLargest(arr,5);
		System.out.println(ele);
	}
}
