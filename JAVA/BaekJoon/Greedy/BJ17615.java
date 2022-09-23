package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ17615 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
	
		int answer = Integer.MAX_VALUE;
		
		int redTotal = 0;
		int blueTotal = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == 'R') {
				redTotal++;
			}else {
				blueTotal++;
			}
		}
		
		if(str.charAt(0) == 'R') {
			int consec = 1;
			for(int i = 1 ; i < str.length() ; i++) {
				if(str.charAt(i) == 'R') {
					consec++;
				}else {
					break;
				}
			}
			answer = Math.min(answer, redTotal - consec);
			answer = Math.min(answer, blueTotal);
		}else {
			int consec = 1;
			for(int i = 1 ; i < str.length() ; i++) {
				if(str.charAt(i) == 'B') {
					consec++;
				}else {
					break;
				}
			}
			answer = Math.min(answer, blueTotal - consec);
			answer = Math.min(answer, redTotal);
		}
		
		if(str.charAt(str.length()-1) == 'R') {
			int consec = 1;
			for(int i = str.length()-2 ; i >= 0 ; i--) {
				if(str.charAt(i) == 'R') {
					consec++;
				}else {
					break;
				}
			}
			answer = Math.min(answer, redTotal - consec);
			answer = Math.min(answer, blueTotal);
		}else {
			int consec = 1;
			for(int i = str.length()-2 ; i >= 0 ; i--) {
				if(str.charAt(i) == 'B') {
					consec++;
				}else {
					break;
				}
			}
			answer = Math.min(answer, blueTotal - consec);
			answer = Math.min(answer, redTotal);
		}
		
		System.out.print(answer);
		
		
	
	}

}
