package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17143 {

	static int R;
	static int C;
	static int M;
	static int graph[][];
	static ArrayList<Shark> list = new ArrayList<>();
	static int answer = 0;
	static int r[] = {0, -1, 1, 0, 0};
	static int c[] = {0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Shark(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Shark>() {
			@Override
			public int compare(Shark s1, Shark s2) {
				if(s1.col > s2.col) {
					return 1;
				} else if(s1.col == s2.col) {
					if(s1.row > s2.row) {
						return 1;
					} else if(s1.row == s2.row) {
						return s1.size - s2.size;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});
		
		for(int i = 0 ; i < C ; i++) {
			goFish(i);
		}
		
		System.out.print(answer);

	}
	
	static void goFish(int start) {
		
		for(int i = 0 ; i < list.size() ; i++) {
			if(start == list.get(i).col) {
				answer += list.get(i).size;
				list.remove(i);
				break;
			}
			
		}
		
		for(int i = 0 ; i < list.size() ; i++) {
			Shark shark = list.get(i);
			int dir = shark.dir;
			int speed = shark.speed;

			for(int j = 0 ; j < speed ; j++) {
				int row = shark.row + r[dir];
				int col = shark.col + c[dir];
				
				if(row < 0 || row >= R || col < 0 || col >= C) {
					if(dir == 1) {
						dir = 2;
						shark.dir = 2;
					}
					else if(dir == 2) {
						dir = 1;
						shark.dir =1;
					}
					else if(dir == 3) {
						dir = 4;
						shark.dir = 4;
					}
					else {
						dir = 3;
						shark.dir = 3;
					}
					
					row = shark.row + r[dir];
					col = shark.col + c[dir];
				}
				
				shark.row = row;
				shark.col = col;
			}
			
		}
		
		Collections.sort(list, new Comparator<Shark>() {
			@Override
			public int compare(Shark s1, Shark s2) {
				if(s1.col > s2.col) {
					return 1;
				} else if(s1.col == s2.col) {
					if(s1.row > s2.row) {
						return 1;
					} else if(s1.row == s2.row) {
						return s1.size - s2.size;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});
		
		int cur_row = -1;
		int cur_col = -1;
		int index = -1;
		for(int i = 0 ; i < list.size() ; i++) {
			int row = list.get(i).row;
			int col = list.get(i).col;
			if(cur_row == row && cur_col == col) {
				while(i < list.size() && cur_row == list.get(i).row && cur_col == list.get(i).col) {
					i++;
				}
				i--;
				
				int loop = i - index;
				for(int j = 0 ; j < loop ; j++) {
					list.remove(index);
				}
				i = index;
			}
			
			index = i;
			
			cur_row = row;
			cur_col = col;
		}
	}
	
	static class Shark{
		int row;
		int col;
		int speed;
		int dir;
		int size;
		
		public Shark(int row, int col, int speed, int dir, int size) {
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

}
