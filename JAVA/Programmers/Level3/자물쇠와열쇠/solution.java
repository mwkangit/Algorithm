import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;
        
        for(int i = 0 ; i < 4 ; i++){
            key = rotateKey(key, i);
            int[][] keyPad = padding(key, len);
            
            for(int j = 0 ; j < keyPad.length - lock.length + 1 ; j++){
                for(int k = 0 ; k < keyPad.length - lock.length + 1 ; k++){
                    boolean flag = true;
                    
                    for(int l = 0 ; l < lock.length ; l++){
                        for(int m = 0 ; m < lock.length ; m++){
                            if(keyPad[j + l][k + m] == lock[l][m]) flag = false;
                        }
                    }
                    if(flag) return true;
                }
            }
            
            
        }
        
        return false;
    }
    
    public int[][] padding(int[][] key, int len){
        
        int sub[][] = new int[key.length + (len - 1) * 2][key.length + (len - 1) * 2];
        
        for(int i = len - 1 ; i < key.length + len - 1 ; i++){
            for(int j = len - 1 ; j < key.length + len - 1 ; j++){
                sub[i][j] = key[i - len + 1][j - len + 1];
            }
        }
        
        return sub;
        
    }
    
    public int[][] rotateKey(int[][] key, int index){
        if(index == 0){
            return key;
        }
        
        int[][] sub = new int[key.length][key.length];
      
        for(int i = 0 ; i < key.length ; i++){
            for(int j = 0 ; j < key.length ; j++){
                sub[i][j] = key[key.length - j - 1][i];
            }
        }
        
        return sub;
    }
    
}
