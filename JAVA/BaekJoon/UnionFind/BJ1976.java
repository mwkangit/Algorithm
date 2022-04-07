package UnionFind;

import java.util.*;
import java.io.*;

public class BJ1976 {

	static int N, M;
	static int parent[];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parse(br.readLine());
		M = parse(br.readLine());
		parent = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parent[i] = i;
		}
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				int num = parse(st.nextToken());
				if(num == 1) {
					union(i, j);
				}
			}
			
			
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = parse(st.nextToken())-1;
		int dest = find(a);
		boolean flag = true;
		for(int i = 1 ; i < M ; i++) {
			a = parse(st.nextToken())-1;
			if(find(a) != dest) {
				flag = false;
				break;
			}
		}
		
		System.out.print(flag ? "YES" : "NO");
		

	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if(a<b) {
				parent[b] = a;
			}else {
				parent[a] = b;
			}
		}
		
		
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	static int parse(String str) {
		return Integer.parseInt(str);
	}

}
