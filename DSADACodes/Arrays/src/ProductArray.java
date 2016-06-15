import java.util.Arrays;

public class ProductArray {

 	// Using auxillary space
	public static int[] findProductArray(int[] array){
		int[] left = new int[array.length];
		int[] right = new int[array.length];
		int[] product = new int[array.length];
		left[0] = 1;
		right[right.length - 1] = 1;
		for(int i = 1;i < array.length; i++){
			left[i] = array[i-1] * left[i-1];
		}
		for(int i = array.length - 2; i >=0; i--){
			right[i] = array[i+1] * right[i + 1];
		}
		for(int i = 0 ; i < left.length ; i++){
			product[i] = left[i] * right[i];
		}
		return product;
	}
	public static int[] findProductArrayOptimized(int[] array){
		int[] product = new int[array.length];
		int temp = 1;
		// Mutiplying left side elements
		for(int i = 0 ; i < array.length; i++){
		  product[i] = temp;
		  temp *= array[i];
		}
		temp = 1;
		// Multiplying right side elements
		for(int i = array.length - 1; i >= 0 ; i--){
			product[i] *= temp;
			temp *= array[i];
		}
		return product;
	}
	public static void main(String[] args) {
		int[] array = {2,4,5,4,1};
		int[] product = findProductArray(array);
		int[] product2 = findProductArrayOptimized(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(product));
		System.out.println(Arrays.toString(product2));
    }
}	
