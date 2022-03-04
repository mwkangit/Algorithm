package samsung;

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14502 {

	static int N;
	static int M;
	static int graph[][];
	static int answer = 0;
	static boolean visit[][];
	static ArrayList<Pair> list = new ArrayList<>();
	static int zero = 0;
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				int sub = Integer.parseInt(st.nextToken());
				if(sub == 0) {
					zero++;
				} else if(sub == 2) {
					list.add(new Pair(i, j));
				}
				graph[i][j] = sub;
			}
		}
		zero -= 3;
		dfs(0, 0, 0);		
		System.out.print(answer);
		
	}
	
	static void check() {
		visit = new boolean[N][M];
		int result = 0;
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0 ; i < list.size() ; i++) {
			q.add(list.get(i));
			visit[list.get(i).row][list.get(i).col] = true;
			while(!q.isEmpty()) {
				Pair pair = q.poll();
				
				for(int j = 0 ; j < 4 ; j++) {
					int row = pair.row;
					int col = pair.col;
					row += r[j];
					col += c[j];
					if(row < 0 || row >= N || col < 0 || col >= M) continue;
					
					if(!visit[row][col] && graph[row][col] == 0) {
						visit[row][col] = true;
						result++;
						q.add(new Pair(row, col));
					}
				}
			}
		}
		
		answer = Math.max(answer, zero - result);
		
	}
	
	static void dfs(int row, int col, int d) {
		if(d == 3) {
			check();
			return;
		} else {
			for(int i = row ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(graph[i][j] == 0) {
						graph[i][j] = 1;
						dfs(i, j, d + 1);
						graph[i][j] = 0;
					}
				}
			}
		}
	}
	
	static class Pair{
		int row;
		int col;
		public Pair(int r, int c) {
			row = r;
			col = c;
		}
	}

}
