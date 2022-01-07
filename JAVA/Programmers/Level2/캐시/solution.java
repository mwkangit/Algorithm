import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < cities.length ; i++){
            cities[i] = cities[i].toLowerCase();
        }
        
        int min = 100;
        String mini = "";
        
        if(cacheSize == 0){
            answer = cities.length * 5;
            return answer;
        }
        
        for(int i = 0 ; i < cities.length ; i ++){
            if(map.containsKey(cities[i])){
                answer++;
                map.put(cities[i], cacheSize);
            } else {
                answer += 5;
                if(map.size() == cacheSize){
                    map.remove(mini);                
                }
                map.put(cities[i], cacheSize);
            }
            
            min = 100;
            for(String s : map.keySet()){
                if(Math.min(min, map.get(s)) == map.get(s)){
                    min = map.get(s);
                    mini = s;
                }
                map.put(s, map.get(s) - 1);
            }
            
            
        }
        
        
        
        return answer;
    }
    
}
