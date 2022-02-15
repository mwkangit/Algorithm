package DynamicProgramming;

import java.util.*;
import java.io.*;

public class BJ1149 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int color[][] = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String sub[] = br.readLine().split(" ");
			color[i][0] = Integer.parseInt(sub[0]);
			color[i][1] = Integer.parseInt(sub[1]);
			color[i][2] = Integer.parseInt(sub[2]);
		}
		
		int dp[][] = new int[N][N];
		
		dp[0][0] = color[0][0];
		dp[0][1] = color[0][1];
		dp[0][2] = color[0][2];
		
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				for(int k = 0 ; k < 3 ; k++) {
					if(k != j) {
						if(dp[i][j] == 0) {
							dp[i][j] = dp[i-1][k] + color[i][j];
						}else {
						dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + color[i][j]);
					
						}
					}
				}
			}
		}
		int min = 987654321;
		for(int i = 0 ; i < 3 ; i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		
		System.out.print(min);
		
		
		
	}

}
