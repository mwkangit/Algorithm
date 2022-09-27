package programmers.splitPowerGrid;

import java.util.*;

class Solution {
    static int graph[][];
    
    public int solution(int n, int[][] wires) {
        graph = new int[n+1][n+1];
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < n-1 ; i++){
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i = 0 ; i < n-1 ; i++){
            graph[wires[i][0]][wires[i][1]] = 0;
            graph[wires[i][1]][wires[i][0]] = 0;
            
            int result[] = new int[2];
            boolean visit[] = new boolean[n+1];
            for(int j = 1 ; j <= n ; j++){
                if(!visit[j]){
                    if(result[0] == 0){
                        result[0] = bfs(visit, j, n);
                    } else{
                        result[1] = bfs(visit, j, n);
                    }
                    
                }
            }
            answer = Math.min(answer, Math.abs(result[0] - result[1]));
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }
        
        return answer;
    }
    static int bfs(boolean visit[], int num, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visit[num] = true;
        int count = 1;
        
        while(!q.isEmpty()){
            int number = q.poll();
            
            for(int i = 1 ; i < n+1 ; i++){
                if(graph[number][i] == 1 && !visit[i]){
                    visit[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        return count;
        
    }
    
}