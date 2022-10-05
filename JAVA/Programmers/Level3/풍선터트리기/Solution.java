package programmers.popBalloon;

import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 2;
        
        int leftMin[] = new int[a.length];
        int rightMin[] = new int[a.length];
        int minVal = a[0];
        
        for(int i = 1 ; i < a.length-1 ; i++){
            if(minVal > a[i]){
                minVal = a[i];
            }
            leftMin[i] = minVal;
        }
        minVal = a[a.length-1];
        
        for(int i = a.length-2 ; i > 0 ; i--){
            if(minVal > a[i]){
                minVal = a[i];
            }
            rightMin[i] = minVal;
        }
        
        for(int i = 1; i < a.length-1 ; i++){
            if(a[i] > leftMin[i] && a[i] > rightMin[i]){
                continue;
            }
            answer++;
        }
        
        return answer;
    }
}