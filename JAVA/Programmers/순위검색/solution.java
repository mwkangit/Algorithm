import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    static boolean visit[];
    public int[] solution(String[] info, String[] query) {
        
        
        int answer[] = new int[query.length];
        visit = new boolean[5];
        
        for(int i = 0 ; i < info.length ; i++){
            String str[] = info[i].split("\\s");
            dfs(str, "", 4, 0);
        }
        
        ArrayList<String> keyset = new ArrayList<>(map.keySet());
        for(int i = 0 ; i < map.size() ; i++){
            Collections.sort(map.get(keyset.get(i)));
        }
        
        
        for(int i = 0 ; i < query.length ; i++){
            String qstr = query[i].replaceAll("\\sand\\s", "");
            String sub[] = qstr.split("\\s");
            answer[i] = bst(sub[0], Integer.parseInt(sub[1]));
            
        }
        
        // System.out.println(map);
        
        return answer;
    }
    
    public void dfs(String str[], String sub, int m, int d){
        if(d == m){
            if(!map.containsKey(sub)){
                ArrayList<Integer> input = new ArrayList<>();
                input.add(Integer.parseInt(str[4]));
                map.put(sub, input);
            } else{
                map.get(sub).add(Integer.parseInt(str[4]));
            }
        } else{
            dfs(str, sub+"-", m, d+1);
            dfs(str, sub+str[d], m, d+1);
        }
        
        
    }
    
}
