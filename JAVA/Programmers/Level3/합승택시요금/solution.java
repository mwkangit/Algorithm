import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int INF = 987654321;
        int mini = INF;
        
        int graph[][] = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                graph[i][j] = INF;
            }
        }        
        
        for(int i[] : fares){
            graph[i[0] - 1][i[1] - 1] = i[2];
            graph[i[1] - 1][i[0] - 1] = i[2];
        }
        
        for(int i = 0 ; i < n ; i++){
            graph[i][i] = 0;
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            if(graph[s-1][i] != INF && graph[i][a-1] != INF && graph[i][b-1] != INF){
                mini = Math.min(mini, graph[s-1][i] + graph[i][a-1] + graph[i][b-1]);
        
            }
        }
        
        answer = mini;
       
        return answer;
    }
}
