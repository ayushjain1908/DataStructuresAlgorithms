
public class HasAllUniqueChars1 {
	
	public static boolean hasUniqueChars(String str){
		
		if(str.length() > 128){
			return false;
		}
		boolean[] charSet = new boolean[256];
		for(int i = 0 ; i < str.length(); i++){
			int val = (int)str.charAt(i);
			if(charSet[val]){
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
	
	// Assuming string only contains chars a-z
	public static boolean hasUniqueCharsSpaceOpt(String str){
		int checker = 0 ;
		for(int i  = 0 ; i < str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0){
				return false;
			}
			checker  = checker | (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "helowtyamnHhe";
		System.out.println(hasUniqueChars(str));
		str = "abvejklsmzxeac";
		System.out.println(hasUniqueCharsSpaceOpt(str));
	}
}	