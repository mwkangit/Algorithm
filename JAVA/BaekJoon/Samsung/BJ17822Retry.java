package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17822Retry {

	static int N, M, T;
	static int graph[][];
	static Turn com[];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		graph = new int[N+1][M];
		com = new Turn[T];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			com[i] = new Turn(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0 ; i < T ; i++) {
			rotate(com[i]);
		}
		
		int answer = counter();
		
		System.out.print(answer);
		
		
	}
	
	static int counter() {
		int result = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				result += graph[i][j];
			}
		}
		return result;
	}
	
	static void copy(int[][] copy) {
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				copy[i][j] = graph[i][j];
			}
		}
	}
	
	static void copy_graph(int copy[][]) {
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = copy[i][j];
			}
		}
	}
	
	static void check() {
		int copy[][] = new int[N+1][M];
		copy(copy);
		boolean[][] visit = new boolean[N+1][M];
		boolean flag = true;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(visit[i][j] || graph[i][j] == 0) continue;
				Queue<Node> q = new LinkedList<>();
				q.add(new Node(i, j, graph[i][j]));
				visit[i][j] = true;
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					
					for(int k = 0 ; k < 4 ; k++) {
						int row = node.row + r[k];
						int col = node.col + c[k];
						if(row < 1 || row > N)continue;
						if(col < 0) {
							col = M - 1;
						} else if(col >= M) {
							col = 0;
						}
						if(visit[row][col]) continue;
						
						if(node.val == graph[row][col]) {
							copy[node.row][node.col] = 0;
							copy[row][col] = 0;
							q.add(new Node(row, col, graph[row][col]));
							flag = false;
							visit[row][col] = true;
						}
						
					}
				}
			}
		}
		if(flag) {
			double avg = 0;
			int count = 0;
			for(int i = 1 ; i <=N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					avg += copy[i][j];
					if(copy[i][j] != 0) count++;
				}
			}
			avg /= (double)count;
			
			for(int i = 1 ; i <=N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(copy[i][j] != 0) {
						if((double)copy[i][j] > avg) {
							copy[i][j]--;
						} else if((double)copy[i][j] < avg) {
							copy[i][j]++;
						}
					}
				}
			}
			
		}
		
		copy_graph(copy);
		
		
				
	}
	
	static void rotate(Turn turn) {
		int x = turn.x;
		int d = turn.d;
		int k = turn.k;
		int temp = x;
		
		while(x <= N) {
			if(d == 0) {
				for(int i = 0 ; i < k ; i++) {
					int sub = graph[x][M-1];
					for(int j = M - 1 ; j > 0 ; j--) {
						graph[x][j] = graph[x][j-1];
					}
					graph[x][0] = sub;
				}
			} else {
				for(int i = 0 ; i < k ; i++) {
					int sub = graph[x][0];
					for(int j = 0 ; j < M - 1 ; j++) {
						graph[x][j] = graph[x][j+1];
					}
					graph[x][M - 1] = sub;
				}
			}
			
			
			x += temp;
		}
		
		check();
	}
	
	static class Node{
		int row;
		int col;
		int val;
		public Node(int r, int c, int v) {
			row = r;
			col = c;
			val = v;
		}
	}
	
	static class Turn{
		int x;
		int d;
		int k;
		
		public Turn(int a, int b, int c) {
			x = a;
			d = b;
			k = c;
		}
	}

}
