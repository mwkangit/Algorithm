package BinarySearch;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ7453 {

	static int n;
	static int A[];
	static int B[];
	static int C[];
	static int D[];
	static int AB[];
	static int CD[];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		A = new int[n];
		B = new int[n];
		C = new int[n];
		D = new int[n];
		
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		Arrays.sort(D);
		
		AB = new int[n * n];
		CD = new int[n * n];
		
		int index = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				AB[index] = A[i] + B[j];
				CD[index++] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		
		index--;
		long answer = 0;
		for(int i = 0 ; i < n*n ;) {
			if(index < 0)break;
			
			
			int sum = AB[i] + CD[index];
			int AB_count = 0;
			int CD_count = 0;
			
			if(sum == 0) {
				int comp = AB[i];
				while(i < n*n && AB[i] == comp) {
					AB_count++;
					i++;
				}
				comp = CD[index];
				while(index >= 0 && CD[index] == comp) {
					CD_count++;
					index--;
				}
				
				answer += (long)AB_count * (long)CD_count;
			} else if(sum < 0) {
				i++;
			} else {
				index--;
			}
		}
		
		System.out.print(answer);		
	
	}

}
