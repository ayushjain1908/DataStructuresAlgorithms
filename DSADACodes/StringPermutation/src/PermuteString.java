
import java.util.*;
public class PermuteString {
  private static void PermuteString(char[] carr,int l,int r){
	  if(l==r){
		  System.out.println(String.valueOf(carr));
	  } 
	  else{
		  for(int i = l; i <= r; i++){
			  	swap(carr,l,i);
			  	PermuteString(carr, l + 1, r);
			  	swap(carr,l,i); // Backtracking
		  }
	  }
  }
  private static void swap(char[] carr,int i,int j){
	  char temp = carr[i];
	  carr[i] = carr[j];
	  carr[j] = temp;
  	}
  public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  String s = in.nextLine();
	  char[] carr = s.toCharArray();
	  PermuteString(carr, 0, s.length()-1);
  }
}