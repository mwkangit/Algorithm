package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2229 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int graph[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
		}
		int dp[] = new int[N];
		dp[0] = 0;
		for(int i = 1 ; i < N ; i++) {
			int mini = graph[i];
			int maxi = graph[i];
			dp[i] = dp[i-1];
			for(int j = i-1 ; j >= 0 ; j--) {
				mini = Math.min(mini, graph[j]);
				maxi = Math.max(maxi, graph[j]);
				if(j - 1 >= 0) {
					dp[i] = Math.max(dp[i], maxi - mini + dp[j-1]);
				}else {
					dp[i] = Math.max(dp[i], maxi - mini);
				}
				
			}
		}
		System.out.println(dp[N-1]);
		
		
		
		
		
	}

}
