package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2579 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int stair[] = new int[N + 1];
		int dp[][] = new int[3][N + 1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			stair[i] = Integer.parseInt(st.nextToken());
		}
		dp[0][1] = 0;
		dp[1][1] = stair[1];
		dp[2][1] = 1;
		if(N != 1) {
			for(int i = 2 ; i <= N ; i++) {
				int comp1 = dp[0][i-2];
				int comp2 = dp[1][i-2];
				dp[0][i] = stair[i] + Math.max(comp1, comp2);
				
				comp1 = dp[0][i-1];
				comp2 = dp[1][i-1];
				if(comp2 > comp1 && dp[2][i-1] + 1 < 3) {
					dp[2][i] = dp[2][i-1]+1;
					dp[1][i] = stair[i] + comp2;
				} else {
					dp[2][i] = 2;
					dp[1][i] = stair[i] + comp1;
				}
				
			}
		}
		System.out.print(Math.max(dp[0][N], dp[1][N]));
		

	}

}
