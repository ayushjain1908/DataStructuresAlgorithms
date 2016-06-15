import java.util.Arrays;

public class Separate0sAnd1s {
    public static void separate0sAnd1s(int[] array){
    	int i = 0;
    	int j = array.length - 1;
    	while(i < j){
    		while(i < j && array[i] == 0){
    			i++;
    		}
    		while(i < j && array[j] == 1){
    			j--;
    		}
    		if(i < j){
    			array[i] = 0;
    			array[j] = 1;
    			i++;
    			j--;
    		}
    	}
    }
    public static void main(String[] args) {
		int[] array = {1,0,0,1,1,1,0,1,0,1,1,0,0,0,0,0,1,0,0};
		separate0sAnd1s(array);
		System.out.println(Arrays.toString(array));
	}
}
