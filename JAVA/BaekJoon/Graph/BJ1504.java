package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1504 {

	static int N, E;
	static ArrayList<Node> list[];
	static int dist[];
	static int v1, v2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = ps(st.nextToken());
		E = ps(st.nextToken());
		list = new ArrayList[N+1];
		dist = new int[N+1];
		for(int i = 1; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = ps(st.nextToken());
			int b = ps(st.nextToken());
			int c = ps(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		v1 = ps(st.nextToken());
		v2 = ps(st.nextToken());
		Arrays.fill(dist, 9876543);
		dijkstra(1);
		int startToV1 = dist[v1];
		int startToV2 = dist[v2];
		Arrays.fill(dist, 9876543);
		dijkstra(v1);
		int v1ToV2 = dist[v2];
		Arrays.fill(dist, 9876543);
		dijkstra(N);
		int v2ToEnd = dist[v2];
		int v1ToEnd = dist[v1];
		if(startToV2 + v1ToV2 + v1ToEnd >= 9876543 && startToV1 + v1ToV2 + v2ToEnd >= 9876543) {
			System.out.print(-1);
		}else {
			if(startToV1 + v2ToEnd > startToV2 + v1ToEnd) {
				System.out.print(startToV2 + v1ToV2 + v1ToEnd);
			}else {
				System.out.print(startToV1 + v1ToV2 + v2ToEnd);
			}
		}
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.weight - n2.weight;
			}
		});
		boolean visit[] = new boolean[N+1];
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(visit[node.num])continue;
			visit[node.num] = true;
			
			for(Node nod : list[node.num]) {
				if(dist[nod.num] > dist[node.num] + nod.weight) {
					dist[nod.num] = dist[node.num] + nod.weight;
					pq.add(new Node(nod.num, dist[nod.num]));
				}
			}
		}
	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}
	static class Node{
		int num, weight;
		public Node(int n, int w) {
			num = n;
			weight = w;
		}
	}

}
