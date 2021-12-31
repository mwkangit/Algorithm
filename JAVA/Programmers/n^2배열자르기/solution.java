import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        int left_row = (int)(left / n);
        int left_col = (int)(left % n);
        int right_row = (int)(right / n);
        int right_col = (int)(right % n);
        
        int graph[][] = new int[(int)(right_row - left_row + 1)][n];
        
        int cur_row2 = left_row + 1;
        
        for(int i = 0 ; i < graph.length ; i++){
            int cur_row = cur_row2;
            for(int j = 0 ; j < cur_row ; j++){
                graph[i][j] = cur_row;
            }
            
            for(int j = cur_row ; j < n ; j++){
                cur_row++;
                graph[i][j] = cur_row;
            }
            
            cur_row2++;
            
        }
        
        // for(int i = 0 ; i < graph.length ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
        
        int index = 0;
        
        if(left_row == right_row){
            for(int i = left_col ; i <= right_col ; i++){
                answer[index] = graph[0][i];
                index++;
            }
        } else{
            for(int i = left_col ; i < n ; i++){
                answer[index] = graph[0][i];
                index++;
            }
            
            if(right_row - left_row >= 2){
                for(int i = 1 ; i < graph.length - 1 ; i++){
                    for(int j = 0 ; j < n ; j++){
                        answer[index] = graph[i][j];
                        index++;
                    }
                }
            }
            
            for(int i = 0 ; i <= right_col ; i++){
                answer[index] = graph[graph.length-1][i];
                index++;
            }
            
        }
        
        
        
        
        
        
        
        return answer;
    }
}
