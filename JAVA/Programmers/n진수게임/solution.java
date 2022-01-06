import java.util.*;
import java.io.*;

class Solution {
    ArrayList<Character> list = new ArrayList<>();
    HashMap<Integer, Character> map = new HashMap<>();
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        
        
        int turn = t * m;
        
        input(n, turn);
        int pos = p - 1;
        for(int i = 0 ; i < t ; i++){
            answer += list.get(pos);
            pos += m;
        }
        
        return answer;
    }
    
    public void input(int n, int turn){
        int count = 0;
        
        while(list.size() < turn){
            ArrayList<Character> list2 = new ArrayList<>();
            int sub = count;
            boolean flag = true;
            do{
                int sub2 = sub % n;
                if(sub2 >= 10){
                    list2.add(map.get(sub2)); 
                }else{
                    list2.add((char)(sub2 + '0'));   
                }
                sub /= n;
                
            }while(sub != 0);
            
            
            
            for(int i = list2.size() - 1 ; i >= 0 ; i--){
                list.add(list2.get(i));
            }
            
            count++;
        }
    }
        
            
        
        
}
