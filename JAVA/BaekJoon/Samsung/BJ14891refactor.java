package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14891refactor {

	static int node[][] = new int[4][9];
	static int command[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < 4 ; i++) {
			String str[] = br.readLine().split("");
			for(int j = 1 ; j <= 8 ; j++) {
				node[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		command = new int[K][2];
		
		for(int i = 0 ; i < K ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			command[i][0] = Integer.parseInt(st.nextToken());
			command[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < K ; i++) {
			boolean visit[] = new boolean[4];
			
			move(command[i][0], visit, command[i][1]);
			
		}
		
		System.out.print(node[0][1] * 1 + node[1][1] * 2 + node[2][1] * 4 + node[3][1] * 8);
		
		

	}
	
	static void move(int index, boolean visit[], int op) {
		
		visit[index-1] = true;
		int before;
		int next;
		before = index - 1 ;
		next = index + 1;
		
		if(before >= 1 && !visit[before-1] && node[before-1][3] != node[index-1][7]) {
			move(before, visit, op*-1);
		}
		if(next <= 4 && !visit[next-1] && node[next-1][7] != node[index-1][3]) {
			move(next, visit, op*-1);
		}
		
		if(op == 1) {
			clock(index-1);
		} else if(op == -1) {
			reverse(index-1);
		}
	}
	
	static void clock(int row) {
		int sub = node[row][8];
		for(int i = 8 ; i > 1 ; i--) {
			node[row][i] = node[row][i-1];
		}
		node[row][1] = sub;
		
	}
	
	static void reverse(int row) {
		int sub = node[row][1];
		for(int i = 1 ; i < 8 ; i++) {
			node[row][i] = node[row][i+1];
		}
		node[row][8] = sub;
		
	}

}
