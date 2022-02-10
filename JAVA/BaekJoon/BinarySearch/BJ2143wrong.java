package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2143wrong {

	static int T;
	static int n;
	static int m;
	static int A[];
	static int B[];
	static int AB[];
	static int all[];
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		A = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		B = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < m ; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		AB = new int[n*m];
		int index = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				int sub = A[i]+B[j];
				
				upperBinary(i);
				
				
				if(sub > T) continue;
				AB[index++] = sub;
			}
		}
		
		all = new int[n+m];
		for(int i = 0 ; i < n ; i++) {
			all[i] = A[i];
		}
		for(int i = n ; i < n+m ; i++) {
			all[i] = B[i-n];
		}
		
		Arrays.sort(AB);
		Arrays.sort(all);
		
		binary();

		System.out.print(answer);
		
		
		
	}
	
	static void upperBinary(int index) {

	}
	
	static int upper(int comp) {
		int lo = 0;
		int hi = all.length-1;
		int result = hi;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(all[mid] > comp) {
				hi = mid -1;
				result = mid;
			} else{
				lo = mid + 1;
			}
		}
		
		return result;
		
		
	}
	
	static int lower(int comp) {
		int lo = 0;
		int hi = all.length-1;
		int result = hi;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(all[mid] >= comp) {
				hi = mid -1;
				result = mid;
			} else{
				lo = mid + 1;
			}
		}
		
		return result;
		
		
	}
	
	static void binary() {
		for(int i = 0 ; i < AB.length ;) {
			int sum = AB[i];
			
			int AB_count = 0;
			while(i < AB.length && AB[i] == sum) {
				AB_count++;
				i++;
			}	
			
			if(sum == T) {
				answer += AB_count;
				continue;
			}
			
			int comp = T - sum;
			
			int left = lower(comp);
			int right = upper(comp);
			
			answer += AB_count * (right - left);
			
		}
	}

}
