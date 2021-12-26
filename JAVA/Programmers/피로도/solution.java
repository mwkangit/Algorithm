import java.util.*;
import java.io.*;


class Solution {
    boolean visit[];
    int maxi = 0;
    int life;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        life = k;
        
        visit = new boolean[dungeons.length];
        // String dun = new String[dungeons.length];
        
        // for(int i = 0 ; i < dungeons.length ; i++){
        //     dun[i] = String.valueOf(i);
        // }
        
        dfs(dungeons, 0);
        answer = maxi;
        return answer;
    }
    
    
    public void dfs(int[][] dung, int depth){
        maxi = Math.max(maxi, depth);
            for(int i = 0 ; i < dung.length ; i++){
                if(!visit[i]){
                    visit[i] = true;
                    if(life >= dung[i][0]){
                        life -= dung[i][1];
                        dfs(dung, depth+1);
                        life += dung[i][1];
                    }
                    visit[i] = false;
                    
                    
                }
            }
        
        
        
    }
}
