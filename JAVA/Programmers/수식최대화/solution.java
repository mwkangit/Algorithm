import java.util.*;
import java.io.*;

class Solution {
    public long solution(String expression) {
        // System.out.println(expression);
        long answer = 0;
        ArrayList<Long> num_list = new ArrayList<>();
        ArrayList<Character> char_list = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        String sub = "";
        int count = expression.length();
       
        for(int i = 0 ; i < count ; i++){
            if(Character.isDigit(expression.charAt(i))){
                sub += expression.charAt(i);
                continue;
            }else{
                num_list.add(Long.parseLong(sub));
                sub = "";
                char_list.add(expression.charAt(i));
                if(!chars.contains(expression.charAt(i))){
                    chars.add(expression.charAt(i));
                }
            }
        }
        num_list.add(Long.parseLong(sub));
       
        // for(int i = 0 ; i < num_list.size() ; i++){
        //     System.out.print(num_list.get(i));
        // }
        
        Collections.sort(chars);
       
        long maxi = 0;
        // List<Long> subNum = new ArrayList<>();
        // List<Character> subChar = new ArrayList<>();
            
        do{
            // subNum.clear();
            // subChar.clear();
            // subNum.addAll(num_list);
            // subChar.addAll(char_list);
            ArrayList<Long> subNum = (ArrayList<Long>) num_list.clone();
            ArrayList<Character> subChar = (ArrayList<Character>) char_list.clone();
            
            for(int i = 0 ; i < chars.size() ; i++){
                for(int j = 0 ; j < subChar.size() ; j++){
                    if(subChar.get(j) == chars.get(i)){
                        if(chars.get(i) == '+'){
                            subNum.set(j, subNum.get(j) + subNum.get(j+1));
                        }
                        if(chars.get(i) == '-'){
                            subNum.set(j, subNum.get(j) - subNum.get(j+1));
                        }
                        if(chars.get(i) == '*'){
                            subNum.set(j, subNum.get(j) * subNum.get(j+1));
                        }
                        subNum.remove(j+1);
                        subChar.remove(j);
                        j--;
                    }
                        
                }
            }
            
            maxi = Math.max(maxi, Math.abs(subNum.get(0)));
            
           // for(int i = 0 ; i < chars.size() ; i++){
           //     System.out.print(chars.get(i));
           // }
           //  System.out.println();
           
        }while(next_permutation(chars));
       
        // System.out.print(next_permutation(chars));
        answer = maxi;
       
        return answer;
    }
    static boolean next_permutation(List<Character> chars){
        int i = chars.size() - 1;
        int j = chars.size() - 1;
       
        while(i > 0 && chars.get(i-1) >= chars.get(i)) --i;
        if(i <= 0) return false;
       
        while(chars.get(i-1) > chars.get(j)) --j;
        char sub = chars.get(i-1);
        chars.set(i-1, chars.get(j));
        chars.set(j, sub);
        
        j = chars.size() - 1;
        
        for(; i < j ; ++i, --j){
            sub = chars.get(i);
            chars.set(i, chars.get(j));
            chars.set(j, sub);
        }
        
        return true;
       
    }
}
