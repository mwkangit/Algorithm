package divideandconquer;

import java.util.*;
import java.io.*;

public class BJ1992 {

	static int graph[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		if(N == 1) {
			sb.append("(" + graph[0][0] + ")");
		}else {
			find(0, 0, N);
		}
		
		System.out.print(sb);
		
	}
	static void find(int row, int col, int N) {
		int sub = N/2;
		sb.append("(");
		if(N == 1) {
			sb.append(graph[row][col]);	
			sb.append(graph[row][col+1]);
			sb.append(graph[row+1][col]);
			sb.append(graph[row+1][col+1]);
		}
		for(int i = row ; i < row + N ; i = i + sub) {
			for(int j = col ; j < col + N ; j = j + sub) {
				int comp = graph[i][j];
				boolean flag = false;
				for(int k = 0 ; k < sub ; k++) {
					for(int l = 0 ; l < sub ; l++) {
						if(comp != graph[i+k][j+l]) {
							find(i, j, sub);
							flag = true;
							break;
						}
					}
					if(flag) break;
				}
				if(!flag) {
					sb.append(comp);
				}
			}
		}
		
		
		sb.append(")");
	}

}
