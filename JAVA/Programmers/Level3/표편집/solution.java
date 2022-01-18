import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        Stack<Integer> stk = new Stack<>();

        int len = n;
        char com;
        int move;
        int re;
        for(int i = 0 ; i < cmd.length ; i++){
            com = cmd[i].charAt(0);

            if(com == 'D'){
                move = Integer.parseInt(cmd[i].substring(2));
                k += move;
            } else if(com == 'U'){
                move = Integer.parseInt(cmd[i].substring(2));
                k -= move;
            } else if(com == 'C'){
                stk.push(k);
                if(k == len - 1){
                    k--;
                }
                len -= 1;
            } else if(com == 'Z'){
                re = stk.pop();
                if(re <= k) k++;
                len++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < len ; i++){
            sb.append("O");
        }
        while(!stk.isEmpty()){
            sb.insert(stk.pop().intValue(), 'X');
        }
        answer = sb.toString();

        return answer;
    }
}
