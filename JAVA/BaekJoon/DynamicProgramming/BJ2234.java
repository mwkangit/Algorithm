package DynamicProgramming;
import java.util.*;
import java.io.*;

public class BJ2234 {
	
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static String graph[][];
	static boolean visit[][];
	static int max_count = 0;
	static int maxi = 0;
	static int max_add = 0;
	static HashMap<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in1[] = br.readLine().split(" ");
		int M = Integer.parseInt(in1[1]);
		int N = Integer.parseInt(in1[0]);
		
		graph = new String[M][N];
		visit = new boolean[M][N];
		
		for(int i = 0 ; i < M ; i++) {
			String[] in2 = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = String.format("%04d", Integer.parseInt(Integer.toString(Integer.parseInt(in2[j]), 2)));
			}
		}
		
		int count = 0;
		map = new HashMap<>();
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!visit[i][j]) {
					count++;
					max_count = 0;
					bfs(i, j, count, M, N);
					map.put(count, max_count);
					maxi = Math.max(maxi, max_count);
					
				}
			}
		}
		
		
		checkMax(M, N);
		
		System.out.println(count + " " + maxi + " " + max_add);

	}
	
	static public void checkMax(int M, int N) {
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < 4 ; k++) {
					if(i+r[k] >= 0 && i+r[k] < M && j+c[k] >= 0 && j+c[k]< N && !graph[i][j].equals(graph[i+r[k]][j+c[k]])) {
						max_add = Math.max(max_add, map.get(Integer.parseInt(graph[i][j])) + map.get(Integer.parseInt(graph[i+r[k]][j+c[k]])));
					}
				}
			}
		}
	}
	
	static public void bfs(int y, int x, int count, int M, int N) {
		
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(y, x));
		visit[y][x] = true;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int row = pair.row;
			int col = pair.col;
			max_count++;
			
			if(row+1 < M && !visit[row+1][col] && graph[row][col].charAt(0) == '0') {
				visit[row+1][col] = true;
				q.add(new Pair(row+1, col));
			}
			if(col+1 < N && !visit[row][col+1] && graph[row][col].charAt(1) == '0') {
				visit[row][col+1] = true;
				q.add(new Pair(row, col+1));
			}
			if(row-1 >= 0 && !visit[row-1][col] && graph[row][col].charAt(2) == '0') {
				visit[row-1][col] = true;
				q.add(new Pair(row-1, col));
			}
			if(col-1 >= 0 && !visit[row][col-1] && graph[row][col].charAt(3) == '0') {
				visit[row][col-1] = true;
				q.add(new Pair(row, col-1));
			}
			
			graph[row][col] = String.valueOf(count);
			
			
		}
		
	}
	
	static class Pair{
		int row, col;
		public Pair(int r, int c) {
			row = r;
			col = c;
		}
	}

}
