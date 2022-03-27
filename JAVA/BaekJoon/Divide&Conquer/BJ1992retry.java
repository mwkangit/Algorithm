package divideandconquer;

import java.util.*;

public class BJ1992retry {

	static int graph[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		graph = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		dq(0,0,N);
		
		System.out.print(sb);
		
		
	}
	
	static void dq(int row, int col, int N) {
		if(isPossible(row, col, N)) {
			sb.append(graph[row][col]);
			return;
		}
		
		sb.append("(");
		
		int nextN= N / 2;
		dq(row, col, nextN);
		dq(row, col + nextN, nextN);
		dq(row + nextN, col, nextN);
		dq(row + nextN, col + nextN, nextN);
		
		
		sb.append(")");
	}
	
	static boolean isPossible(int row, int col, int N) {
		int comp = graph[row][col];
		for(int i = row ; i < row + N ; i++) {
			for(int j = col ; j < col + N ; j++) {
				if(graph[i][j] != comp)return false;
			}
		}
		return true;
	}

}
