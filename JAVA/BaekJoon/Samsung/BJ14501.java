package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14501 {

	static ArrayList<Pair> list;
	static int N;
	static boolean visit[];
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		N = n;
		
		list = new ArrayList<>();
		visit = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		dfs(0, 0);
		
		System.out.print(answer);
		
	}
	
	static void dfs(int index, int income) {
			answer = Math.max(answer, income);
			
			for(int i = index ; i < N ; i++) {
				if(!visit[i]) {
					Pair pair = list.get(i);
					if(i + pair.T > N) {
						continue;
					}
					visit[i]= true;
					dfs(i + pair.T, income + pair.P);
					visit[i] = false;
				}
			}
		
		
		
	}
	
	static class Pair{
		int T;
		int P;
		
		public Pair(int t, int p) {
			T = t;
			P = p;
		}
	}

}
