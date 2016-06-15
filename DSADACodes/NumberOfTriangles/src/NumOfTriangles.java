import java.util.*;

public class NumOfTriangles {
   public static int numOfTriangles(int[] arr){
	   int n = arr.length;
	   int count = 0;
	   Arrays.sort(arr);
	   for(int i = 0; i < n-2; i++){
		   int k = i + 2;
		   for(int j = i + 1; j < n - 1; j++){
			   while(k < n && arr[i] + arr[j] > arr[k]){
				   k++;
			   }
			   count += k - 1 - j;
		   }
	   }
	   return count;
   }
   public static void main(String[] args) {
	   int arr[] = {10, 21, 22, 100, 101, 200, 300};
       System.out.println("Total number of triangles is " +
                           numOfTriangles(arr));
}
}
