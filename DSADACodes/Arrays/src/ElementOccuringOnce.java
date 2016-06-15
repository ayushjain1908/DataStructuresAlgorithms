
public class ElementOccuringOnce {
   public static int findElementOccuringOnce(int[] arr, int n){
	   int[] bitsCount = new int[32];
	   for(int i = 0; i < arr.length; i++){
		   for(int bitPos = 0; bitPos < 32; bitPos++){
			   int t = 1 << bitPos;
			   if((arr[i] & t) == t){
				   bitsCount[bitPos]++;
			   }
		   }
	   }
	   int result = 0;
	   for(int k = 0; k < 32; k++){
		   bitsCount[k] = bitsCount[k] % n;
		   if(bitsCount[k] == 1){
			   result = result | (1 << k);
		   }
	   }
	   return result;
   }
   public static void main(String[] args) {
	int[] arr = {2,3,4,4,2,2,4,3,9,3,9,9,12};
	System.out.println(findElementOccuringOnce(arr,3));
  }
}
