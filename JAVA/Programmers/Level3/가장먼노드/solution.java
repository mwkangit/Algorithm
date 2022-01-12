import java.util.*;
import java.io.*;

class Solution {
    
    boolean visit[];
    ArrayList<node> list[];
    int[] dist;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visit = new boolean[n+1];
        list = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, 987654321);
        
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i[] : edge){
            list[i[0]].add(new node(i[1], 1));
            list[i[1]].add(new node(i[0], 1));
        }
        
        PriorityQueue<node> q = new PriorityQueue<>(new Comparator<node>(){
            @Override
            public int compare(node n1, node n2){
                return n1.weight - n2.weight;
            }
        });
        q.add(new node(1, 0));
        dist[1] = 0;
        
        while(!q.isEmpty()){
            node nod = q.poll();
            int cur = nod.num;
            
            if(visit[cur] == true) continue;
            visit[cur] = true;
            
            for(node no : list[cur]){
                if(dist[no.num] > dist[cur] + no.weight){
                    dist[no.num] = dist[cur] + no.weight;
                    q.add(new node(no.num, dist[no.num]));
                }
            }
            
            
        }
        int maxi = 0;
        for(int i = 1 ; i < dist.length ; i++){
            if(dist[i] == 987654321) continue;
            maxi = Math.max(maxi, dist[i]);
        }
        
        for(int i = 1 ; i < dist.length ; i++){
            if(maxi == dist[i]){
                answer++;
            }
        }
        
        
        
        return answer;
    }
    
    static class node{
        int num;
        int weight;
        
        public node(int n, int w){
            num = n;
            weight = w;
        }
        
        
    }
    
    
}
