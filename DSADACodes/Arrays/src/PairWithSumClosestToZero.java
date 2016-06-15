import java.util.Arrays;

public class PairWithSumClosestToZero {
  public static void sumClosetToZeroPair(int[] array){
	  int minSum = Integer.MAX_VALUE;
	  if(array.length < 2){
		  System.out.println("Invalid input");
		  return;
	  }
	  Arrays.sort(array);
	  int low = 0 ; 
	  int high = array.length - 1;
	  int left = -1;
	  int right = -1;
	  while(low < high){
		  int sum = array[low] + array[high];
		  if(Math.abs(sum) < Math.abs(minSum)){
			  minSum = sum;
			  left = low;
			  right = high;
		  }
		  if(sum > 0){
			  high--;
		  }
		  else{
			  low++;
		  }
	  }
	  System.out.println("Pair is " + array[left] + " , " + array[right] +  " and the sum is " + minSum); 
  }
  public static void main(String[] args) {
	int[] array = {2,3,-13,-5,7,9};
	sumClosetToZeroPair(array);
}
}
