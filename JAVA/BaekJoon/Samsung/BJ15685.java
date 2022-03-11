package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15685 {

	static int N;
	static boolean visit[][];
	
	static int r[] = {0, -1, 0, 1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		visit = new boolean[101][101];
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			int d =Integer.parseInt(st.nextToken());
			int g =Integer.parseInt(st.nextToken());
			
			int row = y + r[d];
			int col = x + c[d];
			visit[y][x] = true;
			visit[row][col] = true;
			list.add(d);
			
			for(int j = 0 ; j < g ; j++) {
				int len = list.size();
				ArrayList<Integer> sub = new ArrayList<>();
				for(int k = len - 1 ; k >= 0 ; k--) {
					int adder = list.get(k) + 1;
					if(adder > 3) adder -= 4;
					sub.add(adder);
					list.add(adder);
				}
				
				for(int k = 0 ; k < sub.size() ; k++) {
					row += r[sub.get(k)];
					col += c[sub.get(k)];
					visit[row][col] = true;
				}
			}
			
		}
		
		int answer = check();
			
		System.out.print(answer);
		
		
	}
	
	static int check() {
		int result = 0;
		
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(visit[i][j] && visit[i+1][j] && visit[i][j+1] && visit[i+1][j+1])result++;
			}
		}
		
		return result;
	}
	
	

}
