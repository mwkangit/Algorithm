package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12849Again {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int D = Integer.parseInt(st.nextToken());
		
		long dp[][] = new long[8][D+1];
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		
		for(int i = 2 ; i <= D ; i++) {
			dp[0][i] = (dp[1][i-1] + dp[2][i-1])% 1000000007;
			dp[1][i] = (dp[0][i-1] + dp[2][i-1] + dp[3][i-1])% 1000000007;
			dp[2][i] = (dp[0][i-1] + dp[1][i-1] + dp[3][i-1] + dp[4][i-1])% 1000000007;
			dp[3][i] = (dp[1][i-1] + dp[2][i-1] + dp[4][i-1] + dp[5][i-1])% 1000000007;
			dp[4][i] = (dp[2][i-1] + dp[3][i-1] + dp[5][i-1] + dp[6][i-1])% 1000000007;
			dp[5][i] = (dp[3][i-1] + dp[4][i-1] + dp[7][i-1])% 1000000007;
			dp[6][i] = (dp[4][i-1] + dp[7][i-1])% 1000000007;
			dp[7][i] = (dp[5][i-1] + dp[6][i-1])% 1000000007;
		}
		
		System.out.print(dp[0][D] % 1000000007);
	}

}
