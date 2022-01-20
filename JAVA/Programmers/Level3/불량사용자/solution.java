import java.util.*;
import java.io.*;

class Solution {
    static HashSet<HashSet<String>> set;
    static ArrayList<String> list[];
    static int len;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        len = banned_id.length;
        String ban[] = new String[banned_id.length];
        list = new ArrayList[banned_id.length];
        set = new HashSet<>();
        
        for(int i = 0 ; i < banned_id.length ; i++){
            ban[i] = banned_id[i].replaceAll("[*]", ".");
        }
        
        for(int i = 0 ; i < len ; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < banned_id.length ; i++){
            for(int j = 0 ; j < user_id.length ; j++){
                if(user_id[j].matches(ban[i])){
                    list[i].add(user_id[j]);
                }
            }
        }
        
        dfs(new HashSet<>(), 0);
        
        
        answer = set.size();
        
        return answer;
    }
    
    static void dfs(HashSet<String> hs, int d){
        if(d == len){
            
            set.add(new HashSet<>(hs));
            return;
            
        } else{
            
            for(String str : list[d]){
                if(!hs.contains(str)){
                    hs.add(str);
                    dfs(hs, d + 1);
                    hs.remove(str);
                }
            }
            
        }
    }
    
}
