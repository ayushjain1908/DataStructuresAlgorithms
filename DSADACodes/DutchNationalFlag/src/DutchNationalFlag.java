
public class DutchNationalFlag {

	public static void printArray(int[] arr){
		 for(int i = 0 ; i < arr.length ; i++ ){
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println();
	 }
	 public static void swap(int[] arr, int i, int j){
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
	public static void threeWayPartition(int[] arr,int low,int high){
		int lt = low;
		int gt = high;
		int i = low;
		int ele = arr[low];
		while(i <= gt){
			if(arr[i] == ele){
				i++;
			}
			else if(arr[i] < ele){
				swap(arr, i, lt);
				lt++;
				i++;
			}
			else{
				swap(arr,i,gt);
				gt--;
			}
		}
	}
	public static void main(String[] args){
		int[] flag = {1,2,0,0,1,2,1,1,0,0,2,2,2,1,0,1,2};
		printArray(flag);
		System.out.println("3 Way Partioning ......");
		threeWayPartition(flag, 0, flag.length-1);
		System.out.println("The Flag becomes :");
		printArray(flag);
	}
}
