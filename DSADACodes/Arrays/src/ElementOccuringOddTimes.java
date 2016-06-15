
public class ElementOccuringOddTimes {

	public static int findElementOccuringOddTimes(int[] arr){
		int res = 0;
		for(int i = 0; i < arr.length; i++){
			res = res ^ arr[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {2,2,6,7,9,7,6,9,2,5,2,16,5};
		System.out.println(findElementOccuringOddTimes(arr));
	}
}
