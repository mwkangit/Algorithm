package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17142 {

	static int N;
	static int M;
	static ArrayList<Node> virus = new ArrayList<>();
	static int space = 0;
	static int mini = Integer.MAX_VALUE;
	static int graph[][];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				int sub = Integer.parseInt(st.nextToken());
				if(sub == 2) {
					virus.add(new Node(i, j, 0));
				} else if(sub == 0) {
					space++;
				}
				graph[i][j] = sub;
			}
		}
		
		dfs(new Node[M], 0, 0);
		if(space == 0) {
			System.out.print(0);
		}
		else if(mini == Integer.MAX_VALUE) {
			System.out.print(-1);
		}else {
			System.out.print(mini);
		}
		
		
	}
	
	static void spread(Node list[], int spc) {
		
		Queue<Node> q = new LinkedList<>();
		boolean comp[][] = new boolean[N][N];
		for(int i = 0 ; i < M ; i++) {
			Node node = list[i];
			q.add(node);
			comp[node.row][node.col] = true;
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int row = node.row + r[i];
				int col = node.col + c[i];
				
				if(row < 0 || row >= N || col < 0 || col >= N || comp[row][col] || graph[row][col] == 1) continue;
				
				if(graph[row][col] == 0) {
					spc--;
				}
				
				comp[row][col] = true;
				q.add(new Node(row, col, node.d+1));
				
				if(spc == 0) {
					mini = Math.min(mini, node.d+1);
					return;
				}
			}
		}
		
	}
	
	static void dfs(Node list[], int start, int d) {
		if(d == M) {
			spread(list, space);
		}else {
			for(int i = start ; i < virus.size() ; i++) {
				list[d] = virus.get(i);
				dfs(list, i+1, d+1);
			}
		}
	}

	static class Node{
		int row;
		int col;
		int d;
		
		public Node(int r, int c, int d) {
			row = r;
			col = c;
			this.d = d;
		}
	}
	
}
