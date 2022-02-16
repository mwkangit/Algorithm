package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1520 {

	static int answer = 0;
	static int M;
	static int N;
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int graph[][];
	static int dp[][];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String in1[] = br.readLine().split(" ");
		int m = Integer.parseInt(in1[0]);
		int n = Integer.parseInt(in1[1]);
		M=m;
		N=n;
		graph = new int[M][N];
		dp = new int[M][N];
		
		for(int i = 0 ; i < M ; i++) {
			String sub[] = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(sub[j]);
				dp[i][j] = -1;
			}
		}
		
		answer = dfs(0, 0);		
		System.out.print(answer);
		
		
	}
	
	static public int dfs(int row, int col) {
		if(row == M-1 && col == N-1) {
			return 1;
		} else {
			dp[row][col] = 0;
			for(int i = 0 ; i < 4 ; i++) {
				int y = row + r[i];
				int x = col + c[i];
				
				if(y < 0 || y >= M || x < 0 || x >= N) continue;
				
				if(graph[row][col] > graph[y][x]) {
					if(dp[y][x] != -1) {
						dp[row][col] += dp[y][x];
						continue;
					}
					dp[row][col] += dfs(y,x);
				}
			}
			
		}
		return dp[row][col];
	}

}
