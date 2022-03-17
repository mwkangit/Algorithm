package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17144 {

	static int graph[][];
	static int R;
	static int C;
	static int T;
	static ArrayList<Node> airC = new ArrayList<>();
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				int sub = Integer.parseInt(st.nextToken());
				if(sub == -1) {
					airC.add(new Node(i, j));
				}
				graph[i][j] = sub;
			}
		}
		
		for(int i = 0 ; i < T ; i++) {
			int sub_graph[][] = new int[R][C];
			sub_graph[airC.get(0).row][airC.get(0).col] = -1;
			sub_graph[airC.get(1).row][airC.get(1).col] = -1;
			
			for(int j = 0 ; j < R ; j++) {
				for(int k = 0 ; k < C ; k++) {
					if(graph[j][k] > 0) {
						spread(j, k, sub_graph);
					}
				}
			}
			graph = sub_graph;
			forward();
			
			backward();			
			
		}	
		
		int answer = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				answer += graph[i][j];
			}
		}
		System.out.print(answer+2);
	}
	
	static void forward() {
		int row = airC.get(0).row-1;
		int col = airC.get(0).col;
		graph[row][col] = -1;
		while(row >= 0) {
			graph[row+1][col] = graph[row][col];
			row--;
		}
		row++;
		col++;
		while(col < C) {
			graph[row][col-1] = graph[row][col];
			col++;
		}
		col--;
		row++;
		while(row <= airC.get(0).row) {
			graph[row-1][col] = graph[row][col];
			row++;
		}
		row--;
		col--;
		while(col > 0) {
			graph[row][col+1] = graph[row][col];
			col--;
		}
		graph[row][col+1] = 0;
	}
	
	static void backward() {
		int row = airC.get(1).row+1;
		int col = airC.get(1).col;
		graph[row][col] = -1;
		while(row < R) {
			graph[row-1][col] = graph[row][col];
			row++;
		}
		row--;
		col++;
		while(col < C) {
			graph[row][col-1] = graph[row][col];
			col++;
		}
		col--;
		row--;
		while(row >= airC.get(1).row) {
			graph[row+1][col] = graph[row][col];
			row--;
		}
		row++;
		col--;
		while(col > 0) {
			graph[row][col+1] = graph[row][col];
			col--;
		}
		graph[row][col+1] = 0;
	}
	
	static void spread(int ro, int co, int [][] sub_graph) {
		
		int count = 0;
		int div = graph[ro][co] / 5;
		for(int i = 0 ; i < 4 ; i++) {
			int row = ro + r[i];
			int col = co + c[i];
			
			if(row < 0 || row >= R || col < 0 || col >= C || graph[row][col] == -1)continue;
			
			count++;
			sub_graph[row][col] += div;
		}
		
		sub_graph[ro][co] += graph[ro][co] - (div * count);
		
		
	}
	
	
	
	static class Node{
		int row;
		int col;
		
		public Node(int r, int c) {
			row = r;
			col = c;
		}
	}

}
