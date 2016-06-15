	public class RunLengthEncoding {
	
	public static String encode(String str){
				if(str == null){
				return null;
				}
				int len = str.length();
				String eStr = "";
				int currIndex = 0 ;
				while(currIndex < len){
					int num = 0 ;
					int compIndex = currIndex;
					char currChar = str.charAt(currIndex);
					while(compIndex < len && str.charAt(compIndex) == currChar){
							num++;
							compIndex++;
					}
				currIndex = compIndex;
				eStr = eStr + num + currChar;
				}
				   return eStr;
	}
	public static String decode(String str){
			if(str == null){
			return null;
			}
			int len = str.length();
			String dStr = "";
			int nStart = 0;
			while(nStart < len){
				int nEnd = nStart + 1;
				while(nEnd < len && Character.isDigit(str.charAt(nEnd))){
				nEnd++;
				}
				int num = Integer.valueOf(str.substring(nStart,nEnd));
				char currChar = str.charAt(nEnd);
				while(num > 0){
				dStr += currChar;
				num--;
			}
			nStart = nEnd + 1;
			}
			return dStr;
	}
	public static void main(String[] args) {
	String a = "aaaabbtttttttttttttteqrppp";
	String ea = encode(a);
	String da = decode(ea);
	System.out.println(ea);
	System.out.println(da);
	System.out.println(da.equals(a));
	}
	}