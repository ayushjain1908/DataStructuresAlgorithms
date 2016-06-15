
public class LeadersInArray {
   public static void printLeaders(int[] arr){
	   if(arr == null || arr.length == 0){
		   return;
	   }
	   int n = arr.length;
	   int currLeader = arr[n-1];
	   System.out.println("Leaders:");
	   System.out.print(currLeader + " ");
	   for(int i = n-2; i >= 0; i--){
		   if(arr[i] >= currLeader){
			   currLeader = arr[i];
			   System.out.print(currLeader + " ");
		   }
	   }
   }
   public static void main(String[] args) {
	int[] arr = {76,60,65,70,25,10};
	printLeaders(arr);
}
}
