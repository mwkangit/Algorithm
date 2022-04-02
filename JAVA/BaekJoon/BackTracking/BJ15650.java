package swmaestro;

import java.util.*;
import java.io.*;

public class BJ15650 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int arr[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = i+1;
		}
		
		dfs(arr, M, 0, 0, new int[M]);
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);

	}
	
	static void dfs(int[] arr, int M, int d, int curr, int comp[]) {
		if(d == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(comp[i] + " ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
			
		}else {
			for(int i = curr ; i < arr.length ; i++) {
				comp[d] = arr[i];
				dfs(arr, M, d+1, i+1, comp);
			}
		}
	}

}
