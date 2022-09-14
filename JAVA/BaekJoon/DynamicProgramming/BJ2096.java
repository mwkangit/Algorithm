package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2096 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = ps(st.nextToken());
		
		int graph[][] = new int[N][3];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				int num = ps(st.nextToken());
				graph[i][j] = num;
			}
		}
		
		int dp[][] = new int[N][3];
		dp[0][0] = graph[0][0];
		dp[0][1] = graph[0][1];
		dp[0][2] = graph[0][2];
		for(int i = 1 ; i < N ; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + graph[i][0];
			dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + graph[i][1];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + graph[i][2];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < 3 ; i++) {
			max = Math.max(max, dp[N-1][i]);
		}
		
		
		dp = new int[N][3];
		dp[0][0] = graph[0][0];
		dp[0][1] = graph[0][1];
		dp[0][2] = graph[0][2];
		for(int i = 1 ; i < N ; i++) {
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + graph[i][0];
			dp[i][1] = Math.min(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + graph[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + graph[i][2];
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3 ; i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		
		System.out.print(max + " " + min);
		
	}
	
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}
}
