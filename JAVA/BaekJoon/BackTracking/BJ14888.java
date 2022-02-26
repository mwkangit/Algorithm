package BackTracking;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ14888 {

	static int A[];
	static int op[];
	static char shape[] = {'+', '-', '*', '/'};
	static int maxi = -1000000000;
	static int mini = 1000000000;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String in1[] = br.readLine().split(" ");
		String in2[] = br.readLine().split(" ");
		
		A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = Integer.parseInt(in1[i]);
		}
		op = new int[4];
		op[0] = Integer.parseInt(in2[0]);
		op[1] = Integer.parseInt(in2[1]);
		op[2] = Integer.parseInt(in2[2]);
		op[3] = Integer.parseInt(in2[3]);
		
		dfs(0, "");
		
		System.out.println(maxi);
		System.out.println(mini);
		
	}
	
	static public void dfs(int d, String str) {
		if(d == A.length - 1) {
			int result = A[0];
			int index = 1;
			for(int i = 0 ; i < A.length-1 ; i++) {
				if(str.charAt(i) == '+') {
					result += A[index++];
				}else if(str.charAt(i) == '-') {
					result -= A[index++];
				}else if(str.charAt(i) == '*') {
					result *= A[index++];
				}else if(str.charAt(i) == '/') {
					result /= A[index++];
				}
			}
			maxi = Math.max(maxi, result);
			mini = Math.min(mini, result);
		} else {
			for(int i = 0 ; i < 4 ; i++) {
				if(op[i] != 0) {
					op[i]--;
					dfs(d+1, str+ shape[i]);
					op[i]++;
				}
			}
		}
	}

}
