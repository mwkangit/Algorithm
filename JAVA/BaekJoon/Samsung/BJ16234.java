package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ16234 {

	static int N;
	static int L;
	static int R;
	static int graph[][];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		
		int index = 0;
		int answer = 0;
		while(true) {
			
		
		
			int sub_g[][] = new int[N][N];
			boolean visit[][] = new boolean[N][N];
			HashMap<Integer, Integer> map = new HashMap<>();
			HashMap<Integer, Integer> count = new HashMap<>();
			index = 1;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					for(int k = 0 ; k < 4 ; k++) {
						int row = i + r[k];
						int col = j +c[k];
						
						if(row < 0 || row >= N || col < 0 || col >= N || visit[row][col]) continue;
						
						int comp = Math.abs(graph[i][j] - graph[row][col]);
						if(comp >= L && comp <= R) {
							sub_g[i][j] = index;
							bfs(i, j, index++, sub_g, visit, map, count);
						}
						
					}
				}
			}
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map.containsKey(sub_g[i][j])){
						graph[i][j] = map.get(sub_g[i][j]) / count.get(sub_g[i][j]);
					}
				}
			}
			
			if(index == 1) {
				break;
			}
			answer++;
		}
		
		
		System.out.print(answer);
		
	}
	
	static void bfs(int row, int col, int index, int[][] sub_g, boolean[][] visit, HashMap<Integer, Integer> map, HashMap<Integer, Integer> count) {
		
		Queue<Node> q = new LinkedList<>();
		int counter = 0;
		q.add(new Node(row, col));
		visit[row][col] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			counter++;
			map.put(index, map.getOrDefault(index, 0) + graph[node.row][node.col]);
			
			for(int i = 0 ; i < 4 ; i++) {
				int ro = node.row;
				int co = node.col;
				
				ro += r[i];
				co += c[i];
				
				if(ro < 0 || ro >= N || co < 0 || co >= N || visit[ro][co]) continue;
				
				int comp = Math.abs(graph[node.row][node.col] - graph[ro][co]);
				
				if(comp >= L && comp <= R) {
					visit[ro][co] = true;
					sub_g[ro][co] = index;
					q.add(new Node(ro, co));
				}
				
				
			}
			
			
		}
		count.put(index, counter);
		
	}
	
	static class Node{
		int row;
		int col;
		
		public Node(int ro, int co) {
			row = ro;
			col = co;
		}
	}

}
