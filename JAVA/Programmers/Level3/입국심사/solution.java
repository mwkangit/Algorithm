import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long end = times[times.length-1];
        end = end * n;
        long start = 0;
        long mid;
        long time;
        
        while(start <= end){
            mid = (start + end) / 2;
            time = 0;
            for(int i = 0 ; i < times.length ; i++){
                time += mid / times[i];
            }
            if(time < n){
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
            
        }
        
        
        return answer;
    }
}
