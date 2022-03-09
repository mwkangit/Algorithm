package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15683 {

	static int N;
	static int M;
	static int graph[][];
	static ArrayList<Pair> list = new ArrayList<>();
	static int zero = 0;
	static int mini = 987654321;
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int len;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				int sub = Integer.parseInt(st.nextToken());
				if(sub > 0 && sub < 6) {
					list.add(new Pair(i, j, sub));	
				} else if(sub == 0) {
					zero++;
				}
				graph[i][j] = sub;
			}
		}
		len = list.size();
		
		dfs(0, new boolean[N][M], 0);
		
		System.out.print(mini);
		
	}
	
	static boolean[][] copy(boolean[][]visit){
		boolean sub[][] = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sub[i][j] = visit[i][j];
			}
		}
		return sub;
		
	}
	
	static void dfs(int index, boolean visit[][], int result) {
		if(index == len) {
			mini = Math.min(mini, zero - result);
			
		}else {
			Pair pair = list.get(index);
			int row = pair.row;
			int col = pair.col;
			int num = pair.num;
			for(int i = 0 ; i < 4 ; i++) {
				boolean sub[][] = copy(visit);
				int sub_result = 0;
				
				if(num == 1) {
					sub_result += straight(row, col, i, sub);
					dfs(index+1, sub, result + sub_result);
				}else if(num == 2) {
					if(i >= 2) break;
					sub_result += straight(row, col, i, sub);
					sub_result += straight(row, col, i+2, sub);
					dfs(index+1, sub, result + sub_result);
				}else if(num == 3) {
					sub_result += straight(row, col, i, sub);
					if(i == 3) {
						sub_result += straight(row, col, 0, sub);
					}else {
						sub_result += straight(row, col, i+1, sub);
					}
					dfs(index+1, sub, result + sub_result);
				}else if(num == 4) {
					int sub_num[] = new int[3];
					for(int j = 1 ; j < 4 ; j++) {
						if(i + j > 3) {
							sub_num[j-1] = i+j-4;
						} else {
							sub_num[j-1] = i+j;
						}
					}
					sub_result += straight(row, col, sub_num[0], sub);
					sub_result += straight(row, col, sub_num[1], sub);
					sub_result += straight(row, col, sub_num[2], sub);
					dfs(index + 1, sub, result + sub_result);
				}else if(num == 5) {
					if(i >= 1) break;
					sub_result += straight(row, col, 0, sub);
					sub_result += straight(row, col, 1, sub);
					sub_result += straight(row, col, 2, sub);
					sub_result += straight(row, col, 3, sub);
					dfs(index+1, sub, result + sub_result);
				}
				
				
				
			}
		}
		
	}
	
	static int straight(int row, int col, int i, boolean sub[][]) {
		int result = 0;
		while(true) {
			row += r[i];
			col += c[i];
			if(row < 0 || row >= N || col < 0 || col >= M) break;
			
			if(graph[row][col] == 0 && !sub[row][col]) {
				sub[row][col] = true;
				result++;
			}else if(graph[row][col] == 6) {
				break;
			}
			
		}
		return result;
	}
	
	static class Pair{
		int row;
		int col;
		int num;
		
		public Pair(int ro, int co, int n) {
			row = ro;
			col = co;
			num = n;
		}
	}

}
