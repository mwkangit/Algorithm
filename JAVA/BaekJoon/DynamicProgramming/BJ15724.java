package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15724 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M;
        N = ps(st.nextToken());
        M = ps(st.nextToken());
        
        int graph[][] = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= M ; j++) {
        		int num = ps(st.nextToken());
        		graph[i][j] = num;
        	}
        }
        int dp[][] = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i++) {
        	for(int j = 1; j <= M ; j++) {
        		dp[i][j] = dp[i-1][j] + dp[i][j-1] + graph[i][j] - dp[i-1][j-1];
        	}
        }
        int K = ps(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int loop = 0 ; loop < K ; loop++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = ps(st.nextToken());
        	int y1 = ps(st.nextToken());
        	int x2 = ps(st.nextToken());
        	int y2 = ps(st.nextToken());
        	int num = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
        	sb.append(num).append("\n");
        }
        System.out.print(sb)
        ;
        
        
	}
    
    static int ps(String str) {
    	return Integer.parseInt(str);
    }

}
