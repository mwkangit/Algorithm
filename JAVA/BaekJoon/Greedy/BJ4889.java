package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class BJ4889 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 1;
		while(true) {
			String str = br.readLine();
			if(str.charAt(0) == '-')break;
			Stack<Character> stk = new Stack<>();
			int result = 0;
			for(int i = 0  ; i < str.length() ; i++) {
				char c = str.charAt(i);
				if(c == '{') {
					stk.push(c);
				}else if(stk.isEmpty() && c == '}') {
					result++;
					stk.push('{');
				} else {
					stk.pop();
				}
			}
			result += stk.size() / 2;
			sb.append(count).append(". ").append(result).append("\n");
			count++;
		}
		
		System.out.print(sb);

	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
