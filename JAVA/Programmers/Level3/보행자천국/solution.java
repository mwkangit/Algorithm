import java.util.*;
import java.io.*;

class Solution {
    int MOD = 20170805;
    
    int r[] = {0,-1};
    int c[] = {-1,0};
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int graph[][][] = new int[m][n][2];
        
        for(int i = 0 ; i < m ; i++){
            if(cityMap[i][0] == 1) break;
            graph[i][0][1] = 1;
        }
        
        for(int i = 0 ; i < m ; i++){
            if(cityMap[0][i] == 1) break;
            graph[0][i][0] = 1;
        }
        
        int row;
        int col;
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                for(int k = 0 ; k < 2 ; k++){
                    row = i + r[k];
                    col = j + c[k];
                    
                    if(row < 0 || col < 0 || row >= m || col >= n)continue;
                    
                    if(cityMap[row][col] == 1)continue;
                    
                    if(cityMap[row][col] == 2) graph[i][j][k] = (graph[i][j][k] + graph[row][col][k]) % MOD;
                    
                    if(cityMap[row][col] == 0) {
                        for(int x = 0 ; x < 2 ; x++){
                            graph[i][j][k] = (graph[i][j][k] + graph[row][col][x]) % MOD;
                        }
                    }
                    
                    
                }
            }
        }
        
        for(int i = 0 ; i < 2 ; i++){
            answer = (answer + graph[m-1][n-1][i]) % MOD;
            
        }
        
        return answer;
    }
}
