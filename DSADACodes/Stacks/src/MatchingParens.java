import java.util.*;
public class MatchingParens {
  private static final Map<Character,Character> matchingParenMap = new HashMap<Character,Character>();
  private static final Set<Character> openingParenSet = new HashSet<Character>();
  static{
  matchingParenMap.put(')','(');
  matchingParenMap.put('}','{');
  matchingParenMap.put(']','[');
  openingParenSet.addAll(matchingParenMap.values());
 }
  public static boolean hasMatchingParens(String input){
	Stack<Character> parenStack = new Stack<Character>();
	for(int i = 0 ; i < input.length(); i++){
		char ch = input.charAt(i);
		if(openingParenSet.contains(ch)){
			parenStack.push(ch);
		}
		else if(matchingParenMap.containsKey(ch)){
			char lastParen = parenStack.pop();
			if(lastParen !=  matchingParenMap.get(ch)){
				return false;
			}
		}
	}
    return parenStack.empty();
    
  }
 public static void main(String[] args) {
	 System.out.println(String.format(
             "Has matching parens %s? : %s", "((abcd)", hasMatchingParens("((abcd)")));
     System.out.println(String.format(
             "Has matching parens %s? : %s", "{{{{}}", hasMatchingParens("{{{{}}")));
     System.out.println(String.format(
             "Has matching parens %s? : %s", "{{{{}}})", hasMatchingParens("{{{{}}})")));
     System.out.println(String.format(
             "Has matching parens %s? : %s", "{{{}}}()", hasMatchingParens("{{{}}}()")));
     System.out.println(String.format(
             "Has matching parens %s? : %s", "{{{}}]()", hasMatchingParens("{{{}}]()")));
     System.out.println(String.format(
             "Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
             hasMatchingParens("{{}}([]){}{}{}{}{[[[[]]]]}")));
  }
}