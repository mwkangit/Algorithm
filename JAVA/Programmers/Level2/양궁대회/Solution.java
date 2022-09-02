package programmers.archeryContest;

import java.util.*;

class Solution {
    static int N, infos[];
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int result = -1;
    static int end[] = new int[11];
    public int[] solution(int n, int[] info) {
        N = n;
        infos = info;
        
        for(int i = 0 ; i <= 10 ; i++){
            map.put(i, 0);
        }
        
        dfs(0, 0);
        
        if(result == -1){
            int answer[] = {-1};
            return answer;
        }else{
            return end;
        }
        
    }
    static void dfs(int curr, int total){
        if(total == N){
            int apeach = 0;
            int ryan = 0;
            for(int i = 0 ; i <= 10 ; i++){
                if(infos[10-i] < map.get(i)){
                    ryan += i;
                } else if(infos[10-i] == 0 && map.get(i) == 0){
                    continue;
                } else{
                    apeach += i;
                }
            }
            if(ryan > apeach){
                if(ryan - apeach > result){
                    result = ryan - apeach;
                    for(int i = 0 ; i <= 10 ; i++){
                        end[10-i] = map.get(i);
                    }
                }else if(ryan - apeach == result){
                    boolean flag = true;
                    for(int i = 0 ; i <= 10 ; i++){
                        if(end[10-i] < map.get(i)){
                            break;
                        }else if(end[10-i] > map.get(i)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        for(int i = 0 ; i <= 10 ; i++){
                            end[10-i] = map.get(i);
                        }
                    }
                }
            }
        }else{
            for(int i = curr ; i <= 10 ; i++){
                
                map.put(i, map.get(i) + 1);
                if(map.get(i) > infos[10-i]){
                    dfs(i+1, total+1);
                }else{
                    dfs(i, total+1);
                }
                map.put(i, map.get(i) - 1);
            }
        }
    }
}