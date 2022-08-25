package unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20040 {

	static int N, M;
	static int parent[];
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		parent = new int[N];		
		
		for(int i = 0 ; i < N ; i++) {
			parent[i] = i;
		}
		
		int answer = 0;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = ps(st.nextToken());
			int b = ps(st.nextToken());
			if(find(a) != find(b)) {
				union(a, b);
			}else {
				answer = i+1;
				break;
			}
		}
		System.out.println(answer);
		
		
	}

	static int find(int i) {
		if(parent[i] == i) {
			return i;
		}else {
			return find(parent[i]);
		}
	}
	static void union(int a, int b) {
		int c = find(a);
		int d = find(b);
		
		if(c < d) {
			parent[d] = c;
			parent[b] = c;
		}else if(c > d) {
			parent[c] = d;
			parent[a] = d;
		}
		
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}
	

}
