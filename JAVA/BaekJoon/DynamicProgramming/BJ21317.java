package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ21317 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = ps(st.nextToken());
        
        int arr[][] = new int[N-1][2];
        for(int i = 0 ; i < N-1 ; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = ps(st.nextToken());
        	arr[i][1] = ps(st.nextToken());
        }

        int K = ps(br.readLine());
        
        int reDp[][] = new int[N][3];
        for(int i = 0 ; i < N ; i++) {
        	Arrays.fill(reDp[i], 987654321);
        }
        if(N == 1) {
        	System.out.print(0);
        	return;
        }else if(N==2) {
        	System.out.print(arr[0][0]);
        	return;
        }
        reDp[0][0] = 0;
        reDp[0][1] = 0;
        reDp[1][0] = arr[0][0];
        reDp[1][1] = arr[0][0];
        for(int i = 2 ; i < N ; i++) {
        	reDp[i][0] = Math.min(reDp[i-1][0], reDp[i-1][1]) + arr[i-1][0];
        	reDp[i][1] = Math.min(reDp[i-2][0], reDp[i-2][1]) + arr[i-2][1];
        }
        int answer = Math.min(reDp[N-1][0], reDp[N-1][1]);
        
        for(int i = 3 ; i < N ; i++) {
        	int dp[][] = new int[N][3];
        	copy(dp,reDp, N);
        	
        	for(int j = i ; j < N ; j++) {
        		
        		dp[j][0] = Math.min(dp[j-1][0], Math.min(dp[j-1][1], dp[j-1][2])) + arr[j-1][0];
        		dp[j][1] = Math.min(dp[j-2][0], Math.min(dp[j-2][1], dp[j-2][2])) + arr[j-2][1];
        		if(j == i) {
        			dp[j][2] = Math.min(dp[j-3][0], dp[j-3][1]) + K;
        		}
        	}
        	answer = Math.min(answer, Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
        	
        }

        System.out.print(answer);
	}
	static void copy(int[][] dp, int[][] reDp, int N) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				if(j==2) {
					dp[i][j] = 987654321;
					continue;
				}
				dp[i][j] = reDp[i][j];
			}
		}
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
