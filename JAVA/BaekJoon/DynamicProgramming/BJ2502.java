package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2502 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int graph[][] = new int[D][2];
//        dp[D-3] + dp[D-2] = dp[D-1]

        graph[0][0] = 1;
        graph[0][1] = 0;
        graph[1][0] = 0;
        graph[1][1] = 1;

        for(int i = 2 ; i < D ; i++){
            graph[i][0] = graph[i-2][0] + graph[i-1][0];
            graph[i][1] = graph[i-2][1] + graph[i-1][1];
        }

        int limit = K / graph[D-1][0];
        int first = 0;
        int second = 0;
        for(int i = 1 ; i < limit ; i++){
            first = i;
            if((K - first * graph[D-1][0]) % graph[D-1][1] == 0){
                second = (K - first * graph[D-1][0]) / graph[D-1][1];
                break;
            }
        }
        System.out.println(first);
        System.out.println(second);

    }
}
