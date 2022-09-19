package programmers.calculatingParkingFee;

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> totalMap = new HashMap<>();
        
        for(int i = 0 ; i < records.length ; i++){
            String str[] = records[i].split(" ");
            String timeStr[] = str[0].split("[:]");
            int time = Integer.parseInt(timeStr[0])*60 + Integer.parseInt(timeStr[1]);
            if(str[2].equals("IN")){
                map.put(str[1], time);
            }else{
                int total = time - map.get(str[1]);
                totalMap.put(str[1], totalMap.getOrDefault(str[1], 0) + total);
                map.remove(str[1]);
            }
        }
        int lastTime = 23 * 60 + 59;
        for(String s : map.keySet()){
            int total = lastTime - map.get(s);
            totalMap.put(s, totalMap.getOrDefault(s, 0) + total);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
           @Override
            public int compare(Node n1, Node n2){
                return n1.num.compareTo(n2.num);
            }
        });
        for(String s : totalMap.keySet()){
            int time = totalMap.get(s);
            time -= fees[0];
            if(time <= 0){
                pq.add(new Node(s, fees[1]));
            }else{
                int left = time / fees[2];
                int namo = time % fees[2];
                if(namo != 0){
                    left++;
                }
                pq.add(new Node(s, fees[1] + fees[3]*left));
            }
        }
        
        int answer[] = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            answer[index++] = node.fee;
        }
        
        return answer;
    }
    
    static class Node{
        String num;
        int fee;
        
        public Node(String n, int f){
            num = n;
            fee = f;
        }
    }
}