
public class MinimumAndMaximum {
  public static void getMinAndMax(int[] array){
	  int min;
	  int max;
	  int i;
	  if(array.length % 2 == 0){
		  if(array[0] > array[1]){
			  max = array[0];
			  min = array[1];
		  }
		  else{
			  max = array[1];
			  min = array[0];
		  }
		  i = 2;
	  }
	  else{
		  min = array[0];
		  max = array[1];
		  i = 1;
	  }
	  while(i < array.length){
		  if(array[i] > array[i+1]){
			  if(array[i] > max){
				  max = array[i];
			  }
			  if(array[i+1] < min){
				  min = array[i+1];
			  }
		  }
		  else{
			  if(array[i+1] > max){
				  max = array[i+1];
			  }
			  if(array[i] < min){
				  min = array[i];
			  }
		  }
		  i += 2;
	  }
	  System.out.println("Minimum : " + min + " Maximum : " + max);
  }
  public static void main(String[] args) {
	int[] array = {2,5,3,-5,9,12,6,18,-8};
	getMinAndMax(array);
}
}
