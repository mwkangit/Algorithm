import java.util.*;
import java.io.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        
        for(int i = 0 ; i < numbers.length ; i++){
            String bits = Long.toBinaryString(numbers[i]);
            Long num = numbers[i];
            if(num % 2 == 0){
                answer[i] = num + 1;
                continue;
            } else{
                if(!bits.contains("0")){
                    bits = "10" + bits.substring(1);
                    answer[i] = Long.parseLong(bits, 2);
                } else{
                    bits = bits.substring(0, bits.lastIndexOf("0")) + "10" + bits.substring(bits.lastIndexOf("0")+2);
                    
                    answer[i] = Long.parseLong(bits, 2);
                }
                
                
            }
            
            
        }
        return answer;
    }
}
