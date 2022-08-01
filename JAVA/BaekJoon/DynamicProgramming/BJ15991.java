package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15991 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		long dp[] = new long[100001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;
		
		for(int i = 7 ; i <= 100000 ; i++) {
			dp[i] = (dp[i-2] + dp[i-4] + dp[i-6])%1000000009;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}
		System.out.print(sb);

	}

}
