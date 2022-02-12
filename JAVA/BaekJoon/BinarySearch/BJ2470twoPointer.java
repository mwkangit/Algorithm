package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470twoPointer {
	
	static int N;
	static int liq[];
	static int mini = Integer.MAX_VALUE;
	static int answer[];

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		liq = new int[N];
		answer = new int[2];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liq);
		
		search();

		System.out.print(answer[0] + " " + answer[1]);
		
	}
	
	static void search() {
		int lo = 0;
		int hi = N-1;
		
		while(lo < hi) {
			int sum = liq[lo] + liq[hi];
			if(Math.abs(sum) < mini) {
				answer[0] = liq[lo];
				answer[1] = liq[hi];
				mini = Math.abs(sum);
			}
			
			if(sum > 0) {
				hi--;
			} else {
				lo++;
			}
		}
		
		
	}

}
