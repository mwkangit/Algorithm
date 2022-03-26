package DynamicProgramming;

import java.util.*;
import java.io.*;


public class BJ16194 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = sc.nextInt();
		}
		int dp[] = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = arr[1];
		
		for(int i = 2 ; i <= N ; i++) {
			for(int j = 1 ; j < i ; j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
			}
			dp[i] = Math.min(dp[i], arr[i]);
		}
		
		System.out.print(dp[N]);
		
	}

}
