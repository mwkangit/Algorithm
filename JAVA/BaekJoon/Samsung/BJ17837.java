package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BJ17837 {

	static int N, K;
	static int graph[][];
	static int chess[][];
	static HashMap<Integer, Node> map = new HashMap<>();
	static int r[] = {0, 0, -1, 1};
	static int c[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		chess = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken()) + 10;
			}
		}
		int index = 1;
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ro = Integer.parseInt(st.nextToken())-1;
			int co = Integer.parseInt(st.nextToken())-1;
			int di = Integer.parseInt(st.nextToken())-1;
			map.put(index, new Node(index, ro, co, di));
			chess[ro][co] = index;
			index++;
			
		}
		index = 1;
		boolean flag = true;
		int count = 0;
		int a = 1;
		while(a == 1) {
			
			Node node = map.get(index);
			int row = node.row + r[node.dir];
			int col = node.col + c[node.dir];
			int dir = node.dir;
//			if(index == 4) {
//				Node no = map.get(4);
//				if(no.row == 2 && no.col == 3) {
//					System.out.println(index);
//				
//				System.out.println(no.row + " " + no.col + " " + no.dir + " " + no.above.num);
//			
//				}
//			}
			
			if(row < 0 || row >= N || col < 0 || col >= N || graph[row][col] == 12) {

//				System.out.println(node.num);
				blue(node, row, col, dir);
			} else if(graph[row][col] == 11) {

//				System.out.println(node.num);
				red(node, row, col);
			} else {
				white(node, row, col);
//				System.out.println(node.num);
			}
			
			if(index + 1 > K) {
				count++;
				flag = check();
				index = 1;
				a = 0;
			}else {
				index++;
			}
			if(count >= 1000) {
				count = -1;
				break;
			}
			
		}
		for(int i : map.keySet()) {
			Node nod = map.get(i);
			System.out.print(nod.num + " " + nod.row + " " + nod.col + "\n");
			while(nod.above != null) {
				nod = nod.above;
				System.out.println(nod.num);
			}
			System.out.println("/////////////");
		}
		
//		Node no = map.get(4);
//		System.out.println(no.row + " " + no.col + " " + no.dir + " " + no.above + " " + no.bellow);
		
//		for(int i = 0 ; i < N ; i++) {
//			for(int j = 0 ; j < N ; j++) {
//				System.out.print(chess[i][j]);
//			}
//			System.out.println();
//		}
		System.out.print(count);
		
		
	}
	
	static boolean check() {
		for(int i : map.keySet()) {
			int count = 1;
			Node node = map.get(i);
			while(node.above != null) {
				node = node.above;
				count++;
				if(count >= 4) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void blue(Node node, int row, int col, int dir) {
		switch(dir) {
		case 0: dir = 1;
		break;
		case 1: dir = 0;
		break;
		case 2: dir = 3;
		break;
		case 3: dir = 2;
		break;
		}
		node.dir = dir;
		int ro = node.row + r[dir];
		int co = node.col + c[dir];
		if(ro < 0 || ro >= N || co < 0 || co >= N || graph[ro][co] == 12) {
			return;
		}else if(graph[ro][co] == 11) {
			red(node, ro, co);
		} else {
			white(node, ro, co);
		}
		
		
	}
	
	static void red(Node node, int row, int col) {
		if(chess[node.row][node.col] == node.num) {
			chess[node.row][node.col] = 0;
		}
		if(chess[row][col] == 0) {
			if(node.bellow != null) {
				node.bellow.above = null;
			}
			node.bellow = null;
			node.row = row;
			node.col = col;
			Node sub = node.above;
			node.above = null;
			node.bellow = sub;
			while(node.bellow != null) {
				node = node.bellow;
				sub = node.above;
				node.above = node.bellow;
				node.bellow = sub;
				node.row = row;
				node.col = col;
			}
			chess[row][col] = node.num;
		} else {
			if(node.bellow != null) {
				node.bellow.above = null;
			}
			node.bellow = null;
			
			node.row = row;
			node.col = col;
			Node sub = node.above;
			node.above = null;
			node.bellow = sub;
			while(node.bellow != null) {
				node = node.bellow;
				sub = node.above;
				node.above = node.bellow;
				node.bellow = sub;
				node.row = row;
				node.col = col;
				
			}
			Node sub_node = map.get(chess[row][col]);
			while(sub_node.above != null) {
				sub_node = sub_node.above;
			}
			sub_node.above = node;
			node.bellow = sub_node;
		}
	}
	
	static void white(Node node, int row, int col) {
		if(chess[node.row][node.col] == node.num) {
			chess[node.row][node.col] = 0;
		}
		if(chess[row][col] == 0) {
			chess[row][col] = node.num;
			if(node.bellow != null) {
				node.bellow.above = null;
			}
			node.bellow = null;
			node.row = row;
			node.col = col;
			while(node.above != null) {
				node = node.above;
				node.row = row;
				node.col = col;
			}
		} else {
			if(node.bellow != null) {
				node.bellow.above = null;
			}
			node.bellow = null;
			Node sub_node = map.get(chess[row][col]);
			while(sub_node.above != null) {
				sub_node = sub_node.above;
			}
			node.bellow = sub_node;
			sub_node.above = node;
			node.row = row;
			node.col = col;
			while(node.above != null) {
				node = node.above;
				node.row = row;
				node.col = col;
			}
		}
	}
	
	static class Node{
		int num;
		int row;
		int col;
		int dir;
		Node above = null;
		Node bellow = null;
		
		public Node(int n, int r, int c, int d) {
			num = n;
			row= r;
			col= c;
			dir = d;
		}
	}

}
