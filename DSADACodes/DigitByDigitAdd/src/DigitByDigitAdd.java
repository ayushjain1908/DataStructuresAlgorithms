import java.util.ArrayList;
import java.util.List;

public class DigitByDigitAdd {

public static int[] digitAdd(int[] a,int[] b){
		if(a == null || b == null){
		return null;
		}
		int la = a.length - 1;
		int lb = b.length - 1;
		int digit = 0 ;
		int carry = 0;
		int r = 0;
		List<Integer> result = new ArrayList<Integer>();
		while(la >=0 && lb >= 0){
		   r = carry + a[la] + b[lb];
		   digit = r%10;
		   carry = r/10;
		   result.add(0,digit);
		   la--;
		   lb--;
		}
		while(la>=0){
			r = carry + a[la];
			digit = r%10;
			carry = r/10;
			la--;
			result.add(0,digit);
		}
		  while(lb >= 0){
			  r = carry + b[lb];
			  digit = r%10;
			  carry = r/10;
			  lb--;
			  result.add(0,digit);
		  }
		  if(carry > 0){
			  result.add(0,carry);
		  }
		int len = result.size();
		int[] resultArr = new int[len];
		for(int i = 0 ; i < len ;i++){
			resultArr[i] = result.get(i);
		}
		return resultArr;
}
public static void main(String[] args) {
	int[] a = {9,8};
	int[] b = {9,4,1,4};
	int[] result = digitAdd(a, b);
	for(int i = 0 ; i < result.length ; i++){
		System.out.print(result[i] + " ");
	}
 }
}