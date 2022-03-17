package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17779 {
	
	static int N;
	static int graph[][];
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0 ; i < N - 2 ; i++) {
			for(int j = 1 ; j < N - 1 ; j++) {
				check(i, j);
			}
		}
		
		System.out.print(answer);
		
	}
	
	static void check(int row, int col) {
		
		dfs(row, col);
		
	}
	
	static void dfs(int row, int left) {
//		int test = 0;
		int limit = N - row - 1;
		for(int dOne = 1 ; dOne <= left ; dOne++) {
			for(int dTwo = 1 ; dTwo <= limit - dOne ; dTwo++) {
				if(dTwo + left >= N) continue;
//				test++;
//				System.out.println(test);
				HashMap<Integer, Integer> map = new HashMap<>();
				boolean five[][] = new boolean[N][N];
				int l = dOne;
				int r = dTwo;
				int lIndex = left;
				int rIndex = left;
				boolean flagOne = true;
				boolean flagTwo = true;
				five[row][left] = true;
				for(int i = row+1 ; i <= row + dOne + dTwo ; i++) {
					if(flagOne) {
						l--;
						lIndex--;
					}else {
						lIndex++;
					}
					if(flagTwo) {
						r--;
						rIndex++;
					}else {
						rIndex--;
					}
					
					for(int j = lIndex ; j <= rIndex ; j++) {
//						System.out.println(i + " " + j + " " + dOne + " " + dTwo + " " + row + " " + left);
						five[i][j] = true;
					}
					
					
					if(l == 0) {
						flagOne = false;
					}
					if(r == 0) {
						flagTwo = false;
					}
				}
//				if(dOne == 2 && dTwo == 1 && row == 2 && left == 4) {
//					System.out.println(dOne + " " + dTwo + " " + row + " " + left);
//					for(int i = 0 ; i < N ; i++) {
//						for(int j = 0 ; j < N ; j++) {
//							System.out.print(five[i][j]);
//						}
//						System.out.println();
//					}
//				}
				
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						if(i >= 0 && i < row + dOne && j >= 0 && j <= left && !five[i][j]) {
							map.put(1, map.getOrDefault(1, 0) + graph[i][j]);
						} else if( i >= 0 && i <= row + dTwo && j > left && j < N && !five[i][j]) {
							map.put(2, map.getOrDefault(2, 0) + graph[i][j]);
						} else if(i >= row + dOne && i < N && j >= 0 && j < left - dOne + dTwo && !five[i][j]) {
							map.put(3, map.getOrDefault(3, 0) + graph[i][j]);
						} else if(i >= row + dTwo && i < N && j >= left - dOne + dTwo && j < N && !five[i][j]) {
							map.put(4, map.getOrDefault(4, 0) + graph[i][j]);
						} else {
							map.put(5, map.getOrDefault(5, 0) + graph[i][j]);
						}
					}
				}
				if(!map.isEmpty()) {
					int maxi = 0;
					int mini = Integer.MAX_VALUE;
					
					for(int i : map.keySet()) {
						int value = map.get(i);
//						if(dOne == 2 && dTwo == 1 && row == 2 && left == 4) {
//							System.out.println(i + " " + value);
//						}
						maxi = Math.max(maxi, value);
						mini = Math.min(mini, value);
					}
					answer = Math.min(answer, maxi - mini);
					
				}
			}
		}
	}

}