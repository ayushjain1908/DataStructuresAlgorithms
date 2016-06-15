import java.lang.reflect.Array;

public class RotateArray {

	 // Partial reversal of Array
	public static void reverseArray(int[] arr, int low,int high){
		while(low < high){
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			high--;
			low++;
		}
	}
	
	 // Rotation using Array Reversal
	public static void rotateAnticlockwise(int[] arr, int k){
		if(k <=0 || arr == null || arr.length == 0){
			return;
		}
		if(k >= arr.length){
			k = k % arr.length;
		}
		reverseArray(arr,0,k-1);
		reverseArray(arr,k,arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);
	}
	public static void rotateClockwise(int[] arr, int k){
		if(k <=0 || arr == null || arr.length == 0){
			return;
		}
		if(k >= arr.length){
			k = k % arr.length;
		}
		reverseArray(arr,arr.length - k, arr.length - 1);
		reverseArray(arr, 0, arr.length - k - 1);
		reverseArray(arr,0, arr.length - 1);
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ArrayHelper.printArray(arr);
		System.out.println("Rotating Anticlockwise by 3");
		rotateAnticlockwise(arr, 3);
		ArrayHelper.printArray(arr);
		int[] arr2 = {1,2,3,4,5};
		ArrayHelper.printArray(arr2);
		System.out.println("Rotating Clockwise by 4");
		rotateClockwise(arr2, 4);
		ArrayHelper.printArray(arr2);
	}
}
