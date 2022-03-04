/*
PROBLEM1 : given 10 digit number ,you have to count the number of ways you can put 0-9 (10 digits) in 
           10 places. NOTE : no leading zero allowed
         -- mathematical solution will be : 9*10*10*10 ... 10
         -- we are solving with bit-mask dp to make learn dp
         
         -- bit operation:
            
*/


package test;

import java.util.*;


public class BitMaskDP1 {

	int n;
	int[][] dp;
	int NUMBER_OF_DIGIT =10;
	
	boolean checkMask(int mask) {
		
		return (mask & ((1<<this.NUMBER_OF_DIGIT) - 1)) == ((1<<this.NUMBER_OF_DIGIT)-1); // 1 shifted 10 times
											   // that means 
											   // 111111111
	}
	

	
	
	int dpFunction(int pos, int mask) {
		//System.out.print("found"+pos+" "+mask);
		if(pos >= n) 
			if (checkMask(mask) == true) {
				System.out.println(pos+" found");
				return 1; // found one way
			}
		
		if(dp[pos][mask] != -1) return dp[pos][mask];
		
		
		int low = 0, ret = 0 ;
		if (pos == 0) low = 1;
		
		for (int i = low ; i < this.NUMBER_OF_DIGIT ; i ++) {
			int val = dpFunction(pos+1, mask | (1 << pos));
			ret += val;
		}
		
		
		dp[pos][mask] = ret;
		
		return dp[pos][mask];
	}
	
	int caller() {
		n = this.NUMBER_OF_DIGIT;
		int size2 = (1<<this.NUMBER_OF_DIGIT) + 2;
		dp = new int[1000][size2];
		
        for (int[] test : dp) {
        	
        	for (int j = 0 ; j < test.length;j++) {
        		test[j] = -1;
        	}
        }
		
		int result = this.dpFunction(0, 0);
		
		
		System.out.print(result);
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		BitMaskDP1 bitMaskDp1 = new BitMaskDP1();
		bitMaskDp1.caller();
		
		
		System.out.println("  test");
	}
}
