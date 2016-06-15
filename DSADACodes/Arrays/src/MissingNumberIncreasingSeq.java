
public class MissingNumberIncreasingSeq {

	private static boolean isCorrectlyPlaced(int index, int ele){
		return (index + 1 == ele);
	}
	// finding the first incorrectly placed number from left
	public static int findMissingNumber(int[] arr){
		if(arr == null || arr.length == 0){
			return -1;
		}
		int low = 0;
		int high =  arr.length - 1;
		if(isCorrectlyPlaced(high, arr[high])){
			System.out.println("No missing number. All elements correctly placed");
			return 0;
		}
		while(low <= high){
			if(low == high){
				return arr[low] - 1;
			}
			int mid = low + (high - low)/2;
			if(isCorrectlyPlaced(mid, arr[mid])){
				low = mid + 1;
			}
			else{
				high = mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,10,11,12,13};
		ArrayHelper.printArray(arr);
		System.out.println("The missing number is " + findMissingNumber(arr));
	}
}
