package DynamicProgramming;

import java.util.*;

public class BJ9084 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int loop = 0 ; loop < T ; loop++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i = 0 ; i < N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int M = sc.nextInt();
			
			int dp[] = new int[M+1];
			dp[0] = 1;
			for(int i = 0 ; i < N ; i++) {
				int num = arr[i];
				int index = num;
				while(index <= M) {
					dp[index] += dp[index-num];
					index++;
				}
			}
			sb.append(dp[M] + "\n");
			
		}
		sb.deleteCharAt(sb.length()-1);
		
		System.out.print(sb);
		
		
	}

}
