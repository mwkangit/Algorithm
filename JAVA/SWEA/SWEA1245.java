package swExpertAcademy;

import java.util.*;
import java.io.*;

public class SWEA1245 {
	static int N;
	static int graph[];
	static int weight[];
	static double answer[];
	static double limit = Math.pow(10, -12) * (Math.exp(1)-12);

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=ps(br.readLine());
		System.out.println(limit);
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = ps(st.nextToken());
			st = new StringTokenizer(br.readLine());
			graph = new int[N];
			weight = new int[N];
			answer = new double[N-1];
			for(int i = 0 ; i < N ; i++) {
				graph[i] = ps(st.nextToken());
			}
			for(int i = 0 ; i < N ; i++) {
				weight[i] = ps(st.nextToken());
			}
			sb.append("#").append(test_case).append(" ");
			for(int i = 0 ; i < N - 1  ; i++) {
				
				double num = doFunction(i, i+1);
				sb.append(String.format("%.10f", num)).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static double doFunction(int a1, int a2) {
		
		double left = graph[a1];
		double right = graph[a2];
		double mid = 0;
		int cnt = 0;
		
		while(cnt < 101) {
			mid = (left + right) / 2;
			double leftSum = 0;
			double rightSum = 0;
			for(int i = 0 ; i <= a1 ; i++) {
				leftSum += weight[i] / Math.pow(mid - graph[i],2);
			}
			for(int i = a2 ; i < N ; i++) {
				rightSum += weight[i] / Math.pow(mid - graph[i], 2);
			}
			double sum = leftSum - rightSum;
			if(Math.abs(sum) < limit) {
				return mid;
			}else if(sum < 0) {
				right = mid;
			}else {
				left = mid;
			}
			cnt++;
		}
		return mid;
		
	}
	
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
