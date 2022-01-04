import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String msg) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 1 ; i <= 26 ; i++){
            map.put(String.valueOf(alpha.charAt(i-1)), i);
        }
        
        int index = 27;
        
        String str = "";
        str += msg.charAt(0);
        for(int i = 0 ; i < msg.length() ; i++){
            if(i + 1 == msg.length()){
                list.add(map.get(str));
                break;
            }
            
            if(!map.containsKey(str + msg.charAt(i+1))){
                list.add(map.get(str));
                map.put(str + msg.charAt(i+1), index);
                index++;
                str = "";
                str += msg.charAt(i+1);
            } else {
                str += msg.charAt(i+1);
                continue;
            }
            
            
        }
        

        
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
