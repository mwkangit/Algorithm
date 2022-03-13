package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16235 {

	static int N;
	static int M;
	static int K;
	static int A[][];
	static int graph[][];
	static LinkedList<Node> alive = new LinkedList<>();
	static int r[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int c[] = {1, 1, 0, -1, -1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new int[N][N];
		
		A = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = 5;
				int sub = Integer.parseInt(st.nextToken());
				A[i][j] = sub;
			}
		}
	
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			alive.add(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		for(int loop = 0 ; loop < K ; loop++) {
//			Collections.sort(alive, new Comparator<Node>() {
//				@Override
//				public int compare(Node n1, Node n2) {
//					return n1.age - n2.age;
//				}
//			});
			Queue<Node> dead = new LinkedList<>();
			Iterator<Node> iter = alive.iterator();
			while(iter.hasNext()) {
				Node node = iter.next();
				int row = node.row;
				int col = node.col;
				int age = node.age;
				
				if(graph[row][col] - age < 0) {
					iter.remove();
					dead.add(new Node(row, col, age));
				} else {
					node.age++;
					graph[row][col] -= age;
				}
			}
			
			while(!dead.isEmpty()) {
				Node node = dead.poll();
				int row = node.row;
				int col = node.col;
				int age = node.age;
				graph[row][col] += age/2;
			}
			
			LinkedList<Node> sub_alive = new LinkedList<>();
			for(Node node : alive) {
				int age = node.age;
				if(age % 5 != 0) continue;
				
				for(int j = 0 ; j < 8 ; j++) {
					int row = node.row + r[j];
					int col = node.col + c[j];
					
					if(row < 0 || row >= N || col < 0 || col >= N) continue;
					
					sub_alive.add(new Node(row, col, 1));
					
				}
			}
			
			alive.addAll(0, sub_alive);
			
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					graph[i][j] += A[i][j];
				}
			}
			
			
		}
		System.out.print(alive.size());

	}
	
	static class Node{
		int row;
		int col;
		int age;
		
		public Node(int r, int c, int a) {
			row = r;
			col = c;
			age = a;
		}
	}

}
