import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int min = 1;
        int max = 200000000;
        int mid;
        int answer = 0;
        
        while(min <= max){
            mid = (min + max) / 2;
            if(check(stones, k, mid)){
                min = mid + 1;
            } else if(!check(stones, k , mid)){
                max = mid - 1;
                answer = max;
            }
        }
        
        return answer;
    }
    
    public boolean check(int[] stone, int k, int mid){
        int count = 0;
        for(int i = 0 ; i < stone.length ; i++){
            if(stone[i] - mid < 0){
                count++;
            }
            if(stone[i] - mid >= 0){
                count = 0;
            }
            if(count == k) return false;
        }
        return true;
    }
}
