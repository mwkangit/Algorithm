package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ12100 {

	static int N;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = ps(st.nextToken());
		int graph[][] = new int[N][N];
		
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = ps(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			System.out.println("start" + i + "\n\n");
			dfs(i, 0, graph);
		}
		System.out.print(answer);
		
	}
	static void dfs(int curr, int count, int[][] graph) {
		if(count == 5) {
			answer = Math.max(answer, calcTotal(graph));
			return;
		}
		
//		printG(graph);
		
		if(curr == 0) {
			int subGraph[][] = new int[N][N];
			copy(graph, subGraph);
			up(subGraph);
			for(int i = 0 ; i < 4 ; i++) {
				dfs(i, count+1, subGraph);
			}
		}else if(curr == 1) {
			int subGraph[][] = new int[N][N];
			copy(graph, subGraph);
			left(subGraph);
			for(int i = 0 ; i < 4 ; i++) {
				dfs(i, count+1, subGraph);
			}
			
		}else if(curr == 2) {
			int subGraph[][] = new int[N][N];
			copy(graph, subGraph);
			down(subGraph);
			for(int i = 0 ; i < 4 ; i++) {
				dfs(i, count+1, subGraph);
			}
		}else {
			int subGraph[][] = new int[N][N];
			copy(graph, subGraph);
			right(subGraph);
			for(int i = 0 ; i < 4 ; i++) {
				dfs(i, count+1, subGraph);
			}
		}
		
	}
	static int calcTotal(int graph[][]) {
		int total = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				total = Math.max(total, graph[i][j]);
			}
		}
		return total;
	}
	static void right(int graph[][]) {
		for(int i = 0 ; i < N ; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int curr = -1;
			for(int j = N-1 ; j >= 0 ; j--) {
				if(graph[i][j] == 0)continue;
				if(graph[i][j] != curr) {
					if(curr != -1) {
						list.add(curr);
					}
					curr = graph[i][j];
				}else {
					list.add(curr*2);
					curr = -1;
				}
			}
			if(curr != -1)list.add(curr);
			int index = N-1;
			for(int j = 0 ; j < list.size() ; j++) {
				graph[i][index--] = list.get(j);
			}
			for(int j = index ; j >= 0 ; j--) {
				graph[i][j] = 0;
			}
		}
	}
	static void down(int graph[][]) {
		for(int j = 0 ; j < N ; j++) {
			ArrayList<Integer> list = new ArrayList<>();
			int curr = -1;
			for(int i = N-1 ; i >= 0 ; i--) {
				if(graph[i][j] == 0)continue;
				if(graph[i][j] != curr) {
					if(curr != -1) {
						list.add(curr);
					}
					curr = graph[i][j];
				}else {
					list.add(curr*2);
					curr = -1;
				}
			}
			if(curr != -1)list.add(curr);
			int index = N-1;
			for(int i = 0 ; i < list.size() ; i++) {
				graph[index--][j] = list.get(i);
			}
			for(int i = index ; i >= 0 ; i--) {
				graph[i][j] = 0;
			}
		}
	}
	static void left(int graph[][]) {
		
		for(int i = 0 ; i < N ; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int curr = -1;
			for(int j = 0 ; j < N ; j++) {
				if(graph[i][j] == 0)continue;
				if(graph[i][j] != curr) {
					if(curr != -1) {
						list.add(curr);
					}
					curr = graph[i][j];
				}else {
					list.add(curr*2);
					curr = -1;
				}
			}
			if(curr != -1)list.add(curr);
			for(int j = 0 ; j < list.size() ; j++) {
				graph[i][j] = list.get(j);
			}
			for(int j = list.size() ; j < N ; j++) {
				graph[i][j] = 0;
			}
		}
	}
	static void up(int graph[][]) {
		for(int j = 0 ; j < N ; j++) {
			ArrayList<Integer> list = new ArrayList<>();
			int curr = -1;
			for(int i = 0 ; i < N ; i++) {
				if(graph[i][j] == 0)continue;
				if(graph[i][j] != curr) {
					if(curr != -1) {
						list.add(curr);
					}
					curr = graph[i][j];
				}else {
					list.add(curr*2);
					curr = -1;
				}
			}
			if(curr != -1)list.add(curr);
			for(int i = 0 ; i < list.size() ; i++) {
				graph[i][j] = list.get(i);
			}
			for(int i = list.size() ; i < N ; i++) {
				graph[i][j] = 0;
			}
		}
	}
	static void copy(int graph1[][], int graph2[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				graph2[i][j] = graph1[i][j];
			}
		}
	}

	static void printG(int graph[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int ps(String str) {
		return Integer.parseInt(str);
		
	}

}

//3
//0 0 0
//1 0 3
//0 2 0

//3
//1 0 3
//1 2 3
//0 2 3

//3
//1 1 0
//0 2 2
//3 3 3

//4
//2 2 4 16
//0 0 0 0
//0 0 0 0
//0 0 0 0
