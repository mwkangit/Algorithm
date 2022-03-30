package divideandconquer;

import java.util.*;

public class BJ2447other {
	
	static char graph[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		graph = new char[N][N];
		
		dq(0,0,N,false);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append(graph[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	static void dq(int row, int col, int N, boolean flag) {
		
		if(flag) {
			for(int i = row ; i < row + N ; i++) {
				for(int j = col ; j < col + N ; j++) {
					graph[i][j] = ' ';
				}
			}
			return;
		}
		
		if(N == 1) {
			graph[row][col] = '*';
			return;
		}
		
		int sub = N / 3;
		int count = 0;
		for(int i = row ; i < row + N ; i= i+sub) {
			for(int j = col ; j < col + N ; j = j + sub) {
				count++;
				if(count == 5) {
					dq(i, j, sub, true);
				} else {
					dq(i, j, sub, false);
				}
			}
		}
		
		
		
	}

}
