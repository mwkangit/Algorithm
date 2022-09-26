package programmers.vowelDictionary;

import java.util.*;

class Solution {
    static int answer = 0;
    static boolean flag = false;
    static String target;
    public int solution(String word) {
        target = word;
        dfs("AEIOU", 0, new StringBuilder());
        
        return answer;
    }
    
    static void dfs(String moem, int count, StringBuilder sb){
        if(flag)return;
        if(count > 5)return;
        if(sb.toString().equals(target)){
            flag = true;
            return;
        }
        answer++;
        
        
        for(int i = 0 ; i < 5 ; i++){
            if(flag)return;
            sb.append(moem.charAt(i));
            dfs(moem, count+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}