
public class BitManipulation {
	
	// -------------------------------- Get the ith bit ------------------------------------------------
	public static int getBit(int num , int i){
		int mask = 1 << i ; 
		if((num & mask) != 0){
			return 1;
		} 
		else{
			return 0;
		}
	}
	
	// ------------------------------ Set the ith bit --------------------------------------------------
	public static int setBit(int num, int i){
		int mask = 1 << i;
		return num | mask;
	}
	
	//------------------------------- Clear the ith bit ------------------------------------------------
	public static int clearBit(int num, int i){
		int mask = ~(1 << i);
		return num & mask;
	}
	
	//------------------------------ Update the ith bit ------------------------------------------------
	public static int updateBit(int num, int i, int  v){
		num = clearBit(num, i);
		int mask = (v << i);
		return num | mask;
	}
	
	// Convert number to Binary
	public static String getBinary(int num){
		String str = "";
		while(num > 0){
			int bit = num % 2;
			num = num / 2;
			str = bit + str;
		}
		return str;
	}
	
	// Insert m in n from i to j position
	public static int insertOneNumInOther(int n, int m,int i, int j){
		int rightMask = ((1 << i) - 1);
		int allOnes = ~0;
		int leftMask = allOnes << (j+1);
		int mask = leftMask | rightMask;
		int nCleared = n & mask;
		int mShifted = m << i;
		return nCleared | mShifted;
	}

	// Is Power of two
	public static boolean isPowerOfTwo(int num){
		return (num > 0 && (num & (num - 1)) == 0);
	}

	// Num of Bit Swaps required to convert one num to other
	public static int bitSwapsRequired(int a, int b){
		int diffBits = a ^ b;
		int count = 0;
		while(diffBits > 0){
			count++;
			diffBits = diffBits & (diffBits - 1);
		}
		return count;
	}

	// Get Next Largest Number with same number of 1 bits
	public static int getNextLargestWithSameNoOfSetBits(int num){
		int c = num;
		int c0 = 0;
		int c1 = 0;
		while(((c & 1) == 0) && c != 0 ){
			c0++;
			c = c >> 1;
		}
		while((c & 1) == 1){
			c1++;
			c = c >> 1;
		}
		if( c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		int pos = c0 + c1;
		// Setting the rightmost non trailing zero at position pos
		num  = num | (1 << pos);
		// Clear all the bits right of pos
		num &= ~((1 << pos) - 1);
		// Inserting c1 - 1 ones on the right
		num |= (1 << (c1 - 1)) - 1;
		return num;
	}

	// Get Next smallest with same number of 1 bits
	public static int getNextSmallestWithSameNoOfSetBits(int num){
		int c = num;
		int c0 = 0;
		int c1 = 0;
		while( (c & 1) == 1){
			c1++;
			c = c >> 1;
		}
		if(c == 0){
			return -1;
		}
		while((c & 1) == 0 && c != 0){
			c0++;
			c = c >> 1;
		}
		if(c0 + c1 == 31){
			return -1;
		}
		int pos = c1 + c0;
		int allOnes = ~0;
		//Clear bits through 0 to pos
		num &= (allOnes << (pos + 1));
		// c1 + 1 ones at the right most side
		int a = (1 << (c1 + 1)) - 1;
		num |= a << (c0 - 1);
		return num;
	}

	//----------------------------- Driver method / Main method ----------------------------------------
	public static void main(String[] args) {
//		int num = 4;
//		System.out.println(getBit(num, 2));
//		//num = setBit(num, 3);
//		//num = clearBit(num, 1);
//		num = updateBit(num, 3, 1);
//		System.out.println(num);
//		System.out.println(-4 >>> 2);
//		int num = insertOneNumInOther(256,5,2,4);
//		System.out.println(num);
//		String str = getBinary(9);
//		System.out.println(str);
//		int a = 8;
//		System.out.println("Is " + a +" a power of two ? " + isPowerOfTwo(a));
//		int num1 = 29;
//		int num2 = 15;
//		System.out.println("Bit swaps required are " + bitSwapsRequired(num1,num2));
        int num = 37;
		System.out.println(getBinary(num));
//		num = getNextLargestWithSameNoOfSetBits(num);
//		System.out.println(num);
//		System.out.println(getBinary(num));
		num = getNextSmallestWithSameNoOfSetBits(num);
		System.out.println(num);
		System.out.println(getBinary(num));
	}
	
}
