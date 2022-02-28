package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ5373 {
	
	static char up[][];
	static char down[][];
	static char front[][];
	static char back[][];
	static char left[][];
	static char right[][];
	static int n;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		
		for(int loop = 0 ; loop < n ; loop++) {
			up = new char[3][3];
			down = new char[3][3];
			front = new char[3][3];
			back = new char[3][3];
			left = new char[3][3];
			right = new char[3][3];
			cube_fill();
			
			st = new StringTokenizer(br.readLine(), " ");
			int seq = Integer.parseInt(st.nextToken());
			String str1[] = br.readLine().split(" ");
			for(int loop2 = 0 ; loop2 < seq ; loop2++) {
				char loc = str1[loop2].charAt(0);
				char dir = str1[loop2].charAt(1);
				
				if(loc == 'U') {
					turnU(dir);
				} else if(loc == 'D') {
					turnD(dir);
				} else if(loc == 'F') {
					turnF(dir);
				} else if(loc == 'B') {
					turnB(dir);
				} else if(loc == 'L') {
					turnL(dir);
				} else if(loc == 'R') {
					turnR(dir);
				}
			}
			
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 2 ; j >= 0 ; j--) {
					System.out.print(up[j][i]);
				}
				System.out.println();
			}
		}

	}
	
	static void turn_cen(char[][] graph, char dir) {
		char[][] sub_graph = new char[3][3];
		
		if(dir == '+') {
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(i == 0) {
						sub_graph[j][2] = graph[i][j];
					} else if(i == 1) {
						sub_graph[j][i] = graph[i][j];
					} else if(i == 2) {
						sub_graph[j][0] = graph[i][j];
					}
				}
			}
		} else {
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(j == 0) {
						sub_graph[2][i] = graph[i][j];
					} else if(j == 1) {
						sub_graph[j][i] = graph[i][j];
					} else if(j == 2) {
						sub_graph[0][i] = graph[i][j];
					}
				}
			}
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				graph[i][j] = sub_graph[i][j];
			}
		}
		
		

		
	}
	
	static void turnR(char dir) {
		char sub[] = new char[3];
		if(dir == '+') {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = up[0][i];
				up[0][i] = front[i][2];
				front[i][2] = down[2][2-i];
				down[2][2-i] = back[2-i][0];
				back[2-i][0] = sub[i];
			}
		} else {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = up[0][i];
				up[0][i] = back[2-i][0];
				back[2-i][0] = down[2][2-i];
				down[2][2-i] = front[i][2];
				front[i][2] = sub[i];
			}
		}
		turn_cen(right, dir);
	}
	
	static void turnL(char dir) {
		char sub[] = new char[3];
		if(dir == '-') {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = up[2][i];
				up[2][i] = front[i][0];
				front[i][0] = down[0][2-i];
				down[0][2-i] = back[2-i][2];
				back[2-i][2] = sub[i];
			}
		} else {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = up[2][i];
				up[2][i] = back[2-i][2];
				back[2-i][2] = down[0][2-i];
				down[0][2-i] = front[i][0];
				front[i][0] = sub[i];
			}
		}
		turn_cen(left, dir);
	}
	
	static void turnB(char dir) {
		char sub[] = new char[3];
		if(dir == '+') {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[i][0];
				left[i][0] = up[i][0];
				up[i][0] = right[i][0];
				right[i][0] = down[i][0];
				down[i][0] = sub[i];
			}
		} else {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[i][0];
				left[i][0] = down[i][0];
				down[i][0] = right[i][0];
				right[i][0] = up[i][0];
				up[i][0] = sub[i];
			}
		}
		turn_cen(back, dir);
	}
	
	static void turnF(char dir) {
		char sub[] = new char[3];
		if(dir == '-') {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[i][2];
				left[i][2] = up[i][2];
				up[i][2] = right[i][2];
				right[i][2] = down[i][2];
				down[i][2] = sub[i];
			}
		} else {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[i][2];
				left[i][2] = down[i][2];
				down[i][2] = right[i][2];
				right[i][2] = up[i][2];
				up[i][2] = sub[i];
			}
		}
		turn_cen(front, dir);
	}
	
	static void turnD(char dir) {
		char sub[] = new char[3];
		if(dir == '-') {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[2][i];
				left[2][i] = front[2][i];
				front[2][i] = right[0][2-i];
				right[0][2-i] = back[2][i];
				back[2][i] = sub[i];
			}
		} else {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[2][i];
				left[2][i] = back[2][i];
				back[2][i] = right[0][2-i];
				right[0][2-i] = front[2][i];
				front[2][i] = sub[i];
			}
		}
		turn_cen(down, dir);
	}
	
	
	
	static void turnU(char dir) {
		char sub[] = new char[3];
		if(dir == '+') {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[0][i];
				left[0][i] = front[0][i];
				front[0][i] = right[2][2-i];
				right[2][2-i] = back[0][i];
				back[0][i] = sub[i];
			}
		} else {
			for(int i = 0 ; i < 3 ; i++) {
				sub[i] = left[0][i];
				left[0][i] = back[0][i];
				back[0][i] = right[2][2-i];
				right[2][2-i] = front[0][i];
				front[0][i] = sub[i];
			}
		}
		turn_cen(up, dir);
	}
	
	static void cube_fill() {
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				up[i][j] = 'w';
				down[i][j] = 'y';
				front[i][j] = 'r';
				back[i][j] = 'o';
				left[i][j] = 'g';
				right[i][j] = 'b';
			}
		}
	}

}
