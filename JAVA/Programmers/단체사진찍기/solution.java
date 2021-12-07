import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    boolean visit[] = new boolean[8];
    public int solution(int n, String[] data) {
        
        String str = "ACFJMNRT";
        
        boolean flag = false;
        
        
        dfs(str, "", data, flag);
        
        
        
        return answer;
    }
    
    void dfs(String str, String sub, String[] data, boolean flag){
        if(sub.length() == str.length()){
            for(int i = 0 ; i < data.length ; i++){
                char a = data[i].charAt(0);
                char b = data[i].charAt(2);
                char c = data[i].charAt(3);
                int d = data[i].charAt(4) - '0';
                if(c == '='){
                    if(Math.abs(sub.indexOf(a) - sub.indexOf(b)) - 1 == d){
                        continue;
                    } else{
                        flag = true;
                        break;
                    }
                } else if(c == '>'){
                    if(Math.abs(sub.indexOf(a) - sub.indexOf(b)) - 1 > d){
                        continue;
                    } else{
                        flag = true;
                        break;
                    }
                } else if(c == '<'){
                    if(Math.abs(sub.indexOf(a) - sub.indexOf(b)) - 1 < d){
                        continue;
                    } else{
                        flag = true;
                    }
                }
                
                
                
            }
            
            if(!flag){
                answer++;
            }
        } else{
            for(int i = 0 ; i < 8 ; i++){
                if(!visit[i]){
                    sub += str.charAt(i);
                    visit[i] = true;
                    dfs(str, sub, data, flag);
                    sub = sub.substring(0, sub.length() - 1);
                    visit[i] = false;
                }
            }
        }
        
        
    }
}
