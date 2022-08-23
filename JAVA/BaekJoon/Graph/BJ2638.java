package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2638 {

	static int N, M;
	static int graph[][];
	static int count = 0;
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		graph = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				int num = ps(st.nextToken());
				if(num == 0) {
					graph[i][j] = 2;
				}else {
					graph[i][j] = num;
				}
				
				if(num == 1) {
					count++;
				}
			}
		}
		int answer= 0;
		while(count > 0) {
			answer++;
			turn0();
			addDelete();
		}
		System.out.print(answer);
		
	}
	static void addDelete() {
		ArrayList<Node> list= new ArrayList<>();
		for(int i = 1 ; i < N-1 ; i++) {
			for(int j = 1; j < M-1 ; j++) {
				if(graph[i][j] == 1) {
					int limit = 0;
					for(int k = 0 ; k < 4 ; k++) {
						int ro = i + r[k];
						int co = j + c[k];
						if(graph[ro][co] == 0)limit++;
						if(limit > 1) {
							list.add(new Node(i, j));
							break;
						}
					}
				}
			}
		}
		for(int i = 0 ; i < list.size() ; i++) {
			graph[list.get(i).row][list.get(i).col] = 0;
			count--;
		}
	}
	static void turn0() {
		bfs2(0, 0);
	}
	static void bfs2(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(row, col));
		boolean visit[][] = new boolean[N][M];
		visit[row][col] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int ro = node.row + r[i];
				int co = node.col + c[i];
				
				if(ro < 0 || ro >= N || co < 0 || co >= M || visit[ro][co] || graph[ro][co] == 1)continue;

				visit[ro][co] = true;
				graph[ro][co] = 0;
				q.add(new Node(ro, co));
				
			}
		}
	}
	static class Node{
		int row, col;
		public Node(int r, int c) {
			row = r;
			col = c;
		}
	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
