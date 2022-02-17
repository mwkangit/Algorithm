package DynamicProgramming;

import java.util.*;
import java.io.*;

public class BJ1912 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int num[] = new int[str.length];
		
		for(int i = 0 ; i < str.length ; i++) {
			num[i] = Integer.parseInt(str[i]);
		}
		
		int result[] = new int[num.length];
		result[0] = num[0];
		int maxi = num[0];
		
		for(int i = 1 ; i < num.length ; i++) {
			if(num[i] > result[i-1] + num[i]) {
				result[i] = num[i];
			} else {
				result[i] = num[i] + result[i-1];
			}
			maxi = Math.max(maxi, result[i]);
		}
		
		for(int i = 0 ; i < result.length ; i++) {
			System.out.print(result[i] + " ");
		}
		
		bw.write(String.valueOf(maxi));
		bw.flush();
		
		
		bw.close();
		br.close();
		
		
		
	}

}
