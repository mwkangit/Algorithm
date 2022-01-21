import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Input> q1 = new PriorityQueue<>(new Comparator<Input>(){
            @Override
            public int compare(Input i1, Input i2){
                return i1.num - i2.num;
            }
        });
        
        PriorityQueue<Input> q2 = new PriorityQueue<>(new Comparator<Input>(){
           @Override
            public int compare(Input i1, Input i2){
                return i2.num - i1.num;
            }
        });
        
        char op;
        int number;
        int size;
        for(int i = 0 ; i < operations.length ; i++){
            op = operations[i].charAt(0);
            number = Integer.parseInt(operations[i].substring(2));
                
            if(op == 'I'){
                if(!q2.isEmpty()){
                    q2.add(new Input(number));
                } else{
                    q1.add(new Input(number));
                }
            } else if(op == 'D'){
                if(q1.isEmpty() && q2.isEmpty()) continue;
                if(number == 1){
                    // System.out.println(q1.peek().num);
                    size = q1.size();
                    for(int j = 0 ; j < size ; j++){
                        q2.add(q1.poll());
                    }
                    q2.poll();
                } else{
                    size = q2.size();
                    for(int j = 0 ; j < size ; j++){
                        q1.add(q2.poll());
                    }
                    q1.poll();
                }
                
            }
            
            
        }
        int big = 0;
        int small = 0;
        if(q1.isEmpty() && q2.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        } else if(!q1.isEmpty()){
            small = q1.poll().num;
            size = q1.size();
            for(int i = 0 ; i < size ; i++){
                q2.add(q1.poll());
            }
            big = q2.peek().num;
        } else if(!q2.isEmpty()){
            big = q2.poll().num;
            size = q2.size();
            for(int i = 0 ; i < size ; i++){
                q1.add(q2.poll());
            }
            small = q1.peek().num;
        }
        answer[0] = big;
        answer[1] = small;
        return answer;
    }
    
    static class Input{
        int num;
        
        public Input(int n){
            num = n;
        }
    }
}
