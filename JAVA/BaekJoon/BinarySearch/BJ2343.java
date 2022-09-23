package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2343 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = ps(st.nextToken());
		int M = ps(st.nextToken());
		
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		long total = 0;
		int maxi = 0;
		for(int i = 0 ; i < N ; i++) {
			int num = ps(st.nextToken());
			arr[i] = num;
			total += num;
			maxi = Math.max(maxi, num);
		}
		
		long lo = maxi;
		long hi = total;
		while(lo <= hi) {
			long mid = (lo + hi) / 2;
			long cnt = 1;
			long sum = 0;
			for(int i = 0 ; i < arr.length ; i++) {
				if(sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}
			
			
			if(cnt > M) {
				lo = mid + 1;
				
			}else {
				hi = mid - 1;
			}
		}
		System.out.println(lo);
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
