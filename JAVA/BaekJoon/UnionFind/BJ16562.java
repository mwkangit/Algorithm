package unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16562 {

	static int N, M, k;
	static int parent[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		k = ps(st.nextToken());
		
		parent = new int[N+1][2];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1 ; i <= N ; i++) {
			parent[i][0] = i;
			parent[i][1] = ps(st.nextToken());
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			union(ps(st.nextToken()), ps(st.nextToken()));
		}
		HashSet<Integer> set = new HashSet<>();
		int answer = 0;
		for(int i = 1 ; i <= N ; i++) {
			int num = find(i);
			if(!set.contains(num)) {
				k -= parent[num][1];
				if(k < 0)break; 
				answer += parent[num][1];
				set.add(num);
			}
		}
		
		System.out.print(k < 0 ? "Oh no" : answer);
		
		

	}
	
	static int find(int num) {
		if(parent[num][0] == num) {
			return num;
		}else {
			return parent[num][0] = find(parent[num][0]);
		}
	}
	
	static void union(int num1, int num2) {
		num1 = find(num1);
		num2 = find(num2);
		
		if(num1 != num2) {
			if(parent[num1][1] > parent[num2][1]) {
				parent[num1][0] = parent[num2][0]; 
			}else {
				parent[num2][0] = parent[num1][0];
			}
		}
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
