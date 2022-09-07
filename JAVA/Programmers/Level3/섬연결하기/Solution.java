package programmers.uniteIslands;

import java.util.*;

class Solution {
    static int arr[];
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[2] - i2[2];
            }
        });
        
        int answer = 0;
        
        arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = i;
        }
        
        for(int i = 0 ; i < costs.length ; i++){
            int left = costs[i][0];
            int right = costs[i][1];
            int weight = costs[i][2];
            
            int Lparent = find(left);
            int Rparent = find(right);
            
            if(Lparent == Rparent)continue;
            
            arr[Lparent] = Rparent;
            answer += weight;
        }
        
        
        return answer;
    }
    static int find(int num){
        if(arr[num] == num){
            return num;
        }else{
            return arr[num] = find(arr[num]);
        }
    }
}