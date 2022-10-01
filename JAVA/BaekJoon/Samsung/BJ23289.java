package samsung;

import java.util.*;
import java.io.*;

public class BJ23289 {

	static int graph[][];
	static int R, C, K, W;
	static ArrayList<Air> airList = new ArrayList<>();
	static HashSet<String> set = new HashSet<>();
	static ArrayList<Air> checkList = new ArrayList<>();
	static int r[] = {0, -1, 0, 1};
	static int c[] = {1, 0, -1, 0};
	static int subGraph[][];
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = ps(st.nextToken());
		C = ps(st.nextToken());
		K = ps(st.nextToken());
		
		graph = new int[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j++) {
				int num = ps(st.nextToken());
				if(num != 0 && num != 5) {
					airList.add(new Air(i, j, num));
				}else if(num == 5) {
					checkList.add(new Air(i, j, num));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		W = ps(st.nextToken());
		
		
		for(int i = 0 ; i < W ; i++) {
			st = new StringTokenizer(br.readLine());
			String ro = String.valueOf(ps(st.nextToken())-1);
			String co = String.valueOf(ps(st.nextToken())-1);
			int num = ps(st.nextToken());
			if(num == 0) {
				set.add(ro + "," + co + "," + String.valueOf(Integer.parseInt(ro)-1) + "," + co);
				set.add(String.valueOf(Integer.parseInt(ro)-1) + "," + co + "," + ro + "," + co);
			}else {
				set.add(ro + "," + co + "," + ro + "," + String.valueOf(Integer.parseInt(co)+1));
				set.add(ro + "," + String.valueOf(Integer.parseInt(co)+1) + "," + ro + "," + co);
			}
		}
		int howMuch = 0;
		while(howMuch <= 100) {
			spread();
			calcTemp();
			minusEdge();
			howMuch++;
			if(checkK())break;
		}
		
		System.out.print(howMuch);
		
	}
	static boolean checkK() {
		for(int i = 0 ; i < checkList.size() ; i++) {
			Air air = checkList.get(i);
			int row = air.row;
			int col = air.col;
			
			if(graph[row][col] < K) {
				return false;
			}
		}
		return true;
	}
	
	static void minusEdge() {
		for(int i = 0 ; i < C-1 ; i++) {
			if(graph[0][i] > 0) {
				graph[0][i] -= 1;
			}
		}
		for(int i = 0 ; i < R-1 ; i++) {
			if(graph[i][C-1] > 0) {
				graph[i][C-1] -= 1;
			}
			
		}
		for(int i = C-1 ; i > 0 ; i--) {
			if(graph[R-1][i] > 0) {
				graph[R-1][i] -= 1;
			}
			
		}
		for(int i = R-1 ; i > 0 ; i--) {
			if(graph[i][0] > 0) {
				graph[i][0] -= 1;
			}
			
		}
	}
	
	static void calcTemp() {
		subGraph = new int[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				subGraph[i][j] += graph[i][j];
				if(graph[i][j] > 3) {
					for(int k = 0 ; k < 4 ; k++) {
						int ro = i + r[k];
						int co = j + c[k];
						if(ro < 0 || ro >= R || co < 0 || co >= C)continue;
						if(graph[i][j] <= graph[ro][co])continue;
						StringBuilder sb = new StringBuilder();
						sb.append(i).append(",").append(j).append(",").append(ro).append(",").append(co);
						if(!set.contains(sb.toString())) {
							int num = (graph[i][j] - graph[ro][co]) / 4; 
							subGraph[i][j] -= num;
							subGraph[ro][co] += num;
						}
					}
					
				}
			}
		}
		graph = subGraph;
	}
	
