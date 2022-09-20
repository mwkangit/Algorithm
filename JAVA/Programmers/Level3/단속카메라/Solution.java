package programmers.surveillanceCamera;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, new Comparator<int[]>(){
           
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });
        
        
        int num = routes[0][1];
        int answer = 1;
        for(int i = 1 ; i < routes.length ; i++){
            int left = routes[i][0];
            int right = routes[i][1];
            if(num >= left && num >= right){
                num = right;
                continue;
            }else if(num >= left){
                continue;
            }else{
                answer++;
                num = right;
            }
        }
        
        return answer;
    }
}