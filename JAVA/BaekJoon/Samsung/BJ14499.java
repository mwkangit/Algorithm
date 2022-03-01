package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14499 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node node = new Node(0,0,0,0,0,0);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int graph[][] = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int command[] = new int[K];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < K ; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < K ; i++) {
			int y = 0;
			int x = 0;
			switch(command[i]) {
				case 1: y = row;
						x = col+1;
						break;
				case 2: y = row;
						x = col-1;
						break;
				case 3: y = row-1;
						x = col;
						break;
				case 4: y = row+1;
						x = col;
						break;
			}
			if(y < 0 || y >= N || x < 0 || x >= M) continue;
			
			switch(command[i]) {
				case 1: east(node);
						break;
				case 2: west(node);
						break;
				case 3: north(node);
						break;
				case 4: south(node);
						break;
			}
			
			if(graph[y][x] != 0) {
				node.bottom = graph[y][x];
				graph[y][x] = 0;
			} else {
				graph[y][x] = node.bottom;
			}
			
			row = y;
			col = x;
			sb.append(node.top + "\n");
			
		}
		
		System.out.print(sb.toString());
		
		
		
		
	}
	
	static void south(Node node) {
		int sub = node.bottom;
		node.bottom = node.down;
		node.down = node.top;
		node.top = node.up;
		node.up = sub;
	}
	
	static void north(Node node) {
		int sub = node.bottom;
		node.bottom = node.up;
		node.up = node.top;
		node.top = node.down;
		node.down = sub;
	}
	
	static void west(Node node) {
		int sub = node.bottom;
		node.bottom = node.left;
		node.left = node.top;
		node.top = node.right;
		node.right = sub;
	}

	static void east(Node node) {
		int sub = node.bottom;
		node.bottom = node.right;
		node.right = node.top;
		node.top = node.left;
		node.left = sub;
	}
	
	static class Node{
		int bottom;
		int down;
		int up;
		int left;
		int right;
		int top;
		
		public Node(int b, int d, int u, int l, int r, int t) {
			bottom = b;
			down = d;
			up = u;
			left = l;
			right = r;
			top = t;
		}
		
	}

}
