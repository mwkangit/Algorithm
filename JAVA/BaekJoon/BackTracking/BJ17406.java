package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BJ17406 {

	static int N, M;
	static int K;
	static int graph[][];
	static int func[][];
	static boolean visit[];
	static int answer = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		K = ps(st.nextToken());
		graph = new int[N+1][M+1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ; j++) {
				graph[i][j] = ps(st.nextToken());
			}
		}
		func = new int[K][3];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			func[i][0] = ps(st.nextToken());
			func[i][1] = ps(st.nextToken());
			func[i][2] = ps(st.nextToken());
		}
		visit = new boolean[K];
		
		dfs(0);
		
		System.out.print(answer);
	}
	static void dfs(int count) {
		if(count == K) {
			calc();
		}else {
			for(int i = 0 ; i < K ; i++) {
				if(!visit[i]) {
					visit[i] = true;
					move(i, true);
					dfs(count+1);
					move(i, false);
					visit[i] = false;
				}
			}
		}
	}
	static void calc() {
		
		for(int i = 1 ; i <= N ; i++) {
			int sum = 0;
			for(int j = 1 ; j <= M ; j++) {
				sum += graph[i][j];
			}
			answer = Math.min(answer, sum);
		}
	}
	
	static void move(int num, boolean flag) {
		int r = func[num][0];
		int c = func[num][1];
		int s = func[num][2];
		int startRow = r - s;
		int startCol = c - s;
		int endRow = r + s;
		int endCol = c + s;
	
		while(true) {
			if(flag) {
				clock(startRow, startCol, endRow, endCol);
			}else {
				declock(startRow, startCol, endRow, endCol);
			}
			startRow++;
			startCol++;
			endRow--;
			endCol--;
			if(startRow == endRow && startCol == endCol)break;
		}

	}
	static void declock(int startRow, int startCol, int endRow, int endCol) {
		int subNum = graph[startRow][startCol];
		
		for(int i = startCol ; i < endCol ; i++) {
			graph[startRow][i] = graph[startRow][i+1];
		}
		
		for(int i = startRow ; i < endRow ; i++) {
			graph[i][endCol] = graph[i+1][endCol];
		}
		
		for(int i = endCol ; i > startCol ; i--) {
			graph[endRow][i] = graph[endRow][i-1];
		}
		
		for(int i = endRow ; i > startRow ; i--) {
			graph[i][startCol] = graph[i-1][startCol];
		}
		
		graph[startRow+1][startCol] = subNum;
	}
	static void clock(int startRow, int startCol, int endRow, int endCol) {

		int subNum = graph[startRow][startCol];
		
		for(int i = startRow ; i < endRow ; i++) {
			graph[i][startCol] = graph[i+1][startCol];
		}
		
		for(int i = startCol ; i < endCol ; i++) {
			graph[endRow][i] = graph[endRow][i+1];
		}
		
		for(int i = endRow ; i > startRow ; i--) {
			graph[i][endCol] = graph[i-1][endCol];
		}
		
		for(int i = endCol ; i > startCol ; i--) {
			graph[startRow][i] = graph[startRow][i-1];
		}

		graph[startRow][startCol+1] = subNum;
	}
	
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
