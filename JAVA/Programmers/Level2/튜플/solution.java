import java.util.*;
import java.io.*;


class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length());
        s = s.substring(0, s.length()-2);
        String str[] = s.split("},\\{");
        
         Arrays.sort(str,new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < str.length ; i++){
            String str2[] = str[i].split(",");
            for(int j = 0 ; j < str2.length ; j++){
                if(!list.contains(str2[j])){
                    list.add(str2[j]);
                }
            }
            
        }
        
        int len = list.size();
        
        int[] answer = new int[len];
        
        for(int i = 0 ; i < len ; i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}
