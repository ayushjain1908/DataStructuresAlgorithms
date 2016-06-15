
public class MissingNumberInSequence {
   public static int findMissingNumber(int[] array){
	   int num = 0;
	   int n = array.length + 1;
	   for(int k = 1 ; k <= n; k++){
		   num = num ^ k;
	   }
	   for(int i = 0 ; i < array.length ; i++){
		   num = num ^ array[i];
	   }
	   return num;
   }
   public static void main(String[] args) {
	int[] array = {1,2,3,4,6,7,8};
	System.out.println(findMissingNumber(array));
   }
}
