import java.util.*;
import java.io.*;

class Solution {
    boolean visit[];
    int mini = 987654321;
    int len;
    String tar;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visit = new boolean[words.length];
        len = begin.length();
        tar = target;
        
        dfs(words, begin, 0);
        
            
        if(mini == 987654321){
            return 0;
        }
        answer = mini;
        
        return answer;
    }
    
    public void dfs(String[] words, String sub, int d){
        // System.out.println(sub + " " + d);
        if(sub.equals(tar)){
            mini = Math.min(mini, d);
            return;
        } else{
            for(int i = 0 ; i < words.length ; i++){
                if(!visit[i]){
                    boolean flag = false;
                    int count = 0;
                    for(int j = 0 ; j < len ; j++){
                        if(sub.charAt(j) != words[i].charAt(j)){
                            count++;
                        }
                        if(count > 1){
                            flag = true;
                            break;
                        }
                    }
                    if(flag) continue;
                    visit[i] = true;
                    dfs(words, words[i], d+1);
                    visit[i] = false;
                }
            }
        }
    }
}
