package swExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class SWEA1798 {

	static int N, M;
	static int graph[][];
	static Node airport;
	static ArrayList<Node> points;
	static ArrayList<Node> hotels;
	static boolean visitP[];
	static int answer;
	static LinkedList<Integer> result;
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T;
		T=ps(st.nextToken());
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = ps(st.nextToken());
			M = ps(st.nextToken());
			graph = new int[N+1][N+1];
			answer = 0;
			points = new ArrayList<>();
			hotels = new ArrayList<>();
			result = new LinkedList<>();
			
			for(int i = 1 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = i+1 ; j <= N ; j++) {
					int num = ps(st.nextToken());
					graph[i][j] = num;
					graph[j][i] = num;
				}
			}
			for(int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				if(c == 'A') {
					airport = new Node(0, 0, i);
				}else if(c == 'P') {
					int time = ps(st.nextToken());
					int well = ps(st.nextToken());
					points.add(new Node(time, well, i));
				}else {
					hotels.add(new Node(0, 0, i));
				}
			}
			visitP = new boolean[points.size()];
			
			LinkedList<Integer> list = new LinkedList<>();
			dfs(airport.index, 0, 0, 1, 0, list);
			
			sb.append("#").append(test_case).append(" ").append(answer);
			if(result.size() != 0) {
				for(int i = 1 ; i < result.size() ; i++) {
					sb.append(" ").append(result.get(i));
				}
				sb.append(" ").append(airport.index);
			}
			sb.append("\n");
//			for(int i = 0 ; i < points.size() ; i++) {
//				System.out.print(points.get(i).index + " ");
//			}
//			System.out.println();
//			for(int i = 0 ; i < hotels.size() ; i++) {
//				System.out.print(hotels.get(i).index + " ");
//			}
			
		}
		System.out.print(sb);
	}
	static boolean dfs(int start, int wells, int total, int day, int time, LinkedList<Integer> list) { 
		if(time > 540) {
			return false;
		}
		list.add(start);
		if(day == M) {
			boolean flag2 = true;
			for(int i = 0 ; i < points.size() ; i++) {
				if(!visitP[i]) {
					visitP[i] = true;
					boolean flag = dfs(points.get(i).index, wells + points.get(i).well, total, day, time + graph[start][points.get(i).index] + points.get(i).time, list);
					visitP[i] = false;
					if(!flag) {
						if(flag2) {
							int ti = time + graph[start][airport.index];
							if(ti > 540)continue;
							else {
//								if(list.get(3) == 9 && list.get(1) == 2) {
//									System.out.println("here" + " " + list);
//									System.out.println("total : " + (total+wells));
//								}
								if(answer < total+wells) {
									answer = total + wells;
									result = new LinkedList<>();
									for(int k = 0 ; k < list.size() ; k++) {
										result.add(list.get(k));
									}
								}
							}
							flag2 = false;
						}
						
					}
				}
			}
		}else {
			boolean flag2 = true;
			for(int i = 0 ; i < points.size() ; i++) {
				if(!visitP[i]) {
					visitP[i] = true;
					boolean flag = dfs(points.get(i).index, wells + points.get(i).well, total, day, time + graph[start][points.get(i).index] + points.get(i).time, list);
					visitP[i] = false;
					if(!flag) {
						if(flag2) {
							for(int j = 0 ; j < hotels.size() ; j++) {
								int ti = time + graph[start][hotels.get(j).index];
								if(ti > 540)continue;
								else {
									dfs(hotels.get(j).index, 0, total+wells, day+1, 0, list);
								}
							}
							flag2 = false;
						}
					}
				}
			}
		}
		
		list.remove(list.size()-1);
		
		
		
		
		
		return true;
		
	}
	static class Node{
		int time;
		int well;
		int index;
		public Node(int t, int w, int i) {
			time = t;
			well = w;
			index = i;
		}
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
