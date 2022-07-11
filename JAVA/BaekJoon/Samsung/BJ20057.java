package samsung;

import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20057 {

	static int N;
	static int graph[][];
	static ArrayList<Integer> moveList = new ArrayList<>();
	static ArrayList<Integer> dir = new ArrayList<>();
	static int r[] = {0, 1, 0, -1};
	static int c[] = {-1, 0, 1, 0};
	
	static int r1[] = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
	static int c1[] = {0, -1, 0, 1, -2, -1, 0, 1, 0};
	static int r2[] = {0, 1, 0, -1, 2, 1, 0, -1, 0};
	static int c2[] = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
	static int r3[] = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
	static int c3[] = {0, 1, 0 ,-1, 2, 1, 0, -1, 0};
	static int r4[] = {0, -1, 0, 1, -2, -1, 0, 1, 0};
	static int c4[] = {2, 1, 1, 1, 0, -1, -1, -1, -2};
	
	static double percent[] = {0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02};
	
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = parse(st.nextToken());
		
		graph = new int[N][N];
		int dirCount = 1;
		for(int i = 0 ; i < N * 2 - 1 ; i++) {
			if(dirCount == 5) {
				dirCount = 1;
			}
			dir.add(dirCount++);
		}
		
		for(int i = 1 ; i < N ; i++) {
			if(i == N-1) {
				moveList.add(i);
				moveList.add(i);
				moveList.add(i);
			}else {
				moveList.add(i);
				moveList.add(i);
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = parse(st.nextToken());
			}
		}
		
		int currR = N / 2;
		int currC = N / 2;
		
		tornado(currR, currC);
		
		System.out.print(answer);
		
		
		
	}
	static void tornado(int currR, int currC) {
		
		for(int i = 0 ; i < moveList.size() ; i++) {
			
			int rr[];
			int cc[];
			if(dir.get(i) == 1) {
				rr = r1;
				cc = c1;
			}else if(dir.get(i) == 2) {
				rr = r2;
				cc = c2;
			}else if(dir.get(i) == 3) {
				rr = r3;
				cc = c3;
			}else {
				rr = r4;
				cc = c4;
			}
			
			for(int j = 0 ; j < moveList.get(i) ; j++) {
				int minus = 0;
				currR += r[dir.get(i)-1];
				currC += c[dir.get(i)-1];
				int sand = graph[currR][currC];
				for(int k = 0 ; k < 9 ; k++) {
					int ro = currR + rr[k];
					int co = currC + cc[k];
					int spread = (int)(sand * percent[k]);
					minus += spread; 
					if(ro < 0 || ro >= N || co <0 || co >= N) {
						answer += spread;
						continue;
					}
					graph[ro][co] += spread;
				}
				sand -= minus;
				int ro = currR + r[dir.get(i)-1];
				int co = currC + c[dir.get(i)-1];
				if(ro < 0 || ro >= N || co <0 || co >= N) {
					answer += sand;
					continue;
				
				}
				graph[ro][co] += sand;
				
			}
			
		}
		
	}
	
	static int parse(String str) {
		return Integer.parseInt(str);
	}

}
