package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15686timeout {

	static int N;
	static int M;
	static int graph[][];
	static ArrayList<Node> chick_list = new ArrayList<>();
	static ArrayList<Node> home_list = new ArrayList<>();
	static int r[] = {0, 1, 0, -1};
	static int c[] = {1, 0, -1, 0};
	static int mini = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				int sub = Integer.parseInt(st.nextToken());
				if(sub == 2) {
					chick_list.add(new Node(i, j));
					continue;
				} else if(sub == 1) {
					home_list.add(new Node(i, j));
				}
			}
		}
		
		dfs(0, new ArrayList<>(), 0);
		
		System.out.println(mini);
		
	}
	
	static void dfs(int index, ArrayList<Integer> sub_list, int d) {
		if(d == M) {
			int result = 0;
			for(int i = 0 ; i < home_list.size() ; i++) {
				int comp = Integer.MAX_VALUE;
				for(int j = 0 ; j < sub_list.size() ; j++) {
					Node home = home_list.get(i);
					Node chick = chick_list.get(sub_list.get(j));
					comp = Math.min(comp, Math.abs(home.row - chick.row) + Math.abs(home.col - chick.col));
				}
				result += comp;
			}
			
			mini = Math.min(mini, result);
			
		}else {
			for(int i = index ; i < chick_list.size() ; i++) {
				sub_list.add(i);
				dfs(i+1, sub_list, d+1);
				sub_list.remove(sub_list.size() - 1);
			}
		}
	}
	
	static class Node{
		int row;
		int col;
		
		public Node(int r, int c) {
			row = r;
			col = c;
		}
	}

}
