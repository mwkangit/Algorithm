package unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717Again {

	static int n, m;
	static int parent[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = parse(st.nextToken());
		m = parse(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i = 0 ; i <= n ; i++) {
			parent[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int flag = parse(st.nextToken());
			int x = parse(st.nextToken());
			int y = parse(st.nextToken());
			if(flag == 0) {
				union(x,y);
			}else {
				sb.append(isSame(x, y)).append("\n");
			}
		}
		System.out.print(sb);
		
	}
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		if(x != y) {
			
			parent[y] = x;
			
		}
		
	}
	
	static String isSame(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if(x == y)return "yes";
		else return "no";
		
	}
	
	static int parse(String str) {
		return Integer.parseInt(str);
	}

}
