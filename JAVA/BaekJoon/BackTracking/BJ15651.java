package swmaestro;

import java.util.*;
import java.io.*;

public class BJ15651 {

	static StringBuilder sb = new StringBuilder();
	static int comp[];
	static int arr[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		comp = new int[M];
		
		arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = i+1;
		}
		
		dfs(M, 0);
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);

	}
	
	static void dfs(int M, int d) {
		if(d == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(comp[i]).append(' ');
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
			
		}else {
			for(int i = 0 ; i < arr.length ; i++) {
				comp[d] = arr[i];
				dfs(M, d+1);
			}
		}
	}

}
