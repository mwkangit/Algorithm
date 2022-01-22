import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long INF = 1000000007;
        
        long graph[][] = new long[n][m];
        
        for(int i[] : puddles){
            graph[i[1] - 1][i[0] - 1] = INF;
        }
        
        for(int i = 0 ; i < n ; i++){
            if(graph[i][0] != INF){
                graph[i][0] = 1;
            } else {
                break;
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(graph[0][i] != INF){
                graph[0][i] = 1;
            } else{
                break;
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(graph[i][j] == INF)continue;
                if(graph[i-1][j] == INF && graph[i][j-1] == INF){
                    graph[i][j] = 0;
                } else if(graph[i-1][j] == INF){
                    graph[i][j] = graph[i][j-1] % 1000000007;
                } else if(graph[i][j-1] == INF){
                    graph[i][j] = graph[i-1][j] % 1000000007;
                } else{
                    graph[i][j] = (graph[i-1][j] + graph[i][j-1]) % 1000000007;
                }
            }
        }
        
        answer = (int)(graph[n-1][m-1] % 1000000007);
        
        return answer;
    }
}
