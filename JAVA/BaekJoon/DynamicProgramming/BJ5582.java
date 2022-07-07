package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5582 {
	
	static String str1;
	static String str2;
	static boolean flag = false;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		
		
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		int answer = 0;
		
		for(int i = 1 ; i <= str1.length() ; i++) {
			for(int j = 1 ; j < str2.length() ; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		System.out.print(answer);
		
		
	}
	
}
