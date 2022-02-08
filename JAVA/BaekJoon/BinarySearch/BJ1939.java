package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1939 {

	static int N;
	static int M;
	static int start;
	static int end;
	static ArrayList<Node> list[];
	static boolean visit[];
	static int lo = 0;
	static int hi;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i = 0 ; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
			hi = Math.max(hi, C);
		}
		st = new StringTokenizer(br.readLine(), " ");
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int mid = 0;
		int result = 0;
		while(lo <= hi) {
			mid = (lo + hi) / 2;
			if(bfs(mid)) {
				lo = mid + 1;
				result = mid;
			} else {
				hi = mid - 1;
			}
			
		}
		
		System.out.print(result);
		
	}
	
	static boolean bfs(int mid) {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[N+1];
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int loc =q.poll();
			
			for(int i = 0 ; i < list[loc].size() ; i++) {
				
				if(list[loc].get(i).weight >= mid && list[loc].get(i).dest == end) {
					return true;
				}
				
				if(list[loc].get(i).weight >= mid && !visit[list[loc].get(i).dest]) {
					visit[list[loc].get(i).dest] = true;
					q.add(list[loc].get(i).dest);
				}
			}
			
			
		}
		
		return false;
	}
	
	static class Node{
		int dest;
		int weight;
		
		public Node(int d, int w) {
			dest = d;
			weight = w;
			
		}
	}

}
