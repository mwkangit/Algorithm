package programmers.undestroyedBuilding;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int graph[][] = new int[board.length+1][board[0].length+1];
        for(int i = 0 ; i < skill.length ; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == 1){
                graph[r1][c1] -= degree;
                graph[r2+1][c2+1] -= degree;
                graph[r2+1][c1] += degree;
                graph[r1][c2+1] += degree;
            }else{
                graph[r1][c1] += degree;
                graph[r2+1][c2+1] += degree;
                graph[r2+1][c1] -= degree;
                graph[r1][c2+1] -= degree;
            }
        }
        
        for(int i = 0 ; i < graph.length ; i++){
            int num = 0;
            for(int j = 0 ; j < graph[0].length ; j++){
                num += graph[i][j];
                graph[i][j] = num;
            }
        }
        for(int j = 0 ; j < graph[0].length ; j++){
            int num = graph[0][j];
            for(int i = 1 ; i < graph.length ; i++){
                graph[i][j] += num;
                num = graph[i][j];
            }
        }
        for(int i = 0 ; i < graph.length-1 ; i++){
            for(int j = 0 ; j < graph[0].length-1 ; j++){
                if(board[i][j] + graph[i][j] > 0)answer++;
            }
        }
        
        return answer;
    }
}