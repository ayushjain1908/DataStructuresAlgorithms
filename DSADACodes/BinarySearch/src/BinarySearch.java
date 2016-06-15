
public class BinarySearch {
    // ---------------------------Iterative Version---------------------------------------------
	public static int binSearchIterative(int[] arr , int key){
		int low = 0 ;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2 ; 
			if(arr[mid] == key){
				return mid;
			}
			else if(arr[mid] < key){
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
		}
		return -1;
	}
	//-----------------------------Recursive Version --------------------------------------------
	public static int binSearchRecursive(int[] arr, int key, int low, int high){
		if(low > high){
			return -1;
		}
		int mid = low + (high - low)/2;
		if(arr[mid] == key){
			return mid;
		}
		else if (arr[mid] < key){
			return binSearchRecursive(arr,key,mid + 1, high);
		}
		else{
			return binSearchRecursive(arr, key, low, mid - 1);
		}
	}
	
	//---------------------------- Binary Search First Occurrence -----------------------------
	public static int binSearchFirst(int[] arr, int key){
		int result = -1;
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(arr[mid] == key){
				result = mid;
				high = mid - 1;
			}
			else if(arr[mid] > key){
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		return result;
	}
	
	//---------------------------- Binary Search Last Occurrence -----------------------------
		public static int binSearchLast(int[] arr, int key){
			int result = -1;
			int low = 0;
			int high = arr.length - 1;
			while(low <= high){
				int mid = low + (high - low)/2;
				if(arr[mid] == key){
					result = mid;
					low = mid + 1;
				}
				else if(arr[mid] > key){
					high = mid - 1;
				}
				else{
					low = mid + 1;
				}
			}
			return result;
		}
		
	// ----------------- Count Occurrences of element --------------------------------------------
	public static int countOccurrences(int[] arr, int key){
		int first = binSearchFirst(arr, key);
		if(first == -1){
			return 0;
		}
		int last = binSearchLast(arr, key);
		return last - first + 1;
	}	
		
	public static void main(String[] args){
		int[] arr = {0,3,9,9,9,9,9,19,21};
		System.out.println("Normal Binary Search");
		System.out.println(binSearchIterative(arr, 9));
		//System.out.println(binSearchRecursive(arr, 21, 0, arr.length - 1));
		System.out.println("Binary Search First Occurrence");
		System.out.println(binSearchFirst(arr, 9));
		System.out.println("Binary Search Last Occurrence");
		System.out.println(binSearchLast(arr, 9));
		System.out.println("Count of Occurrences");
		System.out.println(countOccurrences(arr, 9));
	}
}
