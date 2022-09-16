package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1577 {

	static int N, M, K;
	static HashSet<String> set = new HashSet<>();
	static int graph[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = ps(st.nextToken());
		graph = new int[N+1][M+1];
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			String str1 = "";
			String str2 = "";
			for(int j = 0 ; j < 2 ; j++) {
				int num = ps(st.nextToken());
				str1 += String.valueOf(num) + ",";
			}
			for(int j = 0 ; j < 2 ; j++) {
				int num = ps(st.nextToken());
				str2 += String.valueOf(num) + ",";
			}
			set.add(str1+str2);
			set.add(str2+str1);
		}
		long dp[][] = new long[N+1][M+1];
		dp[0][0] = 1;
		
		for(int i = 1 ; i <= N ; i++) {
			String str = String.valueOf(i-1) + ",0," +String.valueOf(i) + ",0,";
			if(set.contains(str))break;
			else dp[i][0] = 1;
		}
		for(int i = 1 ; i <= M ; i++) {
			String str = "0," + String.valueOf(i-1) + ",0," +String.valueOf(i) + ",";
			if(set.contains(str))break;
			else dp[0][i] = 1;
		}
		
		for(int i = 1; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				long num1, num2;
				String str1 = String.valueOf(i-1) + "," + String.valueOf(j) + "," + String.valueOf(i) + "," + String.valueOf(j) + ",";
				if(set.contains(str1)) {
					num1 = 0;
				}else {
					num1 = dp[i-1][j];
				}
				
				String str2 = String.valueOf(i) + "," + String.valueOf(j-1) + "," + String.valueOf(i) + "," + String.valueOf(j) + ",";
				if(set.contains(str2)){
					num2 = 0;
				}else {
					num2 = dp[i][j-1];
				}
				dp[i][j] = num1 + num2;
			}
		}
		
		System.out.print(dp[N][M]);
		
		
	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
