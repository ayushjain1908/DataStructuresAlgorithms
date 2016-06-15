
public class PivotInSortedRotatedArray {

	// Using O(n) Linear Search
	public static int findPivotInSortedRotatedArrayLinear(int[] arr){
		int pivot = 0;
		if(arr == null || arr.length == 0){
			pivot = -1;
		}
		if(arr.length == 1 || arr[0] < arr[arr.length - 1]){
			pivot = 0;
		}
        for(int i = 0 ; i < arr.length - 1; i++){
        	if(arr[i] > arr[i+1]){
        		pivot =  i + 1;
        		break;
        	}
        }		
        return pivot;
	}
	
	// Using O(logn) Binary Search
	public static int findPivotInSortedRotatedArrayBinary(int[] arr){
		if(arr == null || arr.length == 0){
			return -1;
		}
		if(arr.length == 1 || arr[0] < arr[arr.length - 1]){
			return 0;
		}
		int low = 0 ;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(mid < arr.length - 1 && arr[mid] > arr[mid + 1]){
				return mid + 1;
			}
			else if(arr[mid] >= arr[low]){
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
		}
		return 0;
	}
	public static void main(String[] args){
		int[] arr = {6,7,8,1,2,3,4,5};
	    ArrayHelper.printArray(arr);
	    System.out.println("Using Linear Search");
	    System.out.println("The pivot element is found at index " + findPivotInSortedRotatedArrayLinear(arr) );
	    System.out.println("Using Binary Search");
	    System.out.println("The pivot element is found at index " + findPivotInSortedRotatedArrayBinary(arr));
	}
}
