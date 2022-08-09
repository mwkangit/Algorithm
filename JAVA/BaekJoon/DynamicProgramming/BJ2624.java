package dynamicProgramming;

import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2624 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = ps(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = ps(st.nextToken());
        int arr[][] = new int[k+1][2];
        for(int i = 1 ; i <= k ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int num1 = ps(st.nextToken());
        	int num2 = ps(st.nextToken());
        	arr[i][0] = num1;
        	arr[i][1] = num2;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] i1, int[] i2) {
        		return i1[0] - i2[0];
        	}
        });
        
        int dp[][] = new int[k+1][T+1];
        dp[0][0] = 1;
        
        for(int i = 1 ; i <= k ; i++) {
        	int num = arr[i][0];
        	for(int j = 0 ; j <= T ; j++) {
        		for(int m = 0 ; m <= arr[i][1] ; m++) {
        			int index = j + m*num;
        			if(index > T)break;
        			dp[i][index] += dp[i-1][j];
        		}
        	}
        }
        System.out.print(dp[k][T]);
        
        
        
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
