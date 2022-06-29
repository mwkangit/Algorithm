package programmers.binaryExchangeLoop;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> list = new LinkedList<>();
        int answer = 0;
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(int i = 0 ; i < cities.length ; i++){
            cities[i] = cities[i].toLowerCase();
            boolean flag = true;
            if(list.size() == 0){
                list.add(cities[i]);
                answer += 5;
            } else{
                for(int j = 0 ; j < list.size() ; j++){
                    if(j > cacheSize){
                        break;
                    } else{
                        if(list.get(j).equals(cities[i])){
                            answer++;
                            list.remove(j);
                            list.add(cities[i]);
                            flag = false;
                            break;
                        }
                    }

                }
                if(flag) {
                    if(list.size() == cacheSize){
                        list.remove(0);
                    }
                    list.add(cities[i]);
                    answer += 5;
                    
                }
            }
            
        }
        
        
        return answer;
    }
}
