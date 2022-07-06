package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2225 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[K][N+1];
		
		for(int i = 0 ; i <= N ; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1 ; i < K ; i++) {
			for(int j = 0 ; j <= N ; j++) {
				for(int k = 0 ; k <= j ; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % 1000000000;
				}
			}
		}
		System.out.print(dp[K-1][N]);
		
		
		
		

	}

}
