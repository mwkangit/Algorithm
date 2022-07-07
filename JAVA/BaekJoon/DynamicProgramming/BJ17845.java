package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class BJ17845 {

	// re 0707
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int graph[][] = new int[K][2];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[N+1][K+1];
		
		for(int i = 1 ; i <= K ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(j - graph[i-1][1] >= 0) {
					dp[j][i] = Math.max(dp[j][i-1], dp[j-graph[i-1][1]][i-1] + graph[i-1][0]);
				} else {
					dp[j][i] = dp[j][i-1];
				}
			}
		}
		
		System.out.print(dp[N][K]);
		
		
	}

}
