package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class BJ16637 {

	static int N;
	static String str;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		
		dfs(new ArrayList<>(), 1);
		
		
		
		System.out.print(answer);

	}
	static void dfs(ArrayList<Integer> first, int curr) {
		
		LinkedList<Character> list = new LinkedList<>();
		for(int i = 0 ; i < str.length() ; i++) {
			list.add(str.charAt(i));
		}
		for(int i = first.size()-1 ; i >= 0 ; i--) {
			int index = first.get(i);
			int val = op(ps(list.get(index-1)), ps(list.get(index+1)), list.get(index));
			list.remove(index+1);
			list.remove(index);
			list.remove(index-1);

			list.add(index-1, (char)(val+'0'));

		}
		
		int num = ps(list.get(0));
		for(int i = 1 ; i < list.size() ; i+=2) {
			num = op(num, ps(list.get(i+1)), list.get(i));

		}
		
		answer = Math.max(answer, num);
		
		
		
		for(int i = curr ; i < str.length() ; i+=2) {
			first.add(i);
			dfs(first, i+4);
			first.remove(first.size()-1);
		}
	}
	static int op(int left, int right, char op){
		if(op == '+') {
			return left + right;
		} else if(op == '-') {
			return left - right;
		}else {
			return left * right;
		}
		
	}
	static int ps(char c) {
		return c - '0';
	}

}
