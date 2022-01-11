import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int graph[][] = new int[triangle.length][triangle.length];
        graph[0][0] = triangle[0][0];
        
        for(int i = 1 ; i < triangle.length ; i++){
            graph[i][0] += graph[i-1][0] + triangle[i][0];
            for(int j = 1 ; j < i+1 ; j++){
                graph[i][j] = Math.max(graph[i-1][j], graph[i-1][j-1]) + triangle[i][j];
            }
        }
        
        int maxi = 0;
        for(int i = 0 ; i < triangle.length ; i++){
            maxi = Math.max(maxi, graph[triangle.length-1][i]);
        }
        answer = maxi;
        return answer;
    }
}
