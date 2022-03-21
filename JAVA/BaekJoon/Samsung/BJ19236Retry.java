package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ19236Retry {
	
	static int r[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int c[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int maxi = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int graph[][] = new int[4][4];
		Node[] fish = new Node[17];
		
		for(int i = 0 ; i < 4 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 4 ; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				fish[num] = new Node(num, i, j, dir, 1);
				graph[i][j] = num;
			}
		}
		
		
		
		int s_row = 0;
		int s_col = 0;
		fish[graph[0][0]].alive = 0;
		maxi = graph[0][0];
		int s_dir = fish[graph[0][0]].dir;
		graph[0][0] = 17;
		
		dfs(s_row, s_col, s_dir, fish, graph, maxi);
		
		System.out.print(maxi);
	}
	
	static void copyFish(Node n1[], Node n2[]) {
		for(int i = 1 ; i < 17 ; i++) {
			n2[i] = new Node(n1[i].num, n1[i].row, n1[i].col, n1[i].dir, n1[i].alive);
		}
	}
	
	static void copyGraph(int[][] graph1, int[][] graph2) {
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				graph2[i][j] = graph1[i][j];
			}
		}
	}
	
	static void dfs(int s_row, int s_col, int s_dir, Node fish[], int[][] graph, int result) {
		int fs_row = s_row;
		int fs_col = s_col;
		int fs_dir = s_dir;
		maxi = Math.max(maxi, result);
		
		
		Node coFish[] = new Node[17];
		copyFish(fish, coFish);
		int coGraph[][] = new int[4][4];
		copyGraph(graph, coGraph);
		
		
		for(int i = 1 ; i < 17 ; i++) {
			Node node = fish[i];
			if(node.alive == 0) continue;
			
			int dir = node.dir - 1;
			for(int j = 0 ; j < 8 ;j++) {
				dir = (dir + 1) % 8;
				int row = node.row + r[dir];
				int col = node.col + c[dir];
				
				if(row < 0 || row >= 4 || col < 0 || col >= 4 || graph[row][col] == 17) continue;
				node.dir = dir;
				if(graph[row][col] == 0) {
					graph[node.row][node.col] = 0;
					graph[row][col] = node.num;
					
					node.row = row;
					node.col = col;
					break;
				} else if(graph[row][col] > 0 && graph[row][col] < 17) {
					int number = graph[row][col];
					Node sub_node = fish[number];
					
					graph[node.row][node.col] = number;
					sub_node.row = node.row;
					sub_node.col = node.col;
					
					graph[row][col] = node.num;
					node.row = row;
					node.col = col;
					break;
				}
			}
		}
		
		int shark_row = fs_row;
		int shark_col = fs_col;
		int shark_dir = fs_dir;
		while(shark_row + r[shark_dir] >= 0 && shark_row + r[shark_dir] < 4 && shark_col + c[shark_dir] >= 0 && shark_col + c[shark_dir] < 4) {
			shark_row += r[shark_dir];
			shark_col += c[shark_dir];
			if(graph[shark_row][shark_col] > 0 && graph[shark_row][shark_col] < 17) {
				int number = graph[shark_row][shark_col];
				fish[number].alive = 0;
				graph[fs_row][fs_col] = 0;
				graph[shark_row][shark_col] = 17;
				dfs(shark_row, shark_col, fish[number].dir, fish, graph, result + fish[number].num);
				fish[number].alive = 1;
				graph[fs_row][fs_col] = 17;
				graph[shark_row][shark_col] = fish[number].num;
			}	
		}
		copyFish(coFish, fish);
		copyGraph(coGraph, graph);
		
		
		
	}
	
	static class Node{
		int num;
		int row;
		int col;
		int dir;
		int alive;
		public Node(int n, int r, int c, int d, int a) {
			num = n;
			row = r;
			col = c;
			dir = d;
			alive = a;
		}
	}

}