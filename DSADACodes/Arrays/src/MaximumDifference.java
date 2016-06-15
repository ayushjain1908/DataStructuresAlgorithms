import java.util.Arrays;

public class MaximumDifference {
	//	Given an array of size ‘n’, find the maximum difference between any 2 elements 
	//	such that the larger of the two elements appears later in the array.
	public static int getMaximumDiff(int[] array){
		int maxDiff = -1;
		int min = array[0];
		for(int i = 1;i < array.length; i++){
			if(array[i] - min > maxDiff){
				maxDiff = array[i] - min;
			}
			if(array[i] < min){
				min = array[i];
			}
		}
		return maxDiff;
	}
	public static void main(String[] args) {
		int[] array = {2,5,6,26,1,16,22};
		int maxDiff = getMaximumDiff(array);
		System.out.println(Arrays.toString(array));
		if(maxDiff < 0){
		 System.out.println("No such elements exist");	
		}
		else{
			System.out.println(maxDiff);
		}
		}
}
