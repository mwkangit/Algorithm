package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1915 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int graph[][] = new int[n+1][m+1];
		int answer = 0;
		for(int i = 1 ; i <= n ; i++) {
			String str = br.readLine();
			for(int j = 1 ; j <= m ; j++) {
				graph[i][j] = str.charAt(j-1) - '0';
				if(str.charAt(j-1) - '0' == 1) {
					answer = 1;
				}
			}
		}
		
		int dp[][][] = new int[n+1][m+1][3];
		if(answer == 0) {
			System.out.print(0);
			return;
		}
		
		for(int i = 1 ; i <= n ; i++) {
			if(graph[i][1] == 1) {
				dp[i][1][0] = 1;
				dp[i][1][1] = dp[i-1][0][1]+1;
				dp[i][1][2] = 1;
			}
		}
		for(int i = 0 ; i <= n ; i++) {
			for(int j = 0 ; j <= m ; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 1 ; i <= m ; i++) {
			if(graph[1][i] == 1) {
				dp[1][i][0] = 1;
				dp[1][i][1] = 1;
				dp[1][i][2] = dp[1][i-1][2] + 1;
			}
		}
		
		
		for(int i = 2 ; i <= n ; i++) {
			for(int j = 2 ; j <= m ; j++) {
				if(graph[i][j] == 1) {
					int degak = dp[i-1][j-1][0];
					int up = dp[i-1][j][1];
					int left = dp[i][j-1][2];
					
					int mini = Math.min(degak, Math.min(up, left));
					
					answer = Math.max(answer, mini+1);
					
					dp[i][j][0] = mini+1;
					dp[i][j][1] = up+1;
					dp[i][j][2] = left+1;
				}
			}
		}
		System.out.print((int)Math.pow(answer, 2));

		
	}

}
