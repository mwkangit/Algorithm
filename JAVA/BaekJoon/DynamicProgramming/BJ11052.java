package DynamicProgramming;

import java.util.*;
import java.io.*;

public class BJ11052 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		int P[] = new int[input.length+1];
		for(int i = 1 ; i <= input.length ; i++) {
			P[i] = Integer.parseInt(input[i-1]);
		}
		
		int dp[] = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= i  ; j++) {
				dp[i] = Math.max(dp[i], P[j] + dp[i-j]);
			}
		}
		
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
