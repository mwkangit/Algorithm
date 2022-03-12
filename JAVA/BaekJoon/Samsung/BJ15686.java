package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15686 {

	static int N;
	static int M;
	static int graph[][];
	static ArrayList<Node> chick_list = new ArrayList<>();
	static ArrayList<Node> home_list = new ArrayList<>();
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static boolean visit[][];
	static int mini = 987654321;
	
	
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
					chick_list.add(new Node(i, j));
					continue;
				} else if(sub == 1) {
					home_list.add(new Node(i, j));
				}
				graph[i][j] = sub;
			}
		}
		
		
		dfs(0 ,0);	
		
		System.out.print(mini);
		
	}
	
	static int bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(row, col));
		visit = new boolean[N][N];
		visit[row][col] = true;
        
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				
				int ro = node.row;
				int co = node.col;
				int d = node.depth;
				
				ro += r[i];
				co += c[i];
				
				if(ro < 0 || ro >= N || co < 0 || co >= N || visit[ro][co]) continue;
				
				visit[ro][co] = true;
				
				if(graph[ro][co] == 2){
					return d+1;
				} else {
					Node sub_node = new Node(ro, co);
					sub_node.depth = d+1;
					q.add(sub_node);
				}
			}
			
			
		}
		
		
		return 0;
	}
	
	static void dfs(int index, int d) {
		if(d == M) {
			int result = 0;
			for(int i = 0 ; i < home_list.size() ; i++) {
				Node node = home_list.get(i);
				result += bfs(node.row, node.col);
			}
			
			mini = Math.min(mini, result);
			
		} else {
			for(int i = index ; i < chick_list.size() ; i++) {
				Node node = chick_list.get(i);
				graph[node.row][node.col] = 2;
				dfs(i + 1, d+1);
				graph[node.row][node.col] = 0;
			}
		}
		
	}
	
	static class Node{
		int row;
		int col;
		int depth = 0;
		
		public Node(int ro, int co){
			row = ro;
			col = co;
		}
	}

}
