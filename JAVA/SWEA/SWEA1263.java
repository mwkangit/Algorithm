package swExpertAcademy;

import java.util.*;
import java.io.*;

public class SWEA1263 {

	static int N;
	static ArrayList<Integer> list[];
	static int answer;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=ps(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = ps(st.nextToken());
			list = new ArrayList[N];
			
			answer = Integer.MAX_VALUE;
			for(int i = 0 ; i < N ; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					int num = ps(st.nextToken());
					if(num == 1) {
						list[i].add(j);
					}
				}
			}		
			for(int i = 0 ; i < N ; i++) {
				bfs(i);
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
			
		}
		
		System.out.print(sb);
	}
	static void bfs(int start) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		boolean visit[] = new boolean[N];
		visit[start] = true;
		
		int result = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0 ; i < list[node.num].size() ; i++) {
				int num = list[node.num].get(i);
				
				if(visit[num])continue;
				visit[num] = true;
				
				q.add(new Node(num, node.count+1));
				result += node.count+1;
				
				if(result >= answer)return;
			}
		}
		
		answer = Math.min(answer, result);
		
		
	}
	static class Node{
		int num, count;
		public Node(int n, int c) {
			num = n;
			count = c;
		}
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
