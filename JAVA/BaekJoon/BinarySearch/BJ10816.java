package BinarySearch;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10816 {

	static int card[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		card = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M ; i++) {
			int digit = Integer.parseInt(st.nextToken());
			sb.append((upperBound(digit) - lowerBound(digit))).append(" ");
		}
		
		System.out.print(sb.toString());
		
		
	}
	
	static public int lowerBound(int digit) {
		int lo = 0;
		int hi = card.length;
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(card[mid] >= digit) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
			
		}
		
		return lo;
	}
	
	static public int upperBound(int digit) {
		int lo = 0;
		int hi = card.length;
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(card[mid] > digit) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
			
		}		
		
		return lo;
	}

}
