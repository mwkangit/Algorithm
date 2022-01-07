import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    ArrayList<Integer> list = new ArrayList<>();
    boolean visit[] = new boolean[8];
    
    public int solution(String numbers) {
        
        
        String str = "";
        
        
        for(int i = 0 ; i < numbers.length() ; i++){
            permutation(numbers, str, i+1, 0);
        }
        
        System.out.print(list);
        
        for(int n : list){
            so(n);
        }
        
        return answer;
    }
    
    void permutation(String numbers, String str, int m, int d){
        if(d == m){
            int num = Integer.parseInt(str);
            if(!list.contains(num)){
                list.add(num);
            }
        } else {
            for(int i = 0 ; i < numbers.length() ; i++){
                if(!visit[i]){
                visit[i] = true;
                permutation(numbers, str + numbers.charAt(i), m, d + 1);    
                visit[i] = false;
                }
            }
            
            
        }
    }
    
    void so(int num){
        if(num == 0 || num == 1) return;
        int srt = (int)Math.sqrt(num);
        for(int i = 2 ; i <= srt ; i++){
            if(num % i == 0) return;
        }
        answer++;
    }
}
