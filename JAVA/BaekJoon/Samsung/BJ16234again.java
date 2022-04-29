package samsung;

import java.util.*;
import java.io.*;

public class BJ16234again {
	
	static int N, L, R;
	static int graph[][];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parse(st.nextToken());
		L = parse(st.nextToken());
		R = parse(st.nextToken());
		graph = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = parse(st.nextToken());
			}
		}
		int answer = 0;
		
		while(true) {
			
			boolean visit[][] = new boolean[N][N];
			HashMap<Integer, Integer> sum = new HashMap<>();
			HashMap<Integer, Integer> count = new HashMap<>();
			int subg[][] = new int[N][N];
			int index = 1;
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visit[i][j]) {
						bfs(i, j, visit, sum, count, subg, index);
						index++;
					}
					
				}
			}
			if(index-1 == N*N) {
				break;
			}
			
			for(int i = 1 ; i < index ; i++) {
				sum.put(i, sum.get(i)/count.get(i));
			}
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					graph[i][j] = sum.get(subg[i][j]);
				}
			}
			
			
			
			answer++;
			
		}
		System.out.print(answer);
		
		
	}
	
	static void bfs(int row, int col, boolean[][] visit, HashMap<Integer, Integer> sum, HashMap<Integer, Integer> count, int[][] subg, int index) {
		Queue<Node> q = new LinkedList<>();
		visit[row][col] = true;
		sum.put(index, graph[row][col]);
		count.put(index, 1);
		q.add(new Node(row, col));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			subg[node.row][node.col] = index;
			
			for(int i = 0 ; i < 4 ; i++) {
				int ro = node.row + r[i];
				int co = node.col + c[i];
				
				if(ro < 0 || ro >= N || co <0 || co >= N || visit[ro][co])continue;
				
				if(Math.abs(graph[node.row][node.col] - graph[ro][co]) < L || Math.abs(graph[node.row][node.col] - graph[ro][co]) > R)continue;
				
				visit[ro][co] = true;
				
				sum.put(index, sum.get(index) + graph[ro][co]);
				count.put(index, count.get(index) + 1);
				
				
				
				q.add(new Node(ro,co));
				
				
			}
			
		}
	}
	
	static class Node{
		int row,col;
		
		public Node(int r, int c) {
			row = r;
			col = c;
		}
	}
	
	static int parse(String str) {
		return Integer.parseInt(str);
	}

}
