package divideandconquer;

import java.util.*;

public class BJ2447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char[][] graph = dq(N);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append(graph[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static char[][] dq(int N) {
		char[][] graph = new char[N][N];
		char[][] comp;
		if(N / 3 != 1) {
			comp = dq(N/3);
		}else {
			char first[][] = new char[3][3];
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					first[i][j] = '*';
				}
			}
			first[1][1] = ' ';
			return first;
		}
		int sub = N/3;
		
		for(int i = 0 ; i < N ; i=i+sub) {
			for(int j = 0 ; j < N ; j=j+sub) {
				for(int k = 0 ; k < sub ; k++) {
					for(int l = 0 ; l < sub ; l++) {
						graph[i+k][j+l] = comp[k][l];
					}
				}
			}
		}
		
		for(int i = sub ; i < 2*sub ; i++) {
			for(int j = sub ; j < 2*sub ; j++) {
				graph[i][j] = ' ';
			}
		}
		
		
		return graph;
		
	}

}
