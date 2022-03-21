package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ19236 {
	
	static Node shark;
	static int r[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int c[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int maxi = Integer.MIN_VALUE;
	static HashMap<Integer, Node> map = new HashMap<>();
//	static int graph[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int graph[][] = new int[4][4];
//		HashMap<Integer, Node> map = new HashMap<>();
		
		for(int i = 0 ; i < 4 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 4 ; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				graph[i][j] = num;
				map.put(num, new Node(num, i, j, dir));
			}
		}
		
			
		shark = new Node(17, 0, 0, map.get(graph[0][0]).dir);
		map.remove(graph[0][0]);
		graph[0][0] = 17;
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ;j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		changeFish(graph, 0);
		
		System.out.print(maxi);
	
		
	}
	
	static void copy(int comp1[][], int comp2[][]) {
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				comp2[i][j] = comp1[i][j];
			}
		}
	}
	
	static void changeFish(int graph[][], int result) {
		
//		HashMap<Integer, Node> map2 = new HashMap<>(map);
		int graph2[][] = new int[4][4];
		copy(graph, graph2);
		
		
		for(int i = 1 ; i <= 16 ; i++) {
			if(map.get(i) == null) continue;
			Node node = map.get(i);
			int dir = node.dir;
			
			for(int j = 0 ; j < 8 ; j++) {
				int row = node.row + r[dir];
				int col = node.col + c[dir];
				if(row < 0 || row >= 4 || col < 0 || col >= 4 || graph2[row][col] == 17) {
					dir++;
					if(dir > 7) {
						dir = 0;
					}
					continue;
				}
				
				if(graph2[row][col] != 0 && graph2[row][col] != 17) {
					node.dir = dir;
					Node no = map.get(graph2[row][col]);
					if(no == null) {
						System.out.println(row + " " + col);
						for(int k = 0 ; k < 4 ; k++) {
							for(int l = 0 ; l < 4 ;l++) {
								System.out.print(graph[k][l] + " ");
							}
							System.out.println();
						}
						System.out.println();
					}
					System.out.println(no);
					graph2[node.row][node.col] = no.num;
					graph2[row][col] = node.num;
					
					no.row = node.row;
					no.col = node.col;
					node.row = row;
					node.col = col;
					break;
				}
				
				if(graph2[row][col] == 0) {
					node.dir = dir;
					graph2[node.row][node.col] = 0;
					graph2[row][col] = node.num;
					node.row = row;
					node.col = col;
					break;
				}
				dir++;
				if(dir > 7) {
					dir = 0;
				}
				
				
			}
//			if(result ==0) {
//				for(int k = 0 ; k < 4 ; k++) {
//					for(int j = 0 ; j < 4 ;j++) {
//						System.out.print(graph[k][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
		}
		boolean fl = false;
//		if(result == 0) {
			for(int i = 0 ; i < 4 ; i++) {
				for(int j = 0 ; j < 4 ;j++) {
					int sub = graph2[i][j];
					int count = 0;
					if(sub == 0)continue;
					for(int k = 0 ; k < 4 ; k++) {
						for(int l = 0 ; l < 4 ; l++) {
							if(graph2[k][l] == sub) {
								count++;
							}
						}
					}
					if(count > 1) {
						fl = true;
					}
				}
			}
//		}
		if(fl) {
			System.out.println("start");
			for(int k = 0 ; k < 4 ; k++) {
				for(int j = 0 ; j < 4 ;j++) {
					System.out.print(graph2[k][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		int dir = shark.dir;
		int row = shark.row + r[dir];
		int col = shark.col + c[dir];
		int shark_row = shark.row;
		int shark_col = shark.col;
		boolean flag = true;
		while(row >= 0 && row < 4 && col >= 0 && col < 4) {
			if(graph2[row][col] > 0 && graph2[row][col] < 17) {
				flag = false;
				
				int num = graph2[row][col];
				if(num == 2) {
					System.out.println("here " + map.get(num) + " " + row + " " + col);
					System.out.println(graph2[row][col]);
					System.out.println(graph2[row-1][col]);
					System.out.println(graph2[row][col] == graph2[row-1][col]);
					for(int i = 0 ; i < 4 ; i++) {
						for(int j = 0 ; j < 4 ;j++) {
							System.out.print(graph2[i][j] + " ");
						}
						System.out.println();
					}
				}
				int no_dir = map.get(graph2[row][col]).dir;
				map.remove(num);
				graph2[shark_row][shark_col] = 0;
				graph2[row][col] = 17;
				shark.row = row;
				shark.col = col;
				shark.dir = no_dir;
//				if(num == 2) {
//					System.out.println("here " + map.get(num) + " " + row + " " + col);
//					System.out.println(graph2[row][col]);
//					for(int i = 0 ; i < 4 ; i++) {
//						for(int j = 0 ; j < 4 ;j++) {
//							System.out.print(graph2[i][j] + " ");
//						}
//						System.out.println();
//					}
//				}
				changeFish(graph2, result + num);
				map.put(num, new Node(num, row, col, no_dir));
//				if(num == 1) {
//					System.out.println(map.get(num) + " done");
//				}
				graph2[row][col] = num;
				graph2[shark_row][shark_col] = 17;
				shark.row = shark_row;
				shark.col = shark_col;
				shark.dir = dir;
			}
			row += r[dir];
			col += c[dir];
		}
		if(flag) {
			maxi = Math.max(maxi, result);
			return;
		}
		
		
	}
	
	static class Node{
		int num;
		int row;
		int col;
		int dir;
		public Node(int n, int r, int c, int d) {
			num = n;
			row = r;
			col = c;
			dir = d;
		}
	}

}
