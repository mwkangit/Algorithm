package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ16236 {

	static int N;
	static int graph[][];
	static Shark shark;
	static PriorityQueue<Fish> pq;
	static boolean visit[][];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				int sub = Integer.parseInt(st.nextToken());
				if(sub == 9) {
					shark = new Shark(2, 0, i, j);
					continue;
				}
				graph[i][j] = sub;
			}
		}
		
		int answer = 0;
		
		while(true) {
			bfs();
			if(pq.isEmpty()) break;
			Fish fish = pq.poll();
			graph[fish.row][fish.col] = 0;
			shark.ate++;
			if(shark.size == shark.ate) {
				shark.size++;
				shark.ate = 0;
			}
			
			shark.row = fish.row;
			shark.col = fish.col;
			answer += fish.dist;
			
		}
		
		
		System.out.print(answer);
		
		
		
	}
	
	static void bfs() {
		pq = new PriorityQueue<>(new Comparator<Fish>() {
			@Override
			public int compare(Fish f1, Fish f2) {
				if(f1.row > f2.row) {
					return 1;
				} else if (f1.row == f2.row) {
					return f1.col - f2.col;
				} else {
					return -1;
				}
			}

		});
		
		Queue<Node> q = new LinkedList<>();
		visit = new boolean[N][N];
		
		q.add(new Node(shark.row, shark.col, 0));
		visit[shark.row][shark.col] = true;
		int max_dist = -1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int row = node.row + r[i];
				int col = node.col + c[i];
				int dist = node.dist;
				
				if(max_dist == dist) return;
				
				if(row < 0 || row >= N || col < 0 || col >= N || visit[row][col] || graph[row][col] > shark.size) continue;
				visit[row][col] = true;
				
				if(graph[row][col] == shark.size || graph[row][col] == 0) {
					q.add(new Node(row, col, dist+1));
				}else {
					pq.add(new Fish(row, col, dist+1));
					max_dist=dist+1;
				}
				
			}
			
			
		}
		
		
		
	}
	
	static class Node{
		int row;
		int col;
		int dist;
		
		public Node(int ro, int co, int d) {
			row = ro;
			col = co;
			dist = d;
		}
	}
	
	static class Fish{
		int row;
		int col;
		int dist;
		
		public Fish(int ro, int co, int d) {
			row = ro;
			col = co;
			dist = d;
		}
	}
	
	static class Shark{
		int size;
		int ate;
		int row;
		int col;
		
		public Shark(int s, int a, int ro, int co) {
			size = s;
			ate = a;
			row = ro;
			col = co;
		}
	}

}
