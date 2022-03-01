package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14500 {

	static int graph[][];
	static boolean visit[][];
	static int maxi = 0;
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		N = n;
		M = m;
		
		graph = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, graph[i][j]);
				visit[i][j] = false;
			}
		}
		
		int result;
		for(int i = 0 ; i < N - 1 ; i++) {
			
			for(int j = 0 ; j < M - 2 ; j++) {
				result = 0;
				result += graph[i][j] + graph[i][j+1] + graph[i][j+2] + graph[i+1][j+1];
				maxi = Math.max(maxi, result);
			}
		}
		
		for(int i = 0 ; i < M - 1 ; i++) {
			
			for(int j = 0 ; j < N - 2 ; j++) {
				result = 0;
				result += graph[j][i] + graph[j+1][i] + graph[j+2][i] + graph[j+1][i+1];
				maxi = Math.max(maxi, result);
			}
		}

		for(int i = N - 1 ; i >= 1 ; i--) {
			
			for(int j = 0; j < M - 2 ; j++) {
				result = 0;
				result += graph[i][j] + graph[i][j+1] + graph[i][j+2] + graph[i-1][j+1];
				maxi = Math.max(maxi, result);
			}
		}
		
		for(int i = M - 1 ; i >= 1 ; i--) {
			
			for(int j = 0 ; j < N - 2 ; j++) {
				result = 0;
				result += graph[j][i] + graph[j+1][i] + graph[j+2][i] + graph[j+1][i-1];
				maxi = Math.max(maxi, result);
			}
		}
		
		
		System.out.print(maxi);
		
		
	}
	
	static void dfs(int row, int col, int d, int result) {
		if(d == 4) {
			maxi = Math.max(maxi, result);
		}else {
			for(int i = 0 ; i < 4 ; i++) {
				int y = row + r[i];
				int x = col + c[i];
				
				if(y < 0 || y >= N || x < 0 || x >= M ) continue;
				
				if(!visit[y][x]) {
					visit[y][x] = true;
					dfs(y, x, d+1, result + graph[y][x]);
					visit[y][x] = false;
				}
				
			}
		}
		
	}

}
