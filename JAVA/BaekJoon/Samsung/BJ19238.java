package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ19238 {

	static int N, M, NRG;
	static int graph[][];
	static Node taxi;
	static HashMap<Integer, Node> map = new HashMap<>();
	static PriorityQueue<Node> list;
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		NRG = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int ro = Integer.parseInt(st.nextToken()) - 1;
		int co = Integer.parseInt(st.nextToken()) - 1;
		graph[ro][co] = 2;
		taxi = new Node(ro, co, NRG);
		
		int index = 3;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ro1 = Integer.parseInt(st.nextToken()) - 1;
			int co1 = Integer.parseInt(st.nextToken()) - 1;
			int ro2 = Integer.parseInt(st.nextToken()) - 1;
			int co2 = Integer.parseInt(st.nextToken()) - 1;
			graph[ro1][co1] = index;
			map.put(index, new Node(ro2, co2, 0));
			index++;
		}
		
		boolean flag = true;
		int count = 0;
		while(true) {
			flag = bfs();
			count++;
			if(flag == false) break;
			if(count == M) break;
		}
		
		if(flag) {
			System.out.print(taxi.gas);
		} else {
			System.out.print(-1);
		}
		
		
	}
	
	static boolean bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(taxi.row, taxi.col, 0));
		boolean visit[][] = new boolean[N][N];
		visit[taxi.row][taxi.col] = true;
		
		list = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.gas > n2.gas) {
					return 1;
				} else if(n1.gas == n2.gas) {
					if(n1.row > n2.row) {
						return 1;
					} else if(n1.row == n2.row){
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
		
//		int limit = Integer.MAX_VALUE;
		
		if(graph[taxi.row][taxi.col] < 3) {
		
			while(!q.isEmpty()) {
				Node node = q.poll();
		
				for(int i = 0 ; i < 4; i++) {
					int row = node.row + r[i];
					int col = node.col + c[i];
					
					if(row < 0 || row >= N || col < 0 || col >= N || graph[row][col] == 1 || visit[row][col]) continue;
					visit[row][col] =true;
					
					if(graph[row][col] == 0) {
						q.add(new Node(row, col, node.gas + 1));
					}
					
					if(graph[row][col] > 2) {
						list.add(new Node(row, col, node.gas+1));
//						limit = node.gas;
					}
					
					
				}
			}
		} else {
			list.add(new Node(taxi.row, taxi.col, 0));
		}
		
		boolean flag = true;
		
		
		if(list.size() == 0) {
			return false;
		}
		Node nod = list.peek();
		
		if(taxi.gas < nod.gas) {
			return false;
		} else {
			taxi.row = nod.row;
			taxi.col = nod.col;
			taxi.gas -= nod.gas;
			flag = finish(map.get(graph[nod.row][nod.col]));
			graph[nod.row][nod.col] = 0;
		}
		
		if(flag) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean finish(Node no) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(taxi.row, taxi.col, 0));
		boolean[][] visit = new boolean[N][N];
		visit[taxi.row][taxi.col] = true;
		
		int total_gas = 0;
		boolean flag = false;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int row = node.row + r[i];
				int col = node.col + c[i];
				
				if(row < 0 || row >= N || col < 0 || col >= N || graph[row][col] == 1 || visit[row][col]) continue;
				visit[row][col] =true;
				if(row == no.row && col == no.col) {
					total_gas = node.gas + 1;
					flag = true;
					break;
				}
				q.add(new Node(row, col, node.gas + 1));
				
				
				
			}
			if(flag)break;
		}
		if(!flag)return false;
		if(taxi.gas < total_gas){
			return false;
		} else {
			taxi.gas += total_gas;
			taxi.row = no.row;
			taxi.col = no.col;
		}
		
		
		return true;
	}
	
	static class Node{
		int row;
		int col;
		int gas;
		public Node(int r, int c, int g) {
			row = r;
			col = c;
			gas = g;
		}
	}

}
