import java.util.*;
import java.io.*;

class Solution {
    public int solution(int N, int number) {
        
        HashSet<Integer> set[] = new HashSet[9];
        for(int i = 1 ; i <= 8 ; i++){
            set[i] = new HashSet<>();
        }
        
        set[1].add(N);
        
        for(int i = 1 ; i <= 8 ; i++){
            if(i > 1){
                String str = "";
                for(int j = 0 ; j < i ; j++){
                    str += String.valueOf(N);
                }
                set[i].add(Integer.parseInt(str));
                for(int j = 1 ; j < i ; j++){
                    for(int n1 : set[j]){
                        for(int n2 : set[i - j]){
                            set[i].add(n1 + n2);
                            set[i].add(n1 - n2);
                            set[i].add(n1 * n2);
                            if(n2 != 0){
                                set[i].add(n1 / n2);
                            }
                        }
                    }
                }
            }
            
            if(set[i].contains(number)){
                return i;
            }
        }
        
        return -1;
    }
}
