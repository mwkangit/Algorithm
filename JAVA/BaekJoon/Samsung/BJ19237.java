package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ19237 {

	static int N, M, k;
	static int r[] = {0,-1, 1, 0, 0};
	static int c[] = {0, 0, 0, -1, 1};
	static Node graph[][];
	static Shark sharks[];
	static int loc[][];
	static int totalCount;
	static int time;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		k = ps(st.nextToken());
		
		graph = new Node[N][N];
		sharks = new Shark[M+1];
		sharks[0] = new Shark(0, 0, 0);
		loc = new int[N][N];
		totalCount = M;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int numb = ps(st.nextToken());
				graph[i][j] = new Node(numb, 0);
				graph[i][j].num = numb;
				if(numb != 0) {
					graph[i][j].smell = k;
					sharks[numb] = new Shark(i, j, numb);
					loc[i][j] = numb;
				}
			}
			
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= M ; i++) {
			sharks[i].dir = ps(st.nextToken());
		}
		for(int i = 1 ; i <= M ; i++) {
			for(int j = 1 ; j <= 4 ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 1 ; k <= 4 ; k++) {
					int numb = ps(st.nextToken());
					sharks[i].priorDir[j][k] = numb;
				}
			}
		}

		while(totalCount > 1 && time <= 1000) {
			
			move();
			minusSmell();
			addSmell();
			time++; 
		}

			System.out.print(time > 1000 ? -1 : time);
		
	}
	static void addSmell() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(loc[i][j] != 0) {
					graph[i][j].num = loc[i][j];
					graph[i][j].smell = k;
				}
			}
		}
	}
	static void minusSmell() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(graph[i][j].num != 0) {
					graph[i][j].smell--;
					if(graph[i][j].smell == 0) {
						graph[i][j].num = 0;
					}
				}
			}
		}
	}
	static void move() {
		for(int i = 1 ; i <= M ; i++) {
			Shark shark = sharks[i];
			if(!shark.alive)continue;
			if(!moveShark(shark)) {
				movePrev(shark);
			}
		}
	}
	static void movePrev(Shark shark) {
		int dir = shark.dir;
		for(int i = 1 ; i <= 4 ; i++) {
			int way = shark.priorDir[dir][i];
			int ro = shark.row + r[way];
			int co = shark.col + c[way];
			if(ro < 0 || ro >= N || co < 0 || co >= N || graph[ro][co].num != shark.num)continue;
			loc[shark.row][shark.col] = 0;
			loc[ro][co] = shark.num;
			shark.row = ro;
			shark.col = co;
			shark.dir = way;
			return;
		}
		return;
	}
	static boolean moveShark(Shark shark) {
		
		int dir = shark.dir;
		for(int i = 1 ; i <= 4 ; i++) {
			int way = shark.priorDir[dir][i];
			int ro = shark.row + r[way];
			int co = shark.col + c[way];
			if(ro < 0 || ro >= N || co < 0 || co >= N || graph[ro][co].num != 0)continue;
			if(loc[ro][co] != 0) {
				shark.alive = false;
				loc[shark.row][shark.col] = 0;
				totalCount--;
				return true;
			}
			loc[shark.row][shark.col] = 0;
			loc[ro][co] = shark.num;
			shark.row = ro;
			shark.col = co;
			shark.dir = way;
			
			
			return true;
			
		}
		
		return false;
	}
	static class Node{
		int num, smell;
		public Node(int n, int s) {
			num = n;
			smell = s;
		}
	}
	
	static class Shark{
		int row, col, num, dir;
		boolean alive = true;
		public Shark(int r, int c, int n) {
			row = r;
			col = c;
			num = n;
		}
		
		int priorDir[][] = new int[5][5];
	}
//	static void printS() {
//		for(int i = 1 ; i <= M ; i++) {
//			System.out.print(sharks[i].row + " " + sharks[i].col + " / ");
//		}
//		System.out.println();
//	}
//	static void printGN() {
//		for(int i = 0 ; i < N ; i++) {
//			for(int j = 0 ; j < N ; j++) {
//				System.out.print(graph[i][j].num + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	static void printGS() {
//		for(int i = 0 ; i < N ; i++) {
//			for(int j = 0 ; j < N ; j++) {
//				System.out.print(graph[i][j].smell + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
