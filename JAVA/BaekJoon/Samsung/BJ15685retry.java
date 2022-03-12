package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15685retry {

	static int N;
	static boolean graph[][];
	static ArrayList<Dragon> curve = new ArrayList<>();
	static int r[] = {0, -1, 0, 1};
    static int c[] = {1, 0, -1, 0};	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		graph = new boolean[101][101];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			curve.add(new Dragon(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	
		for(int k = 0 ; k < N ; k++) {
			Dragon dragon = curve.get(k);
			dCurve(dragon);
		}
		
		
		
		int answer = square();
		System.out.print(answer);
		
	}
	
	static int square() {
		int result = 0;
		
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(graph[i][j] && graph[i+1][j] && graph[i][j+1] && graph[i+1][j+1]) {
					result++;
				}
			}
		}
		
		
		return result;
	}
	
	static ArrayList<Integer> makeDir(ArrayList<Integer> direct) {
		ArrayList<Integer> cur_dir = new ArrayList<>();
		int size = direct.size();
		for(int i = size-1 ; i >= 0 ; i--) {
			int dir = direct.get(i)+1;
			if(dir == 4) {
				cur_dir.add(0);
				direct.add(0);
			}else {
				cur_dir.add(dir);
				direct.add(dir);
			}
		}
		return cur_dir;
	}
	
	static void goCurve(ArrayList<Integer> cur_dir, Node node) {
		int row = node.row;
		int col = node.col;
		
		for(int i = 0 ; i < cur_dir.size() ; i++) {
			int dir = cur_dir.get(i);
			row += r[dir];
			col += c[dir];
			
			graph[row][col] = true;
		}
		
		node.row = row;
		node.col = col;
		
	}
	
	static void dCurve(Dragon dragon){
		Node node = new Node(dragon.row, dragon.col);
		int dir = dragon.dir;
		graph[node.row][node.col] = true;
		ArrayList<Integer> direct = new ArrayList<>();
		direct.add(dir);
		node.row += r[dir];
		node.col += c[dir];
		graph[node.row][node.col] = true;
		
		for(int loop = 0 ; loop < dragon.gen ; loop++) {
			
			ArrayList<Integer> cur_dir = makeDir(direct);
			goCurve(cur_dir, node);
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
	
	static class Dragon{
		int row;
		int col;
		int dir;
		int gen;
		
		public Dragon(int c, int r, int d, int g) {
			row = r;
			col = c;
			dir = d;
			gen = g;
		}
	}

}
