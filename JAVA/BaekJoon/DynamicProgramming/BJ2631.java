package DynamicProgramming;

import java.util.*;
import java.io.*;

public class BJ2631 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int dp[] = new int[N];
		dp[0] = 1;
		int maxi = 0;
		for(int i = 1 ; i < N ; i++) {
			dp[i] = 1;
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] > arr[j])dp[i] = Math.max(dp[i], dp[j]+1);
			}
			maxi = Math.max(maxi, dp[i]);
		}
		
		System.out.print(N-maxi);
		
		
		
		
	}

}
