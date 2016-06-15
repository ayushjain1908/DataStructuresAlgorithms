import java.util.*;
public class TwoNumbersWithGivenSum {
 
	 public static boolean findTwoNosWithGivenSum(int[] array, int sum){
		 Arrays.sort(array);
         int i = 0;
         int j = array.length - 1;
         while(i < j){
        	 if(array[i] + array[j] == sum){
        		 System.out.println("Numbers with given sum are " + array[i] + " " + array[j]);
        		 return true;
        	 }
        	 else if(array[i] + array[j] < sum){
        		 i++;
        	 }
        	 else{
        		 j--;
        	 }
         }
		 return false;
	 }
	 public static void main(String[] args) {
		int[] arr = {2,6,12,7,9,1,10,3,5};
		if(!findTwoNosWithGivenSum(arr,7)){
			System.out.println("No two numbers with given sum exists");
		}
	}
}
