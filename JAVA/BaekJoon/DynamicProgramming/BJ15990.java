package DynamicProgramming;

import java.util.*;
import java.io.*;

public class BJ15990 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T];
		
		for(int loop = 0 ; loop < T ; loop++) {
			int num = Integer.parseInt(br.readLine());
			arr[loop] = num;
		}
		int dp[][] = new int[100001][3];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[0][2] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		for(int j = 3 ; j < 100001 ; j++) {
			dp[j][0] = (dp[j-1][1] + dp[j-1][2]) % 1000000009;
			dp[j][1] = (dp[j-2][0] + dp[j-2][2])% 1000000009;
			dp[j][2] = (dp[j-3][0] + dp[j-3][1])% 1000000009;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < T ; i++) {
			int num = arr[i];
			sb.append(((dp[num-1][0]+dp[num-1][1])%1000000009+dp[num-1][2])% 1000000009 + "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
		
		
		
	}

}
