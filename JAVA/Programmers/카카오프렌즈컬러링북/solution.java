import java.util.*;
import java.io.*;

class Solution {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    boolean visit[][];
    int drow[] = {0, 1, 0, -1};
    int dcol[] = {1, 0, -1, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        
        visit = new boolean[m][n];
        int maxi;
        
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visit[i][j] && picture[i][j] != 0){
                    maxi = bfs(picture, i, j, m, n, picture[i][j]);  
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, maxi);
                    numberOfArea++;
                }
            }
        }
        
        
        
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    int bfs(int[][] picture, int row, int col, int m, int n, int num){
        
        Queue<pair> q = new LinkedList<>();
        int count = 0;
            
        q.add(new pair(row, col));
        
        visit[row][col] = true;
        
        while(!q.isEmpty()){
            pair p = q.poll();
            int currow = p.x;
            int curcol = p.y;
            
            count++;
            
            for(int i = 0 ; i < 4 ; i++){
                if(currow + drow[i] < m && curcol + dcol[i] < n && currow + drow[i] >= 0 && curcol + dcol[i] >= 0 && !visit[currow + drow[i]][curcol + dcol[i]] && picture[currow + drow[i]][curcol + dcol[i]] == num){
                    q.add(new pair(currow + drow[i], curcol + dcol[i]));
                    visit[currow + drow[i]][curcol + dcol[i]] = true;
                    
                }
            }
            
            
        }
        
        return count;
        
        
        
    }
    
    class pair{
        int x;
        int y;
        
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
