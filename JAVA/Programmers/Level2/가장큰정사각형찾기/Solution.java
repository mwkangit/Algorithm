package programmers.mostLargestSquare;

import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int dp[][] = new int[board.length+1][board[0].length+1];
        int up[][] = new int[board.length+1][board[0].length+1];
        int left[][] = new int[board.length+1][board[0].length+1];
        
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                if(board[i-1][j-1] == 1){
                    up[i][j] = up[i-1][j] + 1;
                    left[i][j] = left[i][j-1] + 1;
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(up[i-1][j], left[i][j-1])) + 1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }

        return answer * answer;
    }
    
}