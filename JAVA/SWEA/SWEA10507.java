package swExpertAcademy;

import java.util.*;
import java.io.*;

public class SWEA10507 {

	static int n, p;
	static int arr[];
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=ps(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = ps(st.nextToken());
			p = ps(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			int big = 0;
			for(int i = 0 ; i < n ; i++) {
				int num = ps(st.nextToken());
				arr[i] = num;
				big = Math.max(big, num);
			}
			boolean list[] = new boolean[big+1+p];
			
			for(int i = 0 ; i < n ; i++) {
				list[arr[i]] = true;
			}
			
			int left = 0;
			int right = -1;
			int count = 0;
			int answer = 0;
			
			while(right < big+p) {
				if(list[right+1]) {
					right++;
					answer = Math.max(answer, right-left+1);
				}else {
					if(count >= p) {
						if(!list[left]) {
							count--;
						}
						left++;
					}else {
						right++;
						if(right > big+p)break;
						if(!list[right]) {
							count++;
						}
						answer = Math.max(answer, right-left+1);
					}
				}
				
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
			
		}
		System.out.print(sb);
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
