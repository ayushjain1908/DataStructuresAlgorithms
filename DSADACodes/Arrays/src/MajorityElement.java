
public class MajorityElement {
   
	  //---------------- Boyer-Moore Voting Algorithm --------------------------------
	public static Integer getMajorityElement(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		int n = arr.length;
		int count = 0 ;
		int candidate = 0;
		for(int i = 0; i < n; i++){
			if(count == 0){
				candidate = arr[i];
				count = 1;
			}
			else{
				if(arr[i] == candidate){
					count++;
				}
				else{
					count--;
				}
			}
		}
		if(count == 0){
			return null;
		}
		// checking if the candidate is really a majority element
		count = 0;
		for(int i = 0 ; i < n ; i++){
			if(arr[i] == candidate){
				count++;
			}
		}
		if(count > n/2){
			return candidate;
		}
		else{
			return null;
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,1,3,2,2,4,2,2,2,2,1,1,3,9};
		Integer res = getMajorityElement(arr);
		if(res == null){
			System.out.println("No Majority element");
		}
		else{
			System.out.println(res + " is the Majority element");
		}
	}
}
