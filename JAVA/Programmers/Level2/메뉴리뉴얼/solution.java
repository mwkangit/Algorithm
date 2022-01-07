import java.util.*;
import java.io.*;

class Solution {
    boolean visit[];
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < orders.length ; i++){
            char c[] = orders[i].toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            orders[i] = str;
            System.out.println(str);
        }
        
        for(int i = 0 ; i < orders.length ; i++){
            visit = new boolean[orders[i].length()];
            for(int j = 0 ; j < course.length ; j++){
                
                dfs(orders[i], "", course[j], 0);
                            
            }
        }
        
        for(int i = 0 ; i < course.length ; i++){
            int maxi = 0;
            for(String s : map.keySet()){
                if(s.length() == course[i] && map.get(s) >= 2){
                    maxi = Math.max(maxi, map.get(s));
                }
            }
            for(String s : map.keySet()){
                if(s.length() == course[i] && map.get(s) == maxi){
                    list.add(s);
                }
            }
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void dfs(String orders, String sub, int m, int d){
        if(sub.length() == m){
            if(map.containsKey(sub)){
                map.put(sub, map.get(sub) + 1);
            } else{
                map.put(sub, 1);
            }
        } else{
            for(int i = d ; i < orders.length() ; i++){
                if(!visit[i]){
                    visit[i] = true;
                    dfs(orders, sub+orders.charAt(i), m, i+1);
                    visit[i] = false;
                }
            }
            
        }
        
        
        
    }
}
