package BinarySearch;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2470 {

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
		for(int i = 0 ; i < N ; i++) {
			comp(i);
		}
		
		Arrays.sort(answer);
		
		System.out.print(answer[0] + " " + answer[1]);
		
		
	}
	
	static void comp(int index) {
		int lo = 0;
		int hi = liq.length;
		int mid;
		
		while(lo < hi) {
			mid = (hi+lo) / 2;
			int sub = Math.abs(liq[index] + liq[mid]);
			if(sub >= mini) {
				hi = mid;
			} else {
				lo = mid+1;
				answer[0] = liq[index];
				answer[1] = liq[mid];
				mini = sub;
			}
			
		}
		
	}

}
