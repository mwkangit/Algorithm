package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ23291 {

	static int N, K;
	static int minNum = Integer.MAX_VALUE;
	static int maxNum = Integer.MIN_VALUE;
	static int graph[][];
	static int level[];
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = ps(st.nextToken());
		K = ps(st.nextToken());
		graph = new int[N][N];
		level = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int num = ps(st.nextToken());
			graph[0][i] = num;
			minNum = Math.min(minNum, num);
			maxNum = Math.max(maxNum, num);
		}

		int answer = 0;
		while(maxNum - minNum > K) {
			answer++;
			addFish();
			seqFold();
			relocateFish();
			straighten();
			halfFold();
			relocateFish();
			straighten();
			updateMinMax();
		}
			System.out.print(answer);

	}
	static void updateMinMax() {
		minNum = Integer.MAX_VALUE;
		maxNum = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			minNum = Math.min(minNum, graph[0][i]);
			maxNum = Math.max(maxNum, graph[0][i]);
		}
	}
	static void halfFold() {
		int half = N/2;
		int index = 0;
		Arrays.fill(level, 0);
		for(int i = 0 ; i < half ; i++) {
			graph[1][N-i-1] = graph[0][index];
			graph[0][index] = 0;
			index++;
		}

		half = N/4;
		int lev1 = 1;
		int lev2 = 2;
		for(int i = 0 ; i < 2 ; i++) {
			int subIndex = index;
			for(int j = 0 ; j < half ; j++) {
				graph[lev2][N-j-1] = graph[lev1][subIndex];
				graph[lev1][subIndex] = 0;
				subIndex++;
			}
			lev2++;
			lev1--;
		}
		for(int i = N/2 + N/4 ; i < N ; i++) {
			level[i] = 4;
		}

		
	}
	static void straighten() {
		int index = 0;

		for(int i = 0 ; i < N ; i++) {
			if(level[i] > 1) {
				for(int j = 0 ; j < level[i] ; j++) {
					graph[0][index] = graph[j][i];
					graph[j][i] = 0;
					index++;
				}
			}
		}
	}
	static void relocateFish() {
		int subGraph[][] = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(graph[i][j] != 0) {
					for(int k = 0 ; k < 4 ; k++) {
						int ro = i + r[k];
						int co = j + c[k];
						
						if(ro < 0 || ro >= N || co < 0 || co >= N || graph[ro][co] == 0 || graph[i][j] <= graph[ro][co])continue;
			
						int minus = Math.abs(graph[i][j] - graph[ro][co]) / 5;
						if(minus > 0) {
							subGraph[i][j] -= minus;
							subGraph[ro][co] += minus;
							
						}
						
					}
				}
			}
		}
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] += subGraph[i][j];
			}
		}
	}
	static void seqFold() {
		graph[1][1] = graph[0][0];
		graph[0][0] = 0;
		Arrays.fill(level, 1);
		level[0] = 0;
		level[1] = 2;
		boolean flag = false;

		int lev = 2;
		int counter = 0;
		while(true) {
			int count = 0;
			if(counter == 1) {
				counter = -1;
				lev++;
			}
			counter++;
			for(int i = N-1 ; i >= 0 ; i--) {
				if(level[i] == 0)break;
				if(level[i] > 1) {
					if(i + level[i] >= N) {
						flag = true;
						break;
					}else {
						count++;
						int subIndex = level[i];
						for(int j = 0 ; j < subIndex ; j++) {
							graph[count][i+subIndex-j + count-1] = graph[subIndex-j-1][i];
							graph[subIndex-j-1][i] = 0;
							level[i+subIndex-j+count-1] = lev;
						}
						level[i] = 0;
					}
				}
				
			}
			if(flag)break;
		}
	}
	static void addFish() {
		for(int i = 0 ; i < N ; i++) {
			if(graph[0][i] == minNum) {
				graph[0][i]++;
			}
		}
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
