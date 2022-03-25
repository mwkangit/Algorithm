package DynamicProgramming;

import java.util.*;
import java.io.*;

public class BJ1309 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[N][3];
		
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		for(int i = 1 ; i < N ; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])% 9901;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])% 9901;
		}
		
		System.out.print((dp[N-1][0]+dp[N-1][1]+dp[N-1][2])% 9901);
		
	}

}
