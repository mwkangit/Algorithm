package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BJ11048 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][M];
		int dp[][] = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = graph[0][0];
		for(int i = 1 ; i < M ; i++) {
			dp[0][i] = graph[0][i] + dp[0][i-1];
		}
		for(int i = 1 ; i < N ; i++) {
			dp[i][0] = graph[i][0] + dp[i-1][0];
		}
		for(int i = 1 ; i < N ; i++) {
			for(int j = 1 ; j < M ; j++) {
				dp[i][j] = graph[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
			}
		}
		
		System.out.print(dp[N-1][M-1]);
	}

}
