package programmers.spicier;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < scoville.length ; i++){
            pq.add(scoville[i]);
        }

        int count = 0;
        while(pq.size() > 1){
            if(pq.peek() < K){
                int num1 = pq.poll();
                int num2 = pq.poll();
                int num3 = num1 + (num2 * 2);
                pq.add(num3);
                count++;
            } else{
                break;
            }

        }

        if(pq.peek() < K){
            return -1;
        }else{
            return count;
        }

    }
}
