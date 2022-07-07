package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2056 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[N+1];
		int answer = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			if(i == 1) {
				dp[1] = t;
				answer = t;
				continue;
			}
			dp[i] = t;
			
			if(f != 0) {
				for(int j = 0 ; j < f ; j++) {
					int num = Integer.parseInt(st.nextToken());
					dp[i] = Math.max(dp[i], dp[num] + t);
				}
			}
			answer = Math.max(answer, dp[i]);
			
			
		}
		System.out.print(answer);
		
	}

}
