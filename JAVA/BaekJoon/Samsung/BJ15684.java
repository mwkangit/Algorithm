package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15684 {

	static int N;
	static int M;
	static int H;
	static int graph[][];
	static boolean visit[][];
	static int mini = 4;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new int[H+2][N+2];
		visit = new boolean[H+2][N+2];
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			graph[first][second] = 1;
			graph[first][second+1] = 2;
//			graph[first][second+2] = -1;
			if(graph[first][second-1] == 0) graph[first][second-1] -= 1;
			else graph[first][second-1] += 3;
//			graph[first][second-1] = -1;
		}
		
//		for(int i = 0 ; i < H ; i++) {
//			for(int j = 0 ; j < N ; j++) {
//				System.out.print(graph[i][j]);
//			}
//			System.out.println();
//		}
		
//		for(int i = 1 ; i <= N ; i++) {
//			System.out.print(test(i));
//		}
		
		dfs(1,1,0);
		
		if(mini > 3) {
			System.out.print(-1);
		} else {
			System.out.print(mini);
		}
		
		
	}
	
	static void dfs(int row, int col, int d) {
		if(graph[2][1] == 1 && graph[2][2] == 8 ) {
//			for(int i = 0 ; i < H ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					System.out.print(graph[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		if(d <= 3) {
			boolean flag = true;
			for(int i = 1 ; i <= N ; i++) {
				if(!test(i)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				mini = Math.min(mini, d);
//				System.out.println(mini);
			}
			
		}else {
			return;
		}
		
		for(int j = col ; j < N ; j++) {
			if(!visit[row][j] && graph[row][j] == 0) {
				visit[row][j] = true;
				graph[row][j] += 1;
				graph[row][j+1] += 5;
				if(graph[row][j-1] == 0) graph[row][j-1] -= 1;
				else graph[row][j-1] += 3;
				
//					graph[i][j+2] -= 1;
				dfs(row, j, d + 1);
				visit[row][j] = false;
				graph[row][j] -= 1;
				graph[row][j+1] -= 5;
				if(graph[row][j-1] == -1) graph[row][j-1] += 1;
				else graph[row][j-1] -= 3;
				
//					graph[i][j+2] += 1;
			}
		}
		
		
		for(int i = row + 1 ; i <= H ; i++) {
			for(int j = 1 ; j < N ; j++) {
				if(!visit[i][j] && graph[i][j] == 0) {
					visit[i][j] = true;
					graph[i][j] += 1;
					graph[i][j+1] += 5;
					if(graph[i][j-1] == 0) graph[i][j-1] -= 1;
					else graph[i][j-1] += 3;
					
//					graph[i][j+2] -= 1;
					dfs(i, j, d + 1);
					visit[i][j] = false;
					graph[i][j] -= 1;
					graph[i][j+1] -= 5;
					if(graph[i][j-1] == -1) graph[i][j-1] += 1;
					else graph[i][j-1] -= 3;
					
//					graph[i][j+2] += 1;
				}
			}
		}
		return;
	
	}
	
	static boolean test(int col) {
		int cur_row = 1;
		int cur_col = col;
		
		while(cur_row <= H) {
			if(graph[cur_row][cur_col] == 1) {
				cur_row += 1;
				cur_col = cur_col + 1;
			} else if(graph[cur_row][cur_col] >= 2) {
				cur_row += 1;
				cur_col = cur_col - 1;
			} else {
				cur_row += 1;
			}
		}
//		System.out.print(cur_col);
		
		if(cur_col == col) {
			return true;
		} else {
			return false;
		}
	}

}
