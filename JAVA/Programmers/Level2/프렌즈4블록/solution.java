import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    int dy[] = {0, 1, 1};
    int dx[] = {1, 0, 1};
    int y_len = 0;
    int x_len = 0;
    boolean switc;
    
    public int solution(int m, int n, String[] board) {
        
        char graph[][] = new char[m][n];
        
        y_len = m;
        x_len = n;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                graph[i][j] = board[i].charAt(j);
            }
        }
        
        do{        
            switc = false;
            boolean visit[][] = new boolean[m][n];


            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(graph[i][j] != '0'){
                        square(graph, visit, i, j);
                    }
                }
            }      
            
            for(int i = m - 1 ; i >= 0 ; i--){
                for(int j = n - 1 ; j >=0 ; j--){
                    if(visit[i][j]){
                        graph[i][j] = '0';
                        for(int k = i - 1 ; k >= 0 ; k--){
                            if(!visit[k][j]){
                                graph[i][j] = graph[k][j];
                                visit[k][j] = true;
                                graph[k][j] = '0';
                                break;
                            }
                        }
                    }
                }
            }
        } while(switc);
        
        return answer;
    }
    
    public void square(char graph[][], boolean visit[][], int row, int col){
        for(int i = 0 ; i < 3 ; i++){
            if(row + dy[i] >= y_len || col + dx[i] >= x_len || graph[row][col] != graph[row + dy[i]][col + dx[i]]){
                return;
            }
        }
        if(visit[row][col] == false){
            visit[row][col] = true;
            answer++;
        }
        for(int i = 0 ; i < 3 ; i++){
            if(visit[row + dy[i]][col + dx[i]] == false){
                visit[row + dy[i]][col + dx[i]] = true;
                answer++;            
            }
        }
        switc = true;
    }
}
