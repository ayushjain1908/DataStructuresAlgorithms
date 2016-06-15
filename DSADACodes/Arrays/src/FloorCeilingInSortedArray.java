
public class FloorCeilingInSortedArray {

	public static int findCeilingLinear(int[] array, int x){
		if(x <= array[0]){
			return 0;
		}
		if(x > array[array.length - 1]){
			return -1;
		}
		for(int i = 0 ; i < array.length - 1; i++){
			if(array[i] == x){
				return i;
			}
			if( array[i] < x && x <= array[i + 1]){
				return i + 1;
			}
		}
		return -1;
	}
	public static int findFloorLinear(int[] array,int x){
		if(x < array[0]){
			return -1;
		}
		if(x >= array[array.length - 1]){
			return array.length - 1;
		}
		for(int i = 0 ; i < array.length - 1 ; i++){
			if(array[i] == x){
				return i;
			}
			if(array[i] < x && x < array[i + 1]){
				return i;
			}
		}
		return -1;
	}
	public static int findCeilingBinary(int[] array,int low, int high, int x){
	   if(x <= array[low]){
		   return low;
	   }	
	   if(x > array[high]){
		   return -1;
	   }
	   int mid = low + (high - low)/2;
	   if(array[mid] == x){
		   return mid;
	   }
	   if( x > array[mid]){
		   if( mid + 1 <= high && x <= array[mid + 1]){
			   return mid + 1;
		   }
		   else{
			   return findCeilingBinary(array,mid + 1 , high, x);
		   }
	   }
	   else{
		   if(mid - 1 >= low && x > array[mid - 1]){
			   return mid;
		   }
		   else{
			   return findCeilingBinary(array, low,mid - 1, x);
		   }
	   }
	}
	public static int findFloorBinary(int[] array,int low,int high, int x){
		if(x  < array[low]){
			return -1;
		}
		if(x >= array[high]){
			return high;
		}
		int mid = low + (high - low)/2;
		if(array[mid] == x){
			return mid;
		}
		if(x > array[mid]){
			if(mid + 1 <= high && x < array[mid + 1]){
				return mid;
			}
			else{
				return findFloorBinary(array, mid + 1, high, x);
			}
	    }
		else{
			if(mid - 1 >= low && x >= array[mid - 1]){
				return mid - 1;
			}
			else{
				return findFloorBinary(array, low, mid - 1, x);
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {1,3,4,5,7,9,15};
		int x = 8;
		int ceil = findCeilingLinear(array, x);
		int ceil2 = findCeilingBinary(array, 0, array.length - 1, x);
		int floor = findFloorLinear(array, x);
		int floor2 = findFloorBinary(array, 0, array.length - 1, x);
		if(ceil != -1){
		 System.out.println("Ceiling of " + x + " is " + array[ceil] );
	    }
		else{
			System.out.println("Ceiling of " + x + " does not exist");
		}
		if(ceil2 != -1){
			 System.out.println("Ceiling of " + x + " is " + array[ceil2] );
		 }
	    else{
				System.out.println("Ceiling of " + x + " does not exist");
		}
		if(floor != -1){
			System.out.println("Floor of " + x + " is " + array[floor]);
		}
		else{
			System.out.println("Floor of " + x + " does not exist");
		}
		if(floor2 != -1){
			System.out.println("Floor of " + x + " is " + array[floor2]);
		}
		else{
			System.out.println("Floor of " + x + " does not exist");
		}
	}	
}
