package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14890 {

	static int N;
	static int L;
	static int graph[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		N = n;
		L = l;
		
		graph = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		int answer = 0;
		for(int i = 0 ; i < N ; i++) {
			if(checkRow(i)) {
				answer++;
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(checkCol(i)) {
				answer++;
			}
			
		}
		
		System.out.print(answer);
		
	}
	
	static boolean checkRow(int row) {
		
		
		int count = 1;
		int cur = graph[row][0];
		for(int i = 1 ; i < N ; i++) {
			if(graph[row][i] == cur) {
				count++;
			} else if(graph[row][i] == cur + 1) {
				if(count < L) {
					return false;
				} else {
					cur = graph[row][i];
					count = 1;
				}
				
			} else if(graph[row][i] > cur + 1) {
				return false;
			} else if(graph[row][i] == cur - 1) {
				cur = graph[row][i];
				int j = 1;
				for( ; j < L ;j++) {
					if(i+j >= N) return false;
					if(graph[row][i+j] != cur) {
						return false;
					}
				}
				i += j - 1;
				count = 0;
				
			} else if(graph[row][i] < cur - 1) {
				return false;
			}
			
		}
		
		return true;
	}
	
static boolean checkCol(int col) {
		
		
		int count = 1;
		int cur = graph[0][col];
		for(int i = 1 ; i < N ; i++) {
			if(graph[i][col] == cur) {
				count++;
			} else if(graph[i][col] == cur + 1) {
				if(count < L) {
					return false;
				} else {
					cur = graph[i][col];
					count = 1;
				}
				
			} else if(graph[i][col] > cur + 1) {
				return false;
			} else if(graph[i][col] == cur - 1) {
				cur = graph[i][col];
				int j = 1;
				for( ; j < L ;j++) {
					if(i+j >= N)return false;
					if(graph[i+j][col] != cur) {
						return false;
					}
				}
				i += j - 1;
				count = 0;
				
			} else if(graph[i][col] < cur - 1) {
				return false;
			}
			
		}
		
		return true;
	}

}
