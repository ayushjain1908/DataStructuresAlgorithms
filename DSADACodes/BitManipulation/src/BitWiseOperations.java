import java.util.*;
import java.lang.*;
import java.io.*;
 
class BitWiseOperations {
       
      static void printBits(int num){
             for(int i = 31; i >= 0; i--){
                 int checkBit = 1 << i;
                 int result = num & checkBit;
                 if(result == checkBit){
                    System.out.print(1);
                   }
                else{
                    System.out.print(0);
                 }
               }
          }
      static void printNBit(int num, int n){
                  int checkBit = 1 << n;
                  int result = num & checkBit;
                  if(result == checkBit){
                          System.out.println(1);
                     }
                  else{
                        System.out.println(0);
                   }
           }
      public static int count1bits(int num){
             int count = 0;
             while(num != 0){
                  num = num & (num - 1);
                  count++;
                 }
             return count;
        }
                
      public static int reverseBits(int num){
              int revNum = 0 ;
              int count =  31;
              while(num != 0){
                    int lastBit = num & 1;
                    revNum = revNum | lastBit;
                    num = num >> 1;
                    revNum = revNum << 1;
                    count--;
               }
              revNum = revNum << count;
              return revNum;
          }
     public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           printBits(10);
           System.out.println();
           int rev = reverseBits(10);
           printBits(rev);                   
     }
}