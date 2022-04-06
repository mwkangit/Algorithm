package samsung;

import java.util.*;
import java.io.*;

public class BJ21610 {

	static int graph[][];
	static int attempt[][];
	static int N, M;
	static ArrayList<Node> three = new ArrayList<>();
	static ArrayList<Node> five = new ArrayList<>();
	static int rdir[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int cdir[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int rdia[] = {-1, -1, 1, 1};
	static int cdia[] = {-1, 1, 1, -1};
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = parse(st.nextToken());
		M = parse(st.nextToken());
		graph = new int[N][N];
		attempt = new int[M][2];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = parse(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			attempt[i][0] = parse(st.nextToken())-1;
			attempt[i][1] = parse(st.nextToken());
			
		}
		
		three.add(new Node(N-1, 0));
		three.add(new Node(N-1, 1));
		three.add(new Node(N-2, 0));
		three.add(new Node(N-2, 1));
		
		for(int loop = 0 ; loop < M ; loop++) {
//			printG();
			visit = new boolean[N][N];
			move(attempt[loop][0], attempt[loop][1]);
			rainStart();
			copyBug();
			three = new ArrayList<>();
			makeCloud();
		}
		
		int answer = sum();
		System.out.print(answer);
	}
	static int sum() {
		int result = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				result += graph[i][j];
			}
		}
		return result;
	}
	
	static void makeCloud() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(graph[i][j] >= 2 && !visit[i][j]) {
					graph[i][j] -= 2;
					three.add(new Node(i, j));
				}
			}
		}
	}
	
	static void copyBug() {
		for(int i = 0 ; i < three.size() ; i++) {
			Node node = three.get(i);
			for(int j = 0 ; j < 4 ; j++) {
				int row = node.row + rdia[j];
				int col = node.col + cdia[j];
				if(row < 0 || row >= N || col < 0 || col >= N || graph[row][col] <= 0)continue;
				graph[node.row][node.col]++;
			}
		}
	}
	
	static void rainStart() {
		for(int i = 0 ; i < three.size() ; i++) {
			Node node = three.get(i);
			graph[node.row][node.col]++; 
		}
	}
	
	static void move(int d, int s) {
		for(int i = 0 ; i < three.size() ; i++) {
			Node node = three.get(i);
			for(int j = 0 ; j < s ; j++) {
				node.row += rdir[d];
				node.col += cdir[d];
				if(node.row < 0) node.row = N-1;
				else if(node.row >= N) node.row = 0;
				if(node.col < 0) node.col= N-1;
				else if(node.col >= N) node.col= 0;
			}
			visit[node.row][node.col] = true;
		}
	}
	
	static int parse(String str) {
		return Integer.parseInt(str);
	}
	
	static class Node {
		int row, col;
		
		public Node(int r, int c) {
			row = r;
			col = c;
		}
	}

}
