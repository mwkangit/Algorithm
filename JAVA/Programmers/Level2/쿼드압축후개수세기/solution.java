import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        int zero = 0;
        int one = 0;
                
        int count = arr.length;
        int sum;
        while(count > 0){
            // System.out.println(count);
            for(int i = 0 ; i < arr.length ; i = i + count){
                for(int j = 0 ; j < arr.length ; j = j + count){
                    sum = 0;
                    if(arr[i][j] !=3){
                        for(int k = 0 ; k < count ; k++){
                            for(int l = 0 ; l < count ; l++){
                                sum += arr[i+k][j+l];
                            }
                        }
                        if(sum == 0){
                            zero++;
                            for(int k = 0 ; k < count ; k++){
                                for(int l = 0 ; l < count ; l++){
                                    arr[i+k][j+l] = 3;
                                }
                            }
                        } else if(sum == count*count){
                            one++;
                            for(int k = 0 ; k < count ; k++){
                                for(int l = 0 ; l < count ; l++){
                                    arr[i+k][j+l] = 3;
                                }
                            }
                        }
                    }
                    
                }
            }
            count /= 2;
            
            
            
        }
        
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
}
