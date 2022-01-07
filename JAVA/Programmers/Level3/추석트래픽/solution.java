import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        int result[] = new int[lines.length];
        
        long[] edTime = new long[lines.length];
        long[] stTime = new long[lines.length];
        
        for(int i = 0 ; i < lines.length ; i++){
            String str[] = lines[i].split(" ");
            String str1[] = str[1].split("[:]");
            
            long sum = (Long.parseLong(str1[0]) * 60 * 60 + Long.parseLong(str1[1]) * 60) * 1000;
            sum += (long)(Double.parseDouble(str1[2])*1000);
            edTime[i] = sum;
            stTime[i] = sum - (long)(Double.parseDouble(str[2].substring(0, str[2].length()-1))*1000)+1;
        }
        
        
        for(int i = 0 ; i < lines.length ; i++){
            long end = edTime[i] + 999;
            for(int j = i ; j < lines.length ; j++){
                if(stTime[j] <= edTime[i]){
                    result[i]++;
                } else if(stTime[j] > edTime[i] && stTime[j] <= end){
                    result[i]++;
                }
            }
            
            
        }
        int maxi = 0;
        for(int i = 0 ; i < result.length ; i++){
            maxi = Math.max(maxi, result[i]);
        }
        
        answer = maxi;
        return answer;
    }
}
