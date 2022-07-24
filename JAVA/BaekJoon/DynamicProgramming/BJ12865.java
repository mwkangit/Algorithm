package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865 {
	// re0721
	static int N, K;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ps(st.nextToken());
		K = ps(st.nextToken());
		
		int arr[][] = new int[N+1][2];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = ps(st.nextToken());
			arr[i][1] = ps(st.nextToken());
		}
		int dp[][] = new int[N+1][K+1];
		
		for(int i = 1 ; i <= K ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(arr[j][0] > i) {
					dp[j][i] = dp[j-1][i];
				}else {
					dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-arr[j][0]] + arr[j][1]);
				}
			}
		}
		System.out.print(dp[N][K]);
		
		
	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
