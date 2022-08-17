package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class BJ17825Retry {

	static Node nodes[];
	static boolean visit[];
	static Horse horse[];
	static int dice[];
	static int answer = 0;
	static int total = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nodes = new Node[33];
		
		horse = new Horse[4];
		for(int i = 0 ; i < 4 ; i++) {
			horse[i] = new Horse();
		}
		dice = new int[10];
		
		int incre = 1;
		for(int i = 0 ; i < 33 ; i++) {
			nodes[i] = new Node(i);
		}
		for(int i = 1 ; i < 21 ; i++) {
			nodes[i].add(incre*2, false, nodes[i+1], null);
			incre++;
		}
		nodes[0].add(0, false, nodes[1], null);
		nodes[5].isBlue = true;
		nodes[5].nextBlue = nodes[21];
		nodes[10].isBlue = true;
		nodes[10].nextBlue = nodes[24];
		nodes[15].isBlue = true;
		nodes[15].nextBlue = nodes[26];
		nodes[21].num = 13;
		nodes[22].num = 16;
		nodes[23].num = 19;
		nodes[24].num = 22;
		nodes[25].num = 24;
		nodes[26].num = 28;
		nodes[27].num = 27;
		nodes[28].num = 26;
		nodes[29].num = 25;
		nodes[30].num = 30;
		nodes[31].num = 35;
		nodes[21].nextRed = nodes[22];
		nodes[22].nextRed = nodes[23];
		nodes[23].nextRed = nodes[29];
		nodes[24].nextRed = nodes[25];
		nodes[25].nextRed = nodes[29];
		nodes[26].nextRed = nodes[27];
		nodes[27].nextRed = nodes[28];
		nodes[28].nextRed = nodes[29];
		nodes[29].nextRed = nodes[30];
		nodes[30].nextRed = nodes[31];
		nodes[31].nextRed = nodes[20];
		nodes[20].nextRed = nodes[32];
		
		
		
		for(int i = 0 ; i < 10 ; i++) {
			dice[i] = ps(st.nextToken());
		}
		
		
		dfs(0, new LinkedList<>());
		
		System.out.print(answer);
		
		
	}
	static void dfs(int curr, LinkedList<Integer> list) {
		if(curr >= 10) {
			for(int i = 0 ; i < 4 ; i++) {
				horse[i].add(false, nodes[0], nodes[1]);
			}
			visit = new boolean[33];
			if(check(list)) {
				answer = Math.max(answer, total);
			}
		}else {
			for(int i = 0 ; i < 4 ; i++) {
				list.add(i);
				dfs(curr+1, list);
				list.remove(list.size()-1);
			}
		}
	}
	static boolean check(LinkedList<Integer> list) {
		total = 0;
		for(int i = 0 ; i < list.size() ; i++) {
			int index = list.get(i);
			int num = dice[i];
			if(horse[index].isGoal) {
				continue;
			}
			Node currNode = horse[index].currNode;
			boolean flag = false;
			if(currNode.isBlue) {
				currNode = currNode.nextBlue;
				for(int j = 0 ; j < num-1 ; j++) {
					if(currNode.nextRed.idx == nodes[32].idx) {
						visit[horse[index].currNode.idx] = false;
						horse[index].isGoal = true;
						flag = true;
						break;
					}
					currNode = currNode.nextRed;
				}
			}else {
				for(int j = 0 ; j < num ; j++) {
					if(currNode.nextRed.idx == nodes[32].idx) {
						visit[horse[index].currNode.idx] = false;
						horse[index].isGoal = true;
						flag = true;
						break;
					}
					currNode = currNode.nextRed;
				}
			}
			if(flag)continue;
			
			if(visit[currNode.idx]) {
				return false;
			}
			visit[horse[index].currNode.idx] = false;
			visit[currNode.idx] = true;
			horse[index].currNode = currNode;
			total += currNode.num;
			
		}
		
		return true;
	}
	
	static class Horse{
		boolean isGoal;
		Node currNode;
		Node nextNode;
		public Horse() {
			
		}

		public Horse(boolean is, Node c, Node n) {
			isGoal = is;
			currNode = c;
			nextNode = n;
		}
		
		public void add(boolean is, Node c, Node n) {
			isGoal = is;
			currNode = c;
			nextNode = n;
		}
	}
	
	static class Node{
		int num;
		int idx;
		boolean isBlue;
		Node nextRed;
		Node nextBlue;
		public Node() {
		}
		public Node(int id) {
			idx = id;
		}
		
		public void add(int n, boolean is, Node r, Node b) {
			num = n;
			isBlue = is;
			nextRed = r;
			nextBlue = b;
		}
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
