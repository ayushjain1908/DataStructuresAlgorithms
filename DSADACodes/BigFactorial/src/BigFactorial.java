import java.util.Scanner;

public class BigFactorial {
	public static final int SIZE = 1500;
	public static void factorial(int n){
		int[] result = new int[SIZE];
		int rsize = 1;
		result[0] = 1;
		for(int i = 2; i <= n; i++){
			rsize = numMultiply(i,result,rsize);
		}
		System.out.println("The factorial of " + n +" is");
		for(int i = rsize-1; i >= 0;i--){
			System.out.print(result[i]);
		}
		System.out.println();
		System.out.println("Phew! The total number of digits is " + rsize);
	}
	private static int numMultiply(int x,int[] result,int rsize){
		int carry = 0;
		for(int i = 0; i < rsize; i++){
			int prod = x * result[i] + carry;
			int d = prod%10;
		    carry = prod/10;
		    result[i] = d;
		}
		while(carry > 0){
			result[rsize] = carry%10;
			carry = carry/10;
			rsize++;
		}
		return rsize;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = in.nextInt();
		factorial(num);
	}
}
