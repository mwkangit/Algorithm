package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ13459 {

	static int N, M;
	static char graph[][];
	static HashSet<String> visit = new HashSet<>();
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int eRow = 0, eCol = 0;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ps(st.nextToken());
		M = ps(st.nextToken());
		graph = new char[N][M];
		int rRow = 0;
		int rCol = 0;
		int bRow = 0;
		int bCol = 0;
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				char c = ps(str, j);
				if(c == 'B') {
					bRow = i;
					bCol = j;
					graph[i][j] = '.';
					continue;
				}else if(c == 'R') {
					rRow = i;
					rCol = j;
					graph[i][j] = '.';
					continue;
				}else if(c == 'O') {
					eRow = i;
					eCol = j;
				}
				graph[i][j] = c;
			}
		}
		String sub = conv(rRow, rCol, bRow, bCol);
		visit.add(sub);

		bfs(rRow, rCol, bRow, bCol);
		System.out.print(flag ? 1 : 0);
	}
	static void bfs(int a, int b, int d, int e) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a, b, d, e, 0));
		
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			int rRow = node.rRow;
			int rCol = node.rCol;
			int bRow = node.bRow;
			int bCol = node.bCol;
			int count = node.count;
			
			if(count >= 10)continue;
			for(int i = 0 ; i < 4 ; i++) {
				boolean firstB = false;
				boolean firstR = false;
				boolean noFlag = false;
				int roR = rRow;
				int coR = rCol;
				int roB = bRow;
				int coB = bCol;
				
				while(graph[roB + r[i]][coB + c[i]] != '#') {
					roB += r[i];
					coB += c[i];
					if(roB == rRow && coB == rCol)firstR = true;
					if(roB == eRow && coB == eCol) {
						noFlag = true;
						break;
					}
				}
				if(noFlag)continue;
				while(graph[roR + r[i]][coR + c[i]] != '#') {
					roR += r[i];
					coR += c[i];
					if(roR == bRow && coR == bCol)firstB = true;
					if(roR == eRow && coR == eCol) {
						noFlag = true;
						break;
					}
				}
				if(noFlag) {
					flag = true;
					return;
				}
				if(firstR) {
					roB = roR - r[i];
					coB = coR - c[i];
				}else if(firstB) {
					roR = roB - r[i];
					coR = coB - c[i];
				}
				
				String sub = conv(roR, coR, roB, coB);
				if(visit.contains(sub))continue;
				visit.add(sub);
				
				q.add(new Node(roR, coR, roB, coB, count+1));
				
				
			}
		}
		
		
	}
	
	static String conv(int a, int b, int c, int d) {
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(",").append(b).append(",").append(c).append(",").append(d);
		return sb.toString();
	}
	static class Node{
		int rRow, rCol, bRow, bCol, count;
		public Node(int r1, int r2, int b1, int b2, int c) {
			rRow = r1;
			rCol = r2;
			bRow = b1;
			bCol = b2;
			count = c;
		}
	}
	
	static char ps(String str, int index) {
		return str.charAt(index);
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
