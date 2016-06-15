
public class ReplaceSpacesWithString4 {

	// replaces spaces with %20
	public static int replaceSpaces(char[] cstr,int length){
		int countSpaces = 0 ;
		for(int i = 0; i < length ; i++){
			if(cstr[i] == ' '){
				countSpaces++;
			}
		}
		int newLength = length + countSpaces*2;
		int index = newLength;
		cstr[index] = '\0';
		for(int i = length - 1; i >= 0 ; i--){
			if(cstr[i] == ' '){
				cstr[index - 1] = '0';
				cstr[index - 2] = '2';
				cstr[index - 3] = '%';
				index = index - 3;
			}
			else{
				cstr[index - 1] = cstr[i];
				index = index - 1; 
			}
		}
		return newLength;
	}
	private static void printCharArrayAsString(char[] carr, int length){
		for(int i = 0 ; i < length ;i++){
			System.out.print(carr[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String str = " a bcv   g t                   ";
		char[] carr = str.toCharArray();
		printCharArrayAsString(carr, 12);
		int newLength = replaceSpaces(carr, 12);
		printCharArrayAsString(carr, newLength);
	}
}
