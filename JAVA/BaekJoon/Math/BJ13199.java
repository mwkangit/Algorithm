package swmaestro;

import java.util.*;
import java.io.*;


public class BJ13199 {

	static int T;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		for(int loop = 0 ; loop < T ; loop++) {
			int arr[] = new int[2];
			int cou[] = new int[2];
			long result[] = new long[2];
			st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr[0] = M;
			arr[1] = M;
			
			while(true) {
				while(cou[0] >= F) {
					cou[0] = cou[0] - F + C;
					result[0]++;
				}
				while(cou[1] >= F) {
					cou[1] -=  F;
					result[1]++;
				}
				if(arr[0] >= P) {
					arr[0] -= P;
					result[0]++;
					cou[0] += C;
				}
				if(arr[1] >= P) {
					arr[1] -= P;
					result[1]++;
					cou[1] += C;
				}
				if(arr[0] < P && arr[1] < P) {
					break;
				}
				
			}
			
			sb.append(result[0] - result[1]).append("\n");
			
			
		}
		System.out.print(sb);
		
	}

}
