package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ3190 {

	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int graph[][];
	static String change[][];
	static int lastr = 0;
	static int lastc = 0;
	static int answer = 0;
	static int N;
	static int C;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		N = n;
		int K = Integer.parseInt(br.readLine());
		int apple[][] = new int[K][2];
		graph = new int[N][N];
		for(int i = 0 ; i < K ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			graph[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]
		}
		
		C = Integer.parseInt(br.readLine());
		change = new String[C][2];
		for(int i = 0 ; i < C ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			change[i][0] = st.nextToken();
			change[i][1] = st.nextToken();
		}
		move();
		
		System.out.print(answer);
		
	}
	
	static void move() {
		int dir = 0;
		int row = 0;
		int col = 0;
		int index = 0;
		Queue<Path> q = new LinkedList<>();
		q.add(new Path(0,0));
		while(true) {
			if(index != C && answer == Integer.parseInt(change[index][0])) {
				if(change[index][1].equals("D")) {
					dir += 1;
					if(dir > 3) {
						dir = 0;
					}
				} else if(change[index][1].equals("L")) {
					dir -= 1;
					if(dir < 0) {
						dir = 3;
					}
				}
				index++;
			}
			row += r[dir];
			col += c[dir];
			
			if(row < 0 || row >= N || col < 0 || col >= N || graph[row][col] == 1)break;

			q.add(new Path(row, col));
			
			if(graph[row][col] == 2) {
				graph[row][col] = 1;
			} else {
				Path p = q.poll();
				graph[p.ro][p.co] = 0;
				graph[row][col] = 1;
			}
			answer++;
			
		}
		
		answer++;
		
	}
	
	static class Path{
		int ro;
		int co;
		
		public Path(int r, int c) {
			ro = r;
			co = c;
		}
	}
	
	

}
