import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        int A = Math.min(a, b);
        int B = Math.max(a, b);
        
        
        
        while(true){
            answer++;
            if(B - A == 1 && A % 2 == 1)break;
            
            A = (A+1) / 2;
            B = (B+1) / 2;            
            
            
        }
        
        
        
        return answer;
    }
}
