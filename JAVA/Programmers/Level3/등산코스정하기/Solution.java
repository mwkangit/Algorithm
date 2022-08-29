package programmers.climbingCourse;

import java.util.*;

class Solution {
    
    static ArrayList<Node> list[];
    static HashSet<Integer> path = new HashSet<>();
    static HashSet<Integer> summit = new HashSet<>();
    static int answer[] = new int[2];
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        list = new ArrayList[n+1];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        for(int i = 1 ; i < n+1 ; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < paths.length ; i++){
            list[paths[i][0]].add(new Node(paths[i][1], paths[i][2]));
            list[paths[i][1]].add(new Node(paths[i][0], paths[i][2]));
        }
        
        for(int i = 0 ; i < gates.length ; i++){
            path.add(gates[i]);
        }
        for(int i = 0 ; i < summits.length ; i++){
            summit.add(summits[i]);
        }
        
        for(int i = gates.length-1 ; i >= 0 ; i--){
            bfs(i, gates, summits, n);
        }
        
        return answer;
    }
    static void bfs(int num, int gates[], int summits[], int n){
        PriorityQueue<Inten> pq = new PriorityQueue<>(new Comparator<Inten>(){
           @Override
            public int compare(Inten i1, Inten i2){
                return i1.val - i2.val;
            }
        });
        pq.add(new Inten(gates[num], 0));
        int wei[] = new int[n+1];
        Arrays.fill(wei, Integer.MAX_VALUE);
        wei[gates[num]] = 0;
        boolean visit[] = new boolean[n+1];
        
        int summ = Integer.MAX_VALUE;
        int intensity = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            Inten inten = pq.poll();
            
            if(summit.contains(inten.num)){
                
                if(intensity > inten.val){
                    intensity = inten.val;
                    summ = inten.num;
                }else if(intensity == inten.val){
                    if(summ > inten.num){
                        intensity = inten.val;
                        summ = inten.num;
                    }
                }
                continue;
            }
            if(visit[inten.num])continue;
            visit[inten.num] = true;
            for(int i = 0 ; i < list[inten.num].size() ; i++){
                Node node = list[inten.num].get(i);
                if(path.contains(node.num))continue;
                if(wei[node.num] >= node.weight && node.weight <= answer[1]){
                    wei[node.num] = Math.max(inten.val, node.weight);
                    pq.add(new Inten(node.num, wei[node.num]));
                }
            }
        }
        
        if(answer[1] >  intensity){
            answer[0] = summ;
            answer[1] = intensity;
        }else if(answer[1] == intensity){
            if(answer[0] > summ){
                answer[0] = summ;
                answer[1] = intensity;
            }
        }
        
    }
    
    static class Inten{
        int num, val;
        public Inten(int n , int v){
            num = n;
            val = v;
        }
    }
    static class Node{
        int num, weight;
        public Node(int n, int w){
            num = n;
            weight = w;
        }
    }
}