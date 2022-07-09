package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11058 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		long dp[] = new long[100+1];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;
		dp[5] = 5;
		dp[6] = 6;
		
		
		for(int i = 7 ; i <= N ; i++) {
			for(int j = 3 ; j < 6 ; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
			}
		}
		System.out.print(dp[N]);
	}

}
