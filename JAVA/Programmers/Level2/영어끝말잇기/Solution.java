package programmers.englishWordChain;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        int answer[] = new int[2];
        boolean flag = true;
        for(int i = 0 ; i < words.length ; i++){
            if(i > 0){
                if(set.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                    count++;
                    if(count % n == 0){
                        answer[0] = n;
                        answer[1] = count / n;
                    } else{
                        answer[0] = count % n;
                        answer[1] = count / n + 1;
                    }
                    flag = false;
                    break;
                }else{
                    count++;
                    set.add(words[i]);
                }
            } else{
                count++;
                set.add(words[i]);
            }
        }
        if(flag){
            answer[0] = 0;
            answer[1] = 0;
        }
        

        return answer;
    }
}