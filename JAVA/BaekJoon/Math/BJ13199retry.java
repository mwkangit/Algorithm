package swmaestro;

import java.util.*;
import java.io.*;

public class BJ13199retry {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int loop = 0 ; loop < T ; loop++) {
			st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int sang = M / P;
			int doo = M / P;
			int sameCou = (M / P) * C;
			doo += (sameCou / F);
			while(sameCou >= F) {
				sang += sameCou / F;
				sameCou = (sameCou / F) * C + sameCou % F;
			}
			
			sb.append(sang - doo).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
		
	}

}
