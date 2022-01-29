import java.util.*;
import java.io.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int total = convert(play_time);
        int ad = convert(adv_time);
        int plays[] = new int[total+1];
        
        for(int i = 0 ; i < logs.length ; i++){
            String sub[] = logs[i].split("[-]");
            int log_start = convert(sub[0]);
            int log_end = convert(sub[1]);
            
            for(int j = log_start ; j < log_end ; j++){
                plays[j]++;
            }
        }
        
        long sum = 0;
        for(int i = 0 ; i < ad ; i++){
            sum += plays[i];
        }
        
        long max_size = sum;
        int min_time = 0;
        
        for(int i = 0 ; i + ad <= total ; i++){
            sum += plays[i + ad] - plays[i];
            if(max_size < sum){
                max_size = sum;
                min_time = i + 1;
            }
        }
        
        
        
        String answer = convertR(min_time);
        
        
        return answer;
    }
    
    public String convertR(int num){
        
        StringBuilder sb = new StringBuilder();
        if(num / 3600 < 10){
            sb.append("0");
        }
        sb.append(String.valueOf(num / 3600) + ":");
        num %= 3600;
        if(num / 60 < 10){
            sb.append("0");
        }
        sb.append(String.valueOf(num / 60) + ":");
        num %= 60;
        if(num < 10){
            sb.append("0");
        }
        sb.append(String.valueOf(num));
        
        return sb.toString();
        
    }

    public int convert(String str){
        String sub[] = str.split("[:]");
        
        return Integer.parseInt(sub[0]) * 3600 + Integer.parseInt(sub[1]) * 60 + Integer.parseInt(sub[2]);
        
    }
}
