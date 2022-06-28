package programmers.candidateKey;

import java.util.*;

class SolutionAgain {
    
    static String[][] rel;
    static HashSet<String> list = new HashSet<>();
    public int solution(String[][] relation) {
        
        rel = relation;
        for(int i = 1 ; i <= rel[0].length ; i++){
            dfs(0, new StringBuilder(), i, 0);
        }
        
        
        int answer = list.size();
        return answer;
    }
    static boolean uniqueness(StringBuilder sb){
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < rel.length ; i++){
            String str = "";
            for(int j = 0 ; j < sb.length() ; j++){
                str += rel[i][sb.charAt(j) - '0'];
            }
            if(set.contains(str)){
                return false;
            } else{
                set.add(str);
            }
        }
        return true;
    }
    static boolean minimality(StringBuilder sb){
        String str = sb.toString();
        for(String s : list){
            int count = 0;
            for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                for(int j = 0 ; j < str.length() ; j++){
                    if(c == str.charAt(j)){
                        count++;
                        break;
                    }
                }
            }
            if(count == s.length()){
                return false;
            }
        }
        return true;
    }
    
    static void dfs(int curr, StringBuilder sb, int limit, int curlength){
        if(curlength == limit){
            if(uniqueness(sb)){
                if(minimality(sb)){
                    list.add(sb.toString());
                }
            }
            return;
        }else{
            for(int i = curr ; i < rel[0].length ; i++){
                sb.append(i);
                dfs(i + 1, sb, limit, curlength+1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
    }
    
}