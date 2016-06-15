import java.util.Arrays;


public class IsPermutation3 {

	private static String sortString(String str){
		char[] cArr = str.toCharArray();
		Arrays.sort(cArr);
		return new String(cArr);
	}
	// Using Sorting
	public static boolean isPermutationUsingSorting(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		return sortString(s1).equals(sortString(s2));
	}
	//Using Count Array
	public static boolean isPermutationUsingCountArray(String s1,String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		int[] count = new int[256];
		for(int i = 0; i < s1.length(); i++){
			int val = s1.charAt(i);
			count[val]++;
		}
	    for(int i = 0 ; i < s2.length(); i++){
	    	int val = s2.charAt(i);
	    	if(--count[val] < 0){
	    		return false;
	    	}
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		String s1 = "layush";
		String s2 = "ylhsau";
		System.out.println(isPermutationUsingSorting(s1, s2));
		System.out.println(isPermutationUsingCountArray(s1, s2));
	}
}
