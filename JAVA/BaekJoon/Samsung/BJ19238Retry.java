package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ19238Retry {

	static int N, M, NRG;
	static int graph[][];
	static Node cust[];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int t_row, t_col, gasy;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		NRG = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		cust = new Node[M+2];
		gasy = NRG;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		t_row = Integer.parseInt(st.nextToken()) - 1;
		t_col = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i = 2 ; i < M + 2 ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ro = Integer.parseInt(st.nextToken()) - 1;
			int co = Integer.parseInt(st.nextToken()) - 1;
			cust[i] = new Node(i, ro, co, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
			graph[ro][co] = i;
		}
		
		boolean flag = true;
		for(int i = 0 ; i < M ; i++) {
			flag = findCust();
			if(!flag) break;
		}
		
		if(flag) {
			System.out.print(gasy);
		} else {
			System.out.print(-1);
		}
		
		
	}
	
	static boolean findCust() {
		
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][N];
		
		q.add(new Node(0, t_row, t_col, 0, 0, 0));
		visit[t_row][t_col] = true;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.gas > n2.gas) {
					return 1;
				} else if(n1.gas == n2.gas) {
					if(n1.row > n2.row) {
						return 1;
					} else if(n1.row == n2.row) {
						if(n1.col > n2.col) {
							return 1;
						} else {
							return -1;
						}
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});
		if(graph[t_row][t_col] < 1) {
				
			while(!q.isEmpty()) {
				Node node = q.poll();
	
				for(int i = 0; i < 4 ; i++) {
					int row = node.row + r[i];
					int col = node.col + c[i];
					
					if(row < 0 || row >= N || col < 0 || col >= N || graph[row][col] == 1 || visit[row][col]) continue;
					visit[row][col] = true;
					
					if(graph[row][col] == 0) {
						q.add(new Node(graph[row][col], row, col, 0, 0, node.gas+1));
					} else if(graph[row][col] > 1) {
						pq.add(new Node(graph[row][col], row, col, 0, 0, node.gas+1));
						q.add(new Node(graph[row][col], row, col, 0, 0, node.gas+1));
					}
					
				}
			}
		} else {
			pq.add(new Node(graph[t_row][t_col], t_row, t_col, 0, 0, 0));
		}
		if(pq.isEmpty()) {
			return false;
		}else {
			Node node = pq.poll();
			gasy -= node.gas;
			if(gasy < 0) return false;
			int number = node.num;
			node = cust[number];
			graph[node.row][node.col] = 0;
			
			t_row = node.row;
			t_col = node.col;
			boolean flag = goDest(node.d_row, node.d_col);
			if(!flag) return false;
			
		}
		return true;
	}
	
	static boolean goDest(int d_row, int d_col) {
		
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][N];
		
		q.add(new Node(0, t_row, t_col, 0, 0, 0));
		visit[t_row][t_col] = true;
		
		boolean found = true;
		int total_gas = 0;
		
			while(!q.isEmpty()) {
				Node node = q.poll();
	
				for(int i = 0; i < 4 ; i++) {
					int row = node.row + r[i];
					int col = node.col + c[i];
					
					if(row < 0 || row >= N || col < 0 || col >= N || graph[row][col] == 1 || visit[row][col]) continue;
					visit[row][col] = true;
					
					if(row == d_row && col == d_col) {
						found = false;
						total_gas = node.gas + 1;
					} 
					q.add(new Node(graph[row][col], row, col, 0, 0, node.gas+1));
					
				}
				if(!found) break;
			}
			
			if(found) return false;
			else {
				if(gasy - total_gas < 0) return false;
				gasy += total_gas;
				t_row = d_row;
				t_col = d_col;
			}
		
		
		return true;
	}
	
	static class Node{
		int num;
		int row;
		int col;
		int d_row;
		int d_col;
		int gas;
		public Node(int n, int r, int c, int dr, int dc, int g) {
			num = n;
			row = r;
			col = c;
			d_row = dr;
			d_col = dc;
			gas = g;
		}
	}

}
