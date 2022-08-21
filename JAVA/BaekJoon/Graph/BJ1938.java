package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BJ1938Retry {

	static char[][] graph;
	static int N;
	static Node lumber;
	static Node end;
	static int r[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int c[] = {1, 1, 0, -1, -1, -1, 0, 1};
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		graph = new char[N][N];
		
		int countLumber = 0;
		int countEnd = 0;
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				char c = str.charAt(j);
				if(c == 'B') {
					countLumber++;
					if(countLumber == 2) {
						lumber = new Node(i, j, false, 0);
					}
				}else if(c == 'E') {
					countEnd++;
					if(countEnd == 2) {
						end = new Node(i, j, false, 0);
					}
					
					
				}
				graph[i][j] = c;
				
			}
		}
		if(lumber.row+1 < N && graph[lumber.row+1][lumber.col] == 'B') {
			lumber.rotate = true;
		}
		if(end.row+1 < N && graph[end.row+1][end.col] == 'E') {
			end.rotate = true;
		}
		bfs();
		
		System.out.print(answer == Integer.MAX_VALUE ? 0 : answer);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(lumber.row, lumber.col, lumber.rotate, 0));
		boolean visit[][][] = new boolean[N][N][2];
		if(lumber.rotate) {
			visit[lumber.row][lumber.col][0] = true;
		}else {
			visit[lumber.row][lumber.col][1] = true;
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if((node.row == end.row && node.col == end.col) && (node.rotate == end.rotate)) {
				answer = node.count;
				return;
			}
			
			boolean flag = true;
			for(int i = 0 ; i < 8 ; i++) {
				int ro = node.row + r[i];
				int co = node.col + c[i];
				if(ro < 0 || ro >= N || co < 0 || co >= N || graph[ro][co] == '1') {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(node.rotate && !visit[node.row][node.col][1]) {
					visit[node.row][node.col][1] = true;
					q.add(new Node(node.row, node.col, false, node.count+1));
				}else if(!node.rotate && !visit[node.row][node.col][0]) {
					visit[node.row][node.col][0] = true;
					q.add(new Node(node.row, node.col, true, node.count+1));
				}
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				if(node.rotate) {
					if(i == 0) {
						if(node.row - 2 >= 0 && graph[node.row-2][node.col] != '1' && !visit[node.row-1][node.col][0]) {
							visit[node.row-1][node.col][0] = true;
							q.add(new Node(node.row-1, node.col, true, node.count+1));
						}
					}else if(i == 1) {
						if(node.row + 2 < N && graph[node.row+2][node.col] != '1' && !visit[node.row+1][node.col][0]) {
							visit[node.row+1][node.col][0] = true;
							q.add(new Node(node.row+1, node.col, true, node.count+1));
						}
					}else if(i == 2) {
						if(node.col - 1 >= 0 && graph[node.row][node.col-1] != '1' && graph[node.row-1][node.col-1] != '1' && graph[node.row+1][node.col-1] != '1' && !visit[node.row][node.col-1][0]) {
							visit[node.row][node.col-1][0] = true;
							q.add(new Node(node.row, node.col-1, true, node.count+1));
						}
					}else if(i == 3) {
						if(node.col + 1 < N && graph[node.row][node.col+1] != '1' && graph[node.row-1][node.col+1] != '1' && graph[node.row+1][node.col+1] != '1' && !visit[node.row][node.col+1][0]) {
							visit[node.row][node.col+1][0] = true;
							q.add(new Node(node.row, node.col+1, true, node.count+1));
						}
					}
				}else {
					if(i == 0) {
						if(node.row - 1 >= 0 && graph[node.row-1][node.col] != '1' && graph[node.row-1][node.col-1] != '1' && graph[node.row-1][node.col+1] != '1' && !visit[node.row-1][node.col][1]) {
							visit[node.row-1][node.col][1] = true;
							q.add(new Node(node.row-1, node.col, false, node.count+1));
						}
					}else if(i == 1) {
						if(node.row + 1 < N && graph[node.row+1][node.col] != '1' && graph[node.row+1][node.col-1] != '1' && graph[node.row+1][node.col+1] != '1' && !visit[node.row+1][node.col][1]) {
							visit[node.row+1][node.col][1] = true;
							q.add(new Node(node.row+1, node.col, false, node.count+1));
						}
					}else if(i == 2) {
						if(node.col - 2 >= 0 && graph[node.row][node.col-2] != '1' && !visit[node.row][node.col-1][1]) {
							visit[node.row][node.col-1][1] = true;
							q.add(new Node(node.row, node.col-1, false, node.count+1));
						}
					}else if(i == 3) {
						if(node.col + 2 < N && graph[node.row][node.col+2] != '1' && !visit[node.row][node.col+1][1]) {
							visit[node.row][node.col+1][1] = true;
							q.add(new Node(node.row, node.col+1, false, node.count+1));
						}
					}
				}
				
			}
		}
		
		
		
	}
	static class Node{
		int row, col, count;
		boolean rotate;
		public Node(int r, int c, boolean ro, int co) {
			row = r;
			col = c;
			rotate = ro;
			count = co;
		}
		
	}
}
