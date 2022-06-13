package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17070 {
    // 좋은 문제
    // 경로 문제이면서 최소로 구할수도 있는 문제
    static int N;
    static int graph[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        graph = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                graph[i][j] = stoi(st.nextToken());
            }
        }
        int dp[][][] = new int[N][N][3];
        for(int i = 1 ; i < N ; i++){
            if(graph[0][i] != 1){
                dp[0][i][0] = 1;
            }else{
                break;
            }
        }
        for(int i = 1 ; i < N ; i++){
            for(int j = 1 ; j < N ; j++){
                if(graph[i][j] != 1){
                    dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
                    dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
                    if(graph[i-1][j] != 1 && graph[i][j-1] != 1){
                        dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    }

                }
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);



    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}
