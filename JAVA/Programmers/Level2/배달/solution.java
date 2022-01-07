import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Node> list[];
    static boolean visit[];
    static int dist[];
    static int INF = 987654321;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        
        dist = new int[N+1];
        visit = new boolean[N+1];
        
        list = new ArrayList[N+1];
        
        for(int i = 0 ; i <= N ; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < road.length ; i++){
            list[road[i][0]].add(new Node(road[i][1], road[i][2]));
            list[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        // for(int i = 0 ; i < list.length ; i++){
        //     for(int j = 0 ; j < list[i].size() ; j++){
        //         System.out.println(list[i].get(j) + " ");    
        //     }
        //     System.out.println();            
        // }
        
        Arrays.fill(dist, INF);
        
        dijkstra(1);
        
        for(int n : dist){
            // System.out.println(n);
            if(n <= K) answer++;
        }

        return answer;
    }
    
    static void dijkstra(int start){
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;
        
        
        while(!q.isEmpty()){
            Node nod = q.poll();
            int cur = nod.number;
            
            if(visit[cur] == true) continue;
            visit[cur] = true;
            
            for(Node n : list[cur]){
                if(dist[n.number] > dist[cur] + n.weight){
                    dist[n.number] = dist[cur] + n.weight;
                    q.add(new Node(n.number, dist[n.number]));
                }
                
            }
            
            
            
        }
        
        
        
    }
    
    static class Node implements Comparable<Node>{
        
        int number;
        int weight;
        
        public Node(int number, int weight){
            this.number = number;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
        
    }
}
