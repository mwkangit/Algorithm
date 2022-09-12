package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4883 {

	static int N;
	static int graph[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = ps(st.nextToken());
			if(N == 0)break;
			graph = new int[N][3];
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 3 ; j++) {
					graph[i][j] = ps(st.nextToken());
				}
			}
			
			int dp[][] = new int[N][3];
			
			dp[0][0] = 987654321;
			dp[0][1] = graph[0][1];
			dp[0][2] = graph[0][2] + graph[0][1];
			
			for(int i = 1 ; i < N ; i++) {
				dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + graph[i][0];
				dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], Math.min(dp[i][0], dp[i-1][2]))) + graph[i][1];
				dp[i][2] = Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i][1])) + graph[i][2];
			}
			sb.append(count++).append(". ").append(dp[N-1][1]).append("\n");
			
			
		}
		System.out.print(sb);
		

	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}