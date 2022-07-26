package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class BJ23288 {
	static int N, M, K;
	static int graph[][];
	static Node curr;
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		K = ps(st.nextToken());
		graph = new int[N][M];
		
		int answer = 0;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = ps(st.nextToken());
			}
		}
		curr = new Node(3, 4, 2, 1, 5, 6, 1, 0, 0);
		
		
		for(int loop = 0 ; loop < K ; loop++) {
			
			move();
			System.out.println(curr.row + " " + curr.col);
			answer += oper();
			changeDir();
			
		}
		System.out.print(answer);
		
	}
	static void changeDir() {
		int bottom = curr.down2;
		int B = graph[curr.row][curr.col];
		if(bottom > B) {
			curr.dir++;
			if(curr.dir >= 5) {
				curr.dir = 1;
			}
		}else if(bottom < B) {
			curr.dir--;
			if(curr.dir < 1) {
				curr.dir = 4;
			}
		}
	}
	static int bfs() {
		int row = curr.row;
		int col = curr.col;
		Queue<Coor> q = new LinkedList<>();
		q.add(new Coor(row, col));
		boolean visit[][] = new boolean[N][M];
		visit[row][col] = true;
		int num = graph[row][col];
		int result = 1;
		
		while(!q.isEmpty()) {
			Coor coor = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int ro = coor.row + r[i];
				int co = coor.col + c[i];
				
				if(ro < 0 || ro >= N || co < 0 || co >= M || visit[ro][co] || graph[ro][co] != num)continue;
				
				visit[ro][co] = true;
				result++;
				q.add(new Coor(ro, co));
			}
		}
		return result;
		
	}
	
	static int oper() {
		int B = graph[curr.row][curr.col];
		int C = bfs();
		return B * C;
	}
	static void moveDown() {
		int sub = curr.middle;
		curr.middle = curr.up;
		curr.up = curr.down2;
		curr.down2 = curr.down1;
		curr.down1 = sub;
		curr.row++;
	}
	
	static void moveUp() {
		int sub = curr.middle;
		curr.middle = curr.down1;
		curr.down1 = curr.down2;
		curr.down2 = curr.up;
		curr.up = sub;
		curr.row--;
	}
	
	static void moveLeft() {
		int sub = curr.middle;
		curr.middle = curr.right;
		curr.right = curr.down2;
		curr.down2 = curr.left;
		curr.left = sub;
		curr.col--;
	}
	
	static void moveRight() {
		int sub = curr.middle;
		curr.middle = curr.left;
		curr.left = curr.down2;
		curr.down2 = curr.right;
		curr.right = sub;
		curr.col++;
	}
	
	static void move() {
		if(curr.dir == 1) {
			if(curr.col + 1 >= M) {
				curr.dir = 3;
				move();
				return;
			}
			moveRight();
		}else if(curr.dir == 2) {
			if(curr.row + 1 >= N) {
				curr.dir = 4;
				move();
				return;
			}
			moveDown();
		}else if(curr.dir == 3) {
			if(curr.col - 1 < 0) {
				curr.dir = 1;
				move();
				return;
			}
			moveLeft();
		}else {
			if(curr.row - 1 < 0) {
				curr.dir = 2;
				move();
				return;
			}
			moveUp();
		}
	}
	
	static class Node{
		int right, left, up, middle, down1, down2;
		int dir;
		int row, col;
		public Node(int r, int l, int u, int m, int d1, int d2, int d, int ro, int co) {
			right = r;
			left = l;
			up = u;
			middle = m;
			down1 = d1;
			down2 = d2;
			dir = d;
			row = ro;
			col = co;
		}
	}
	static class Coor{
		int row, col;
		public Coor(int r, int c) {
			row = r;
			col = c;
		}
	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
