package samsung;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class BJ14501dp {
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	    int N = Integer.parseInt(br.readLine());
	    
	    ArrayList<Pair> list = new ArrayList<>();
	    
	    for(int i = 0 ; i < N ; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    	list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    list.add(new Pair(0, 0));
	    
	    int dp[] = new int[N+6];
	    int maxi = 0;
	    for(int i = 0 ; i <= N ; i++) {
	    	Pair pair = list.get(i);
	    	dp[i] = Math.max(dp[i], maxi);
	    	
	    	dp[pair.T + i] = Math.max(dp[pair.T + i], dp[i] + pair.P);
	    	
	    	maxi = Math.max(maxi, dp[i]);
	    }
	    for(int i : dp) {
	    	System.out.print(i + " ");
	    }
	    System.out.println();
	    
	    System.out.print(dp[N]);
	    
	    
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
