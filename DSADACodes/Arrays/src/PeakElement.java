
public class PeakElement {
	public static Integer getPeakElement(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])){
				return arr[mid];
			}
			else if(mid > 0 && arr[mid - 1] > arr[mid]){
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		return null;
	}
    public static void main(String[] args) {
		int[] a1 = {2,3,5,6,7,8,9};
		System.out.println("Peak Element is " + getPeakElement(a1));
	}
}
