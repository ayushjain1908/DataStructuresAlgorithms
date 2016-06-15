
public class SmallestAndSecondSmallest {

	public static void printSmallestSecondSmallest(int[] arr){
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < smallest){
				secondSmallest = smallest;
				smallest = arr[i];
			}
			else if(arr[i] != smallest && arr[i] < secondSmallest){
				secondSmallest =  arr[i];
			}
		}
		if(secondSmallest == Integer.MAX_VALUE){
			System.out.println("Smallest Element is " + smallest);
			System.out.println("No second smallest element");
		}
		else{
			System.out.println("Smallest Element is " + smallest);
			System.out.println("Second smallest Element " + secondSmallest);
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,2,2,2,2,2,1,4};
		printSmallestSecondSmallest(arr);
	}
}
