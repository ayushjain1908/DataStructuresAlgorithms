
public class CompressionUsingCountOfRepeatedChars5 {

	private static int compressedSize(String str){
		char last = str.charAt(0);
		int count = 1;
		int size = 0;
		for(int i = 1;i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			}
			else{
				size = size +  1 + String.valueOf(count).length();
				last = str.charAt(i);
				count = 1;
			}	
		}
		size = size + 1 + String.valueOf(count).length();
		return size;				
	}
	public static String compressString(String str){
		if(compressedSize(str) > str.length()){
			return str;
		}
		StringBuffer compStr = new StringBuffer();
	    char last = str.charAt(0);
	    int count = 1;
	    for(int i = 1; i < str.length(); i++){
	    	if(str.charAt(i) == last){
	    		count++;
	    	}
	    	else{
	    		compStr.append(last);
	    		compStr.append(count);
	    		last = str.charAt(i);
	    		count = 1;
	    	}
	    }
	    compStr.append(last);
	    compStr.append(count);
	    return compStr.toString();
	}
	public static void main(String[] args) {
		String s1 = "abcdeef";
		String cs1 = compressString(s1);
		System.out.println(s1 + ": " + cs1);
		String s2 = "aabbbbcddeffffaaabc";
		String cs2 = compressString(s2);
		System.out.println(s2 + " : " + cs2);
	}
}
