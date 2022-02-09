package BinarySearch;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2110 {

	static int num[];
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		
		// hi 에 +1 안하면 이분 탐색 루프로 들어가지를 못한다
		int lo = 1;
		int hi = num[N-1] - num[0] + 1;
		
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(search(mid) < C) {
				hi = mid;
			} else{
				lo = mid + 1;
			}
		}
		
		System.out.print(lo-1);

	}
	
	static int search(int mid) {
		
		int count = 1;
		int last = num[0];
		
		for(int i = 1 ; i < num.length ; i++) {
			if(last + mid <= num[i]) {
				count++;
				last = num[i];
			}
		}
		
		return count;
	}
	

}
