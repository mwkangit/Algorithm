import java.util.*;
import java.io.*;

class Solution {
    HashMap<String, Sell> map = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for(int i = 0 ; i < enroll.length ; i++){
            map.put(enroll[i], new Sell(referral[i]));
        }
        
        for(int i = 0 ; i < seller.length ; i++){
            map.get(seller[i]).amount.add(amount[i] *100);
        }
        
        for(int i = 0 ; i < enroll.length ; i++){
            if(map.get(enroll[i]).amount.size() == 0){
                map.get(enroll[i]).amount.add(0);
            }
        }
        
        for(int i = 0 ; i < enroll.length ; i++){
            for(int j = 0 ; j < map.get(enroll[i]).amount.size() ; j++){
                System.out.println(j);
                map.get(enroll[i]).in.add(map.get(enroll[i]).amount.get(j));               
            }
        }
        
        
        for(int i = enroll.length-1 ; i >= 0 ; i--){
            String cur = enroll[i];
            ArrayList<Integer> sub = map.get(cur).in;
            for(int j = 0 ; j < sub.size() ; j++){
                int money = sub.get(j) / 10;
                if(money < 1){
                    map.get(cur).total += sub.get(j);
                } else{
                    if(!map.get(cur).ref.equals("-")){
                        map.get(map.get(cur).ref).in.add(money);
                    }
                    map.get(cur).total += sub.get(j) - money;    
                    
                }
            }
        }
        
        int index = 0;
        for(String s : enroll){
            answer[index++] = map.get(s).total;
        }
        
        
        return answer;
    }
    
    
    static class Sell{
        String ref;
        ArrayList<Integer> amount = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        int total = 0;
        
        public Sell(String r){
            ref = r;
        }
    }
}
