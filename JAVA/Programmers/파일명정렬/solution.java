import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        ArrayList<pair> list = new ArrayList<>();
        
        for(int i = 0 ; i < files.length ; i++){
            String sub1 = "";
            int sub2 = 0;
            String sub3 = "";
            for(int j = 0 ; j < files[i].length() ; j++){
                if(Character.isDigit(files[i].charAt(j))){
                    sub1 = files[i].substring(0, j).toLowerCase();
                    for(int k = j ; k < files[i].length() ; k++){
                        if(!(Character.isDigit(files[i].charAt(k)))){
                            sub2 = Integer.parseInt(files[i].substring(j, k));
                            sub3 = files[i].substring(k);
                            break;
                        } else if(k + 1 == files[i].length()){
                            sub2 = Integer.parseInt(files[i].substring(j, k+1));
                            break;
                        }
                    }
                    break;
                }
            }
            list.add(new pair(sub1, sub2, sub3, i));
            
            
        }
        
        
        Collections.sort(list, new Comparator<pair>(){
            @Override
            public int compare(pair p1, pair p2){
                int comp = p1.first.compareTo(p2.first);
                if(comp == 0){
                    int comp2 = p1.second - p2.second;
                    return comp2;
                } else {
                    return comp;
                }
            }
        });
        
        
        
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = files[list.get(i).index];
        }
        
        return answer;
    }
    
    
    
    static class pair{
        String first;
        int second;
        String third;
        int index;
        
        public pair(String s1, int i, String s2, int i2){
            first = s1;
            second = i;
            third = s2;
            index = i2;
        }
        
        
    }
}
