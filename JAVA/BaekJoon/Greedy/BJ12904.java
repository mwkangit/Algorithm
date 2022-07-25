package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12904 {

	static StringBuilder S, T;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = new StringBuilder(br.readLine());
		T = new StringBuilder(br.readLine());
		
		
		while(S.length() < T.length()) {
			if(T.charAt(T.length()-1) == 'A') {
				T.deleteCharAt(T.length()-1);
			}else if(T.charAt(T.length()-1) == 'B') {
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		if(S.toString().equals(T.toString())) {
			System.out.print(1);
		}else {
			System.out.print(0);
		}
		
		
	}
	
	

}
