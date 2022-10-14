package samsung;

import java.util.*;
import java.io.*;

public class BJ20061 {

	static int N;
	static int graph[][] = new int[10][10];
	static int score = 0;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = ps(st.nextToken());
		
		for(int loop = 0 ; loop < N ; loop++) {
			st = new StringTokenizer(br.readLine());
			int t = ps(st.nextToken());
			int x = ps(st.nextToken());
			int y = ps(st.nextToken());
			moveTile(t, x, y);
			checkFill();
			checkLight();
		}
		checkAll();
		StringBuilder sb = new StringBuilder();
		sb.append(score).append("\n").append(answer);
		System.out.print(sb);
		
	}
	static void checkAll() {
		for(int i = 6 ; i < 10 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(graph[i][j] != 0) {
					answer++;
				}
			}
		}
		
		for(int j = 6 ; j < 10 ; j++) {
			for(int i = 0 ; i < 4 ; i++) {
				if(graph[i][j] != 0) {
					answer++;
				}
			}
		}
	}
	static void checkLight() {
		int count = 0;
		for(int i = 4 ; i < 6 ; i++) {
			for(int j = 0 ; j < 4; j++) {
				if(graph[i][j] != 0) {
					count++;
					break;
				}
			}
		}
		downTile(9, count);
		count = 0;
		for(int j = 4 ; j < 6 ; j++) {
			for(int i = 0 ; i < 4; i++) {
				if(graph[i][j] != 0) {
					count++;
					break;
				}
			}
		}
		rightTile(9, count);
	}
	
	static void checkFill() {
		for(int i = 9 ; i > 3 ; i--) {
			int count = 0;
			int countBlank = 0;
			for(int j = 0 ; j < 4 ; j++) {
				if(graph[i][j] == 1) {
					count++;
				}else {
					countBlank++;
				}
				
			}
			if(count == 4) {
				downTile(i, 1);
				i++;
				score++;
			}else if(countBlank == 4) {
				break;
			}
		}
		
		for(int j = 9 ; j > 3 ; j--) {
			int count = 0;
			int countBlank = 0;
			for(int i = 0 ; i < 4 ; i++) {
				if(graph[i][j] == 1) {
					count++;
				}else {
					countBlank++;
				}
				
			}
			if(count == 4) {
				
				rightTile(j, 1);
				j++;
				score++;
			}else if(countBlank == 4) {
				break;
			}
		}
	}
	static void rightTile(int level, int len) {
		if(len == 0)return;
		for(int j = level ; j > 3 ; j--) {
			for(int i = 0 ; i < 4 ; i++) {
				graph[i][j] = graph[i][j-len];
			}
		}
	}
	
	static void downTile(int level, int len) {
		if(len == 0)return;

		for(int i = level; i > 3 ; i--) {
			for(int j = 0 ; j < 4 ; j++) {
				graph[i][j] = graph[i-len][j];
			}

		}
	}
	
	static void moveTile(int t, int x, int y) {
		if(t == 1) {
			move1(x, y);
		}else if(t == 2) {
			move2(x, y);
		}else {
			move3(x, y);
		}
	}
	static void move3(int x, int y) {
		int subX = 5;
		while(subX < 10 && graph[subX][y] == 0) {
			subX++;
		}
		graph[subX-1][y] = 1;
		graph[subX-2][y] = 1;
		
		int subY = 5;
		while(subY < 10 && graph[x][subY] == 0 && graph[x+1][subY] == 0) {
			subY++;
		}
		
		graph[x][subY-1] = 1;
		graph[x+1][subY-1] = 1;
		
	}
	static void move2(int x, int y) {
		int subX = 5;
		while(subX < 10 && graph[subX][y] == 0 && graph[subX][y+1] == 0) {
			subX++;
		}
		graph[subX-1][y] = 1;
		graph[subX-1][y+1] = 1;
		
		int subY = 5;
		while(subY < 10 && graph[x][subY] == 0) {
			subY++;
		}
		
		graph[x][subY-1] = 1;
		graph[x][subY-2] = 1;
		
	}
	
	static void move1(int x, int y) {
		int subX = 5;
		while(subX < 10 && graph[subX][y] == 0) {
			subX++;
		}
		graph[subX-1][y] = 1;
		
		int subY = 5;
		while(subY < 10 && graph[x][subY] == 0) {
			subY++;
		}
		graph[x][subY-1] = 1;
		
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
