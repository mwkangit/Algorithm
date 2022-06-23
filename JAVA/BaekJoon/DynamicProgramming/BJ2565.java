package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BJ2565 {
	// re 0617
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Node> list = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Node(s,e));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.start - n2.start;
			}
		});
		
		int dp[][] = new int [N][2];
		dp[0][0] = 1;
		dp[0][1] = list.get(0).end;
		
		int result = 0;
		for(int i = 1 ; i < N ; i++) {
			Node node = list.get(i);
			for(int j = i-1 ; j >= 0 ; j--) {
				if(dp[j][0] < node.end) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1]);
//					if
				}
			}
		}
		
		
		
		
	}
	static class Node{
		int start, end;
		
		public Node(int s, int e) {
			start = s;
			end = e;
		}
	}

}
