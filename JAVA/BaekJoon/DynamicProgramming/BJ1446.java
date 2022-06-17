package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1446 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		int graph[][] = new int[N][3];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(graph, new Comparator<int[]>() {
			public int compare(int[] a1, int[] a2) {
				return a1[1] - a2[1];
			}
		});
		
		int index = 0;
		dp[0] = 0;
		for(int i = 1 ; i <= D ; i++) {
			if(index < graph.length && i == graph[index][1]) {
				while(index < graph.length && graph[index][1] == i) {
					dp[i] = Math.min(dp[i], dp[i-1]+1);
					dp[i] = Math.min(dp[i], dp[graph[index][0]] + graph[index][2]);
					
					index++;
				}
			} else {
				dp[i] = Math.min(dp[i], dp[i-1]+1);
			}
		}
		System.out.println(dp[D]);
		
		
		

	}

}
