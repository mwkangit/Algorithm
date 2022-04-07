package UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1717 {

	static int n, m;
	static int parent[];
	static ArrayList<String> answer = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			parent[i] = i;
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(op == 0) {
				union(a, b);
			}else {
				int num1 = find(a);
				int num2 = find(b);
				answer.add(num1 == num2 ? "YES" : "NO");
			}
		}
		
		for(int i = 0 ; i < answer.size() ; i++) {
			System.out.println(answer.get(i));
		}
	}
	
	static void union(int a, int b) {
		int num1 = find(a);
		int num2 = find(b);
		
		if(num1 == num2) return;
		else {
			parent[num2] = num1;
			return;
		}
	}
	
	static int find(int a) {
		
		if(parent[a] == a) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
//	static class Node{
//		int parent;
//		int num;
//		
//		public Node(int p, int n) {
//			parent = p;
//			num = n;
//		}
//	}

}

/*
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.util.ArrayList; import
 * java.util.LinkedList; import java.util.Queue; import
 * java.util.StringTokenizer;
 * 
 * 
 * 
 * public class Main {
 * 
 * static int N, M;
 * 
 * static BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in)); static StringTokenizer st; static
 * StringBuilder sb = new StringBuilder(); static int[] parent; static int[]
 * rank;
 * 
 * 
 * 
 * public static void main(String[] args) throws IOException {
 * 
 * input();
 * 
 * System.out.println(sb);
 * 
 * }
 * 
 * static void input() throws IOException {
 * 
 * st = new StringTokenizer(br.readLine());
 * 
 * N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
 * 
 * makeSet();
 * 
 * 
 * 
 * for(int i = 0; i<M; i++) { st = new StringTokenizer(br.readLine()); int a =
 * Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
 * int c = Integer.parseInt(st.nextToken());
 * 
 * 
 * 
 * if(a == 0) { union(b,c); }else { String answer = sameParent(b,c) ? "YES" :
 * "NO"; sb.append(answer).append('\n'); } }
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * static void makeSet() { parent = new int[N+1]; rank = new int[N+1]; for(int i
 * = 1; i<=N; i++) { parent[i]=i; rank[i]=1; } }
 * 
 * static int find(int a) { if(a == parent[a]) { return a; } return parent[a] =
 * find(parent[a]); }
 * 
 * static void union(int x, int y) { x = find(x); y = find(y); if(x!=y) { if(x <
 * y) parent[y] = x; else parent[x] = y; } }
 * 
 * static boolean sameParent(int x, int y) { x = find(x); y = find(y);
 * 
 * return (x==y) ? true:false; }
 * 
 * 
 * 
 * 
 * }
 */
// makeSet()에서 부모를 지정하는 것 보기
// 랭크는 왜 사용하는거지?
// find()는 거의 동일하게 사용
// 반드시 StringBuilder 사용하여 '\n'로 나눠서 한번에 출력
	



// bfs로 풀 수 있긴 하지만 오래 걸릴 것으로 보인다.