import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int result = 0;
        int timet[] = new int[timetable.length];
         
        for(int i = 0 ; i < timetable.length ; i++){
            String sub[] = timetable[i].split(":");
            timet[i] = Integer.parseInt(sub[0]) * 60 + Integer.parseInt(sub[1]);
        }
        
        Arrays.sort(timet);
        int start = 9 * 60 - t;
        int index = 0;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            start += t;
            result = start;
            count = 0;
            for(int j = 0; j < m ; j++){
                if(index != timet.length && timet[index] <= start){
                    count++;
                    index++;
                } else {
                    break;
                }
            }
            if(count != m && i + 1 != n){
                continue;
            } else if(count == m){
                result = timet[index - 1] - 1;
            }
        }
        int hour = result / 60;
        int min = result % 60;
        if(hour < 10){
            answer += "0";
        }
        answer += String.valueOf(hour) + ":";
        
        if(min < 10){
            answer += "0";
        }
        answer += String.valueOf(min);
        
        return answer;
    }
}
