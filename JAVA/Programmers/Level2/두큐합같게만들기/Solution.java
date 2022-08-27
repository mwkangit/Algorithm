package programmers.equalSumTwoQueue;

import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    static long curr1 = 0;
    static long curr2 = 0;
    static long due;
    
    public int solution(int[] queue1, int[] queue2) {
        for(int i = 0 ; i < queue1.length ; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            curr1 += queue1[i];
            curr2 += queue2[i];
        }
        due = (curr1 + curr2) / 2;
        if((curr1 + curr2) % 2 == 1)return -1;
        
        int count = 0;
        int limit = queue1.length * 3;
        boolean flag = false;
        while(count <= limit){
            if(curr1 == curr2){
                flag = true;
                break;
            }else if(curr1 > curr2){
                int sub = q1.poll();
                q2.add(sub);
                curr1 -= sub;
                curr2 += sub;
            }else{
                int sub = q2.poll();
                q1.add(sub);
                curr2 -= sub;
                curr1 += sub;
            }
            count++;
        }
        answer = (flag ? count : -1);
        
        
        
        
        return answer;
    }
}