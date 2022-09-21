package programmers.gatheringStickers;

import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = sticker[0];
        
        int dp[] = new int[sticker.length];
        
        dp[0] = sticker[0];
        
        for(int i = 2 ; i < sticker.length-1 ; i++){
            if(i == 2){
                dp[i] = dp[0] + sticker[i];
            }else{
                dp[i] = Math.max(dp[i-2], dp[i-3]) + sticker[i];
            }
            answer = Math.max(answer, dp[i]);
        }
        
        if(sticker.length > 1){
            dp = new int[sticker.length];
        
            dp[1] = sticker[1];
            answer = Math.max(answer, sticker[1]);
        
            for(int i = 3 ; i < sticker.length ; i++){
                dp[i] = Math.max(dp[i-2], dp[i-3]) + sticker[i];
                
                answer = Math.max(answer, dp[i]);
            }
        }
        
        if(sticker.length > 2){
            dp = new int[sticker.length];
        
            dp[2] = sticker[2];
            answer = Math.max(answer, sticker[2]);
        
            for(int i = 4 ; i < sticker.length ; i++){
                dp[i] = Math.max(dp[i-2], dp[i-3]) + sticker[i];
                
                answer = Math.max(answer, dp[i]);
            }
        }
        
        
        return answer;
    }
}