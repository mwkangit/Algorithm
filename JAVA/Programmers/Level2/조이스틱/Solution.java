package programmers.joyStick;

import java.util.*;

class Solution {
    public int solution(String name) {
        
        int length = name.length();
        int answer = 0;
        int move = name.length()-1;
        
        for(int i = 0 ; i < length ; i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 1 + 'Z' - c);
            
            if(i < length -1 && name.charAt(i+1) == 'A'){
                
            
                int index = i + 1;
                while(index < length && name.charAt(index) == 'A'){
                    index++;
                }

                move = Math.min(move, i*2 + (length - index));
                move = Math.min(move, (length - index) * 2 + i);
        
            }
        }        
        
        return answer + move;
    }
}