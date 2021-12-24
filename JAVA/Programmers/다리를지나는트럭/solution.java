import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        int cur = 0;
        int left = 0;
        
        for(int i = 0 ; i < truck_weights.length ; i++){
            
            while(true){
                if(q.isEmpty()){
                    q.add(truck_weights[i]);
                    cur += truck_weights[i];
                    answer++;
                    break;
                } else{
                    if(q.size() == bridge_length){
                        left = q.poll();
                        cur -= left;
                    } else{
                        if(cur + truck_weights[i] <= weight){
                            q.add(truck_weights[i]);
                            cur += truck_weights[i];
                            answer++;
                            break;
                        } else {
                            q.add(0);
                            answer++;
                        }
                    }
                    
                    
                }
                
                
                
            }
            
        }
        
        return answer + bridge_length;
    }
}
