package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1052 {
	// re0729
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0 ; i < N ; i++) {
			list.add(1);
		}
		int answer = 0;
		
		while(true) {
			int num = N;
			int count = 0;
			while(num != 0) {
				if(num % 2 == 1) {
					count++;
				}
				num /= 2;
			}
			
			if(count <= K)break;
			
			N++;
			answer++;
			
		}
		System.out.print(answer);
		
		
	}

}
