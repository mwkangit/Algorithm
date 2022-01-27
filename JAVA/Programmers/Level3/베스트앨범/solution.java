import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, ArrayList<Node>> map2 = new HashMap<>();
        
        for(int i = 0 ; i < genres.length ; i++){
            if(!map1.containsKey(genres[i])){
                map1.put(genres[i], plays[i]);
                ArrayList<Node> sub = new ArrayList<>();
                sub.add(new Node(i, plays[i]));
                map2.put(genres[i], sub);
            } else{
                map1.put(genres[i], map1.get(genres[i]) + plays[i]);
                map2.get(genres[i]).add(new Node(i, plays[i]));
            }
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p2.total - p1.total;
            }
        });
        for(String s : map1.keySet()){
            q.add(new Pair(s, map1.get(s)));
        }
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            
            Collections.sort(map2.get(pair.gen), new Comparator<Node>(){
               @Override
                public int compare(Node n1, Node n2){
                    if(n2.play > n1.play){
                        return 1;
                    } else if(n2.play == n1.play){
                        return n1.index - n2.index;
                    }
                    return -1;
                }
            });
            int count = 0;
            for(int i = 0 ; i < map2.get(pair.gen).size() ; i++){
                count++;
                if(count >= 3) break;
                result.add(map2.get(pair.gen).get(i).index);
            }
            
        }
        int[] answer = new int[result.size()];
        
        
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
    
    static class Pair{
        String gen;
        int total;
        
        public Pair(String g, int t){
            gen = g;
            total = t;
        }
    }
    
    static class Node{
        int index;
        int play;
        
        public Node(int i, int p){
            index = i;
            play = p;
        }
    }
}
