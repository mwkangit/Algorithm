package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17822 {

	static int N, M, T;
	static char list[][];
	static Rotate com[];
	static long answer = 0;
	static double sum = 0;
	static int count = 0;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		list = new char[N+1][M];
		com = new Rotate[T];
		
		
		for(int i = 1 ; i < N+1 ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				int sub1 = Integer.parseInt(st.nextToken());
				char sub = (char)(sub1 + '0');
				list[i][j] = sub;
			}
		}
		int a = 170;
		char b = (char)(a + '0');
		System.out.print(b);
		
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			com[i] = new Rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0 ; i < T ; i++) {
			turn(com[i]);
		}
		
		count();
		
		
		System.out.print(answer);
		
		
	}
	static void count() {
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(list[i][j] != 'x') {
					answer += (list[i][j] - '0');
				}
			}
		}
	}
	
	static void copy(char[][] sub){
		
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sub[i][j] = list[i][j];
			}
		}
		
		
		
		
	}
	
	static void copy_list(char[][] sub) {
		for(int i = 1 ; i < N + 1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				list[i][j] = sub[i][j];
			}
		}
	}
	
	static void update_sum() {
		sum = 0;
		count = 0;
		for(int i = 1 ; i < N + 1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(list[i][j] != 'x') {
					sum += (list[i][j] - '0');
					count++;
				}
			}
		}
		if(count != 0) sum /= (double)count;
	}
	
	static void check() {
		char[][] copy = new char[N+1][M];
		copy(copy);
		update_sum();
		boolean flag = true;
				
		for(int i = 1 ; i < N + 1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				char comp = list[i][j];
				if(comp == 'x') continue;
				int left = j + 1;
				int right = j - 1;
				if(left >= M) {
					left = 0;
				}
				if(right < 0) {
					right = M - 1;
				}
				
				if(list[i][left] == comp) {
					copy[i][j] = 'x';
					flag = false;
				}else if(list[i][right] == comp) {
					copy[i][j] = 'x';
					flag = false;
				}else if(i + 1 <= N && list[i+1][j] == comp) {
					copy[i][j] = 'x';
					flag = false;
				}else if(i - 1 > 0 && list[i-1][j] == comp) {
					copy[i][j] = 'x';
					flag = false;
				}
				
				
			}
		}
		if(flag) {
			for(int i = 1 ; i < N+1 ; i++) {
				for(int j = 0 ; j < M ; j++) {
					
					if(list[i][j] == '0') {
						list[i][j] = 'x';
					} else if(list[i][j] != 'x' && sum != (double)0) {
						int comp = list[i][j] - '0';
						if((double)comp > sum) {
							copy[i][j] = (char)(comp-1 + '0');
						} else if((double)comp < sum) {
							copy[i][j] = (char)(comp+1 + '0');
						}
					}
				}
			}
		}
		
		
		
		
		copy_list(copy);
		
	}
	
	static void turn(Rotate rot) {
		int x = rot.x;
		int d = rot.d;
		int k = rot.k;
		int temp = x;
		while(x <= N) {
			if(d == 1) {
				for(int i = 0 ; i < k ; i++) {
					char sub = list[x][0];
					for(int j = 0 ; j < M-1 ; j++) {
						list[x][j] = list[x][j+1];
					}
					list[x][M-1] = sub;
				}
			} else {
				for(int i = 0 ; i < k ; i++) {
					char sub = list[x][M-1];
					for(int j = M-1 ; j > 0 ; j--) {
						list[x][j] = list[x][j-1];
					}
					list[x][0] = sub;
				}
			}
			x += temp;
			
		}
		
		
		check();
		
	}
	
	static class Rotate{
		int x;
		int d;
		int k;
		public Rotate(int a, int b, int c){
			x = a;
			d = b;
			k = c;
		}
	}

}
