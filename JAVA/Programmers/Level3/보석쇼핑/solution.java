import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        for(int i = 0 ; i < gems.length ; i++){
            set.add(gems[i]);
        }
        
        int start = 1;
        int end = gems.length;
        int sub = 0;
        int len = gems.length;
        
        for(int i = 0 ; i < gems.length ; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.add(gems[i]);
            
            while(true){
                String str = q.peek();
                if(map.get(str) > 1){
                    q.poll();
                    map.put(str, map.get(str) - 1);
                    sub++;
                } else {
                    break;
                }
            }
            
            if(set.size() == map.size()){
                if(len > i - sub){
                    len = i - sub;
                    start = sub + 1;
                    end = i+1;
                }
            }
            
            
            
        }
        
        answer[0] = start;
        answer[1] = end;
        
        return answer;
    }
}
