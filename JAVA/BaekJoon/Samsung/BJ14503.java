package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14503 {
	
	static int N;
	static int M;
	static int graph[][];
	static boolean visit[][];
	static int answer = 0;
	static int r[] = {-1, 0, 1, 0};
	static int c[] = {0, 1, 0, -1};
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visit = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(row, col, dir);
		
		System.out.print(answer);
	}
	
	static void dfs(int row, int col, int dir) {
		System.out.println(row + " " + col + " " + dir);
		if(!visit[row][col]) {
			answer++;
		}
		visit[row][col] = true;
		int d = dir;
		int count = 0;
		while(true) {
			if(flag) {
				return;
			}
			if(count == 4) break;
			d = d - 1;
			if(d < 0) {
				d = 3;
			}
			int ro = row + r[d];
			int co = col + c[d];
			
			count++;
			
//			if(ro < 0 || ro >= N || co < 0 || co >= M) continue;
			if(graph[ro][co] == 1 || visit[ro][co]) continue;
			
			count = 0;
			dir = d;
			dfs(ro, co, d);
			
		}
		
		d = dir - 2;
		if(d < 0) {
			d += 4;
		}
		
		int ro = row + r[d];
		int co = col + c[d];
		if(graph[ro][co] == 1) {
			flag = true;
		} else {
			dfs(ro, co, dir);
		}
//		System.out.println(row + " " + col + " | " + ro + " " + co + " " + d + " " + dir + " " + flag);
	}

}
