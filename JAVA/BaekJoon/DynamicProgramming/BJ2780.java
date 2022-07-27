package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2780 {

	static int T, N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = ps(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int loop = 0 ; loop < T ; loop++) {
			st = new StringTokenizer(br.readLine());
			N = ps(st.nextToken());
			long dp[][] = new long[10][N+1];
			for(int i = 0 ; i < 10 ; i++) {
				dp[i][1] = 1;
			}
			for(int i = 2 ; i <= N ; i++) {
				for(int j = 0 ; j < 10 ; j++) {
					if(j == 0) {
						dp[0][i] = dp[7][i-1];
					}else if(j == 1) {
						dp[1][i] = dp[2][i-1] + dp[4][i-1];
					}else if(j == 2) {
						dp[2][i] = dp[1][i-1] + dp[3][i-1] + dp[5][i-1];
					}else if(j == 3) {
						dp[3][i] = dp[2][i-1] + dp[6][i-1];
					}else if(j == 4) {
						dp[4][i] = dp[1][i-1] + dp[5][i-1] + dp[7][i-1];
					}else if(j == 5) {
						dp[5][i] = dp[2][i-1] + dp[4][i-1] + dp[6][i-1] + dp[8][i-1];
					}else if(j == 6) {
						dp[6][i] = dp[3][i-1] + dp[5][i-1] + dp[9][i-1];
					}else if(j == 7) {
						dp[7][i] = dp[4][i-1] + dp[8][i-1] + dp[0][i-1];
					}else if(j == 8) {
						dp[8][i] = dp[5][i-1] + dp[7][i-1] + dp[9][i-1];
					}else if(j == 9) {
						dp[9][i] = dp[6][i-1] + dp[8][i-1];
					}
					dp[j][i] %= 1234567;
				}
				
			}
			long result = 0;
			for(int i = 0 ; i < 10 ; i++) {
				result = (result + dp[i][N]) % 1234567;
			}
			sb.append(result).append("\n");
			
		}
		System.out.print(sb);
		
		
	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
