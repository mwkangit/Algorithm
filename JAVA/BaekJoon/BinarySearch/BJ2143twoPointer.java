package BinarySearch;

import java.io.*;
import java.util.*;

public class BJ2143twoPointer {
	
	static int T;
	static int n, m;
	static int[] A, B;
	static List<Integer> listA = new ArrayList<>();
	static List<Integer> listB = new ArrayList<>();
	static long answer = 0;


	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		n = Integer.parseInt(br.readLine());
		A = new int[n];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(sarr[i]);

		m = Integer.parseInt(br.readLine());
		B = new int[m];
		sarr = br.readLine().split(" ");
		for (int i = 0; i < m; i++)
			B[i] = Integer.parseInt(sarr[i]);

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				listA.add(sum);
			}
		}
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				listB.add(sum);
			}
		}

		Collections.sort(listA);
		Collections.sort(listB);
		
		twoPointer();

		System.out.print(answer);

	}
	
	static void twoPointer() {
		int lo = 0;
		int hi = listB.size()-1;
		while(lo < listA.size() && hi >= 0) {
			int compA = listA.get(lo);
			int compB = listB.get(hi);
			int sum = compA + compB;
			
			
			if(sum == T) { 
				long A_count = 0;
				long B_count = 0;
				while(lo < listA.size() && listA.get(lo) == compA) {
					A_count++;
					lo++;
				}
				
				while(hi >= 0 && listB.get(hi) == compB) {
					B_count++;
					hi--;
				}
				answer += A_count * B_count;
			} else if(sum < T) {
				lo++;
			} else {
				hi--;
			}
			
			
		}
		
	}

}