	static void spreadDown(Air air) {
		StringBuilder sb = new StringBuilder();
		if(air.row + 1 >= R)return;
		
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[R][C];
		q.add(new Node(air.row+1, air.col, 5));
		graph[air.row+1][air.col] += 5;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int row = node.row;
			int col = node.col;
			int num = node.num;
			if(num == 1 || row+1 >= R)continue;
			if(col-1 >= 0 && !visit[row+1][col-1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row).append(",").append(col-1);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row).append(",").append(col-1).append(",").append(row+1).append(",").append(col-1);
					if(!set.contains(sb.toString())) {
						graph[row+1][col-1] += num-1;
						visit[row+1][col-1] = true;
						q.add(new Node(row+1, col-1, num-1));
					}
				}
			}
			if(!visit[row+1][col]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row+1).append(",").append(col);
				if(!set.contains(sb.toString())) {
					graph[row+1][col] += num-1;
					visit[row+1][col] = true;
					q.add(new Node(row+1, col, num-1));
				}
			}
			if(col+1 < C && !visit[row+1][col+1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row).append(",").append(col+1);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row).append(",").append(col+1).append(",").append(row+1).append(",").append(col+1);
					if(!set.contains(sb.toString())) {
						graph[row+1][col+1] += num-1;
						visit[row+1][col+1] = true;
						q.add(new Node(row+1, col+1, num-1));
					}
				}
			}
			
			
		}	
	}
	
	
	static void spreadUp(Air air) {
		StringBuilder sb = new StringBuilder();
		if(air.row - 1 < 0)return;
		
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[R][C];
		q.add(new Node(air.row-1, air.col, 5));
		graph[air.row-1][air.col] += 5;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int row = node.row;
			int col = node.col;
			int num = node.num;
			if(num == 1 || row-1 < 0)continue;
			if(col-1 >= 0 && !visit[row-1][col-1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row).append(",").append(col-1);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row).append(",").append(col-1).append(",").append(row-1).append(",").append(col-1);
					if(!set.contains(sb.toString())) {
						graph[row-1][col-1] += num-1;
						visit[row-1][col-1] = true;
						q.add(new Node(row-1, col-1, num-1));
					}
				}
			}
			if(!visit[row-1][col]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row-1).append(",").append(col);
				if(!set.contains(sb.toString())) {
					graph[row-1][col] += num-1;
					visit[row-1][col] = true;
					q.add(new Node(row-1, col, num-1));
				}
			}
			if(col+1 < C && !visit[row-1][col+1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row).append(",").append(col+1);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row).append(",").append(col+1).append(",").append(row-1).append(",").append(col+1);
					if(!set.contains(sb.toString())) {
						graph[row-1][col+1] += num-1;
						visit[row-1][col+1] = true;
						q.add(new Node(row-1, col+1, num-1));
					}
				}
			}
			
			
		}	
	}
	
	static void spreadLeft(Air air) {
		StringBuilder sb = new StringBuilder();
		if(air.col - 1 < 0)return;
		
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[R][C];
		q.add(new Node(air.row, air.col-1, 5));
		graph[air.row][air.col-1] += 5;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int row = node.row;
			int col = node.col;
			int num = node.num;
			if(num == 1 || col-1 < 0)continue;
			if(row-1 >= 0 && !visit[row-1][col-1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row-1).append(",").append(col);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row-1).append(",").append(col).append(",").append(row-1).append(",").append(col-1);
					if(!set.contains(sb.toString())) {
						graph[row-1][col-1] += num-1;
						visit[row-1][col-1] = true;
						q.add(new Node(row-1, col-1, num-1));
					}
				}
			}
			if(!visit[row][col-1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row).append(",").append(col-1);
				if(!set.contains(sb.toString())) {
					graph[row][col-1] += num-1;
					visit[row][col-1] = true;
					q.add(new Node(row, col-1, num-1));
				}
			}
			if(row+1 < R && !visit[row+1][col-1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row+1).append(",").append(col);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row+1).append(",").append(col).append(",").append(row+1).append(",").append(col-1);
					if(!set.contains(sb.toString())) {
						graph[row+1][col-1] += num-1;
						visit[row+1][col-1] = true;
						q.add(new Node(row+1, col-1, num-1));
					}
				}
			}
			
			
		}	
	}
	
	static void spreadRight(Air air) {
		StringBuilder sb = new StringBuilder();
		if(air.col + 1 >= C)return;
		
		Queue<Node> q = new LinkedList<>();
		boolean visit[][] = new boolean[R][C];
		q.add(new Node(air.row, air.col+1, 5));
		graph[air.row][air.col+1] += 5;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int row = node.row;
			int col = node.col;
			int num = node.num;
			if(num == 1 || col+1 >= C)continue;
			if(row-1 >= 0 && !visit[row-1][col+1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row-1).append(",").append(col);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row-1).append(",").append(col).append(",").append(row-1).append(",").append(col+1);
					if(!set.contains(sb.toString())) {
						graph[row-1][col+1] += num-1;
						visit[row-1][col+1] = true;
						q.add(new Node(row-1, col+1, num-1));
					}
				}
			}
			if(!visit[row][col+1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row).append(",").append(col+1);
				if(!set.contains(sb.toString())) {
					graph[row][col+1] += num-1;
					visit[row][col+1] = true;
					q.add(new Node(row, col+1, num-1));
				}
			}
			if(row+1 < R && !visit[row+1][col+1]) {
				sb = new StringBuilder();
				sb.append(row).append(",").append(col).append(",").append(row+1).append(",").append(col);
				if(!set.contains(sb.toString())) {
					sb = new StringBuilder();
					sb.append(row+1).append(",").append(col).append(",").append(row+1).append(",").append(col+1);
					if(!set.contains(sb.toString())) {
						graph[row+1][col+1] += num-1;
						visit[row+1][col+1] = true;
						q.add(new Node(row+1, col+1, num-1));
					}
				}
			}
			
			
		}
		
		
	}
	
	static void spread() {
		for(int i = 0 ; i < airList.size() ; i++) {
			Air air = airList.get(i);
			if(air.num == 1) {
				spreadRight(air);
			}else if(air.num == 2) {
				spreadLeft(air);
			}else if(air.num == 3) {
				spreadUp(air);
			}else {
				spreadDown(air);
			}
		}
	}
	static class Node{
		int row, col, num;
		public Node(int r, int c, int n) {
			row = r;
			col = c;
			num = n;
		}
	}
	static class Air{
		int row, col, num;
		public Air(int r, int c, int n) {
			row = r;
			col = c;
			num = n;
		}
	}
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
