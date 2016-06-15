import java.util.Arrays;

public class RemoveSpaces {

	public static String removeSpaces(String str){
		char[] charArray = str.toCharArray();
		int numSpaces = 0;
		for(int i = 0 ; i < charArray.length ; i++){
			if(charArray[i] == ' '){
				numSpaces++;
			}
			else{
				charArray[i - numSpaces] = charArray[i];
			}
		}
		charArray = Arrays.copyOf(charArray, charArray.length - numSpaces);
		return new String(charArray);
	}
	public static void main(String[] args) {
		String str = "          Hell o W    ORL D    !";
		System.out.println(str);
		System.out.println(removeSpaces(str));
	}
}
