package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14891 {

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
			switch(command[i][0]) {
			case 1: number1(command[i][1]);
			break;
			case 2: number2(command[i][1]);
			break;
			case 3: number3(command[i][1]);
			break;
			case 4: number4(command[i][1]);
			break;
			}
		}
		
		System.out.print(node[0][1] * 1 + node[1][1] * 2 + node[2][1] * 4 + node[3][1] * 8);
		
		

	}
	
	static void number4(int op) {
		int right = node[2][3];
		int left = node[3][7];
		if(op == 1) {
			if(right != left) {
				right = node[1][3];
				left = node[2][7];
				if(right != left) {
					right = node[0][3];
					left = node[1][7];
					if(right != left) {
						reverse(0);
					}
					clock(1);
				}
				reverse(2);
			}
			clock(3);
		} else {
			if(right != left) {
				right = node[1][3];
				left = node[2][7];
				if(right != left) {
					right = node[0][3];
					left = node[1][7];
					if(right != left) {
						clock(0);
					}
					reverse(1);
				}
				clock(2);
			}
			reverse(3);
		}
	}
	
	static void number3(int op) {
		int right = node[2][3];
		int left = node[3][7];
		if(op == 1) {
			if(right != left) {
				reverse(3);
			}
			right = node[1][3];
			left = node[2][7];
			if(right != left) {
				right = node[0][3];
				left = node[1][7];
				if(right != left) {
					clock(0);
				}
				reverse(1);
			}
			clock(2);
		} else {
			if(right != left) {
				clock(3);
			}
			right = node[1][3];
			left = node[2][7];
			if(right != left) {
				right = node[0][3];
				left = node[1][7];
				if(right != left) {
					reverse(0);
				}
				clock(1);
			}
			reverse(2);
		}
	}
	
	static void number2(int op) {
		int right = node[0][3];
		int left = node[1][7];
		if(op == 1) {
			if(right != left) {
				reverse(0);
			}
			right = node[1][3];
			left = node[2][7];
			if(right != left) {
				right = node[2][3];
				left = node[3][7];
				if(right != left) {
					clock(3);
				}
				reverse(2);
			}
			clock(1);
		} else {
			if(right != left) {
				clock(0);
			}
			right = node[1][3];
			left = node[2][7];
			if(right != left) {
				right = node[2][3];
				left = node[3][7];
				if(right != left) {
					reverse(3);
				}
				clock(2);
			}
			reverse(1);
		}
	}
	
	static void number1(int op) {
		int right = node[0][3];
		int left = node[1][7];
		if(op == 1) {
			if(right != left) {
				right = node[1][3];
				left = node[2][7];
				if(right != left) {
					right = node[2][3];
					left = node[3][7];
					if(right != left) {
						reverse(3);
					}
					clock(2);
				}
				reverse(1);
			}
			clock(0);
		} else {
			if(right != left) {
				right = node[1][3];
				left = node[2][7];
				if(right != left) {
					right = node[2][3];
					left = node[3][7];
					if(right != left) {
						clock(3);
					}
					reverse(2);
				}
				clock(1);
			}
			reverse(0);
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
