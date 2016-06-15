
public class ElementInSortedRotatedArray {

	
	public static int findPivot(int[] arr){
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
	
	public static int binarySearch(int[] arr, int low, int high, int ele){
		while(low<=high){
			int mid = low + (high - low)/2;
			if(arr[mid] == ele){
				return mid;
			}
			else if(arr[mid] < ele){
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
		}
		return -1;
	}
	
	// Finding element with finding Pivot 
	public static int findElementUsingPivot(int[] arr, int ele){
		int pivot = findPivot(arr);
		if(pivot > 0 && ele >= arr[0] && ele <= arr[pivot - 1]){
			return binarySearch(arr, 0, pivot - 1, ele);
		}
		else{
			return binarySearch(arr, pivot, arr.length - 1, ele);
		}
	}
	// Find element without finding Pivot
	public static int findElementWithoutUsingPivot(int[] arr, int ele){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(arr[mid] == ele){
				return mid;
			}
			if(arr[mid] >= arr[low]){
				if(arr[low] <= ele && ele <= arr[mid]){
					high = mid - 1;
				}
				else{
					low = mid + 1;
				}
		   }
			else{
				if(arr[mid] <= ele && ele <= arr[high]){
					low = mid + 1;
				}
				else{
					high = mid - 1;
				}
			}
		  }
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr =  {6,7,8,1,2,3,4,5};
		ArrayHelper.printArray(arr);
		System.out.println("Element 3 is found at index " + findElementUsingPivot(arr, 3));
		System.out.println("Element 7 is found at index " + findElementUsingPivot(arr, 7));
		System.out.println("Element 1 is found at index " + findElementUsingPivot(arr, 1));
		System.out.println("Element 13 is found at index " + findElementUsingPivot(arr, 13));
		System.out.println("Element 3 is found at index " + findElementWithoutUsingPivot(arr, 3));
		System.out.println("Element 7 is found at index " + findElementWithoutUsingPivot(arr, 7));
		System.out.println("Element 1 is found at index " + findElementWithoutUsingPivot(arr, 1));
		System.out.println("Element 13 is found at index " + findElementWithoutUsingPivot(arr, 13));
	}
	
}
