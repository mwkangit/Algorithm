package BackTracking;

import java.util.*;
import java.io.*;

public class BJ1987  {

	static HashSet<Character> set = new HashSet<>();
	static char graph[][];
	static int answer = 0;
	static boolean visit[][];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int R;
	static int C;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		R = r;
		C = c;
		
		graph = new char[R][C];
		visit = new boolean[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		
		dfs(0, 0, 1);
		
		System.out.print(answer);
		
	}
	
	static public void dfs(int row, int col, int d) {
		answer = Math.max(answer, d);
		set.add(graph[row][col]);
		
		for(int i = 0 ; i < 4 ; i++) {
			int y = row + r[i];
			int x = col + c[i];
			
			if(y < 0 || y >= R || x < 0 || x >= C)continue;
			if(!visit[y][x] && !set.contains(graph[y][x])) {
				visit[y][x] = true;
				dfs(y, x, d+1);
				visit[y][x] = false;
			}
			
		}
		set.remove(graph[row][col]);
		
	}

}
