package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2240 {

	// re 0617
	// 06/20 아직도 왜 저렇게 되는지 모르겠다
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = stoi(st.nextToken());
		int W = stoi(st.nextToken());
		
		int graph[] = new int[T+1];
		for(int i = 1 ; i <= T ; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i] = stoi(st.nextToken());
		}
//		System.out.println(0%2);
		int dp[][] = new int[T+1][31];
		int zeroCount = 0;
		if(graph[1] == 1) {
			dp[1][0] = 1;
			zeroCount++;
		} else {
			dp[1][1] = 1;
		}
		
		
		for(int i = 2 ; i <= T ; i++) {
			
			int num = graph[i];
			if(num == 1) zeroCount++;
			
			
			for(int j = 0 ; j <= W ; j++ ) {
				if(j == 0) {
					dp[i][0] = zeroCount;
					continue;
				}
				
				if(j % 2 == 0) {
					if(num == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]+1);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
					}
				} else {
					if(num == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
					}else {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
						
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 0 ; i < 31 ; i++) {
			result = Math.max(result, dp[T][i]);
		}
		System.out.print(result);
		
	}
	
	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
