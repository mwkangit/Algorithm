import java.util.*;
import java.io.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> times = new ArrayList<>();
        m = replace(m);
        
        for(int i = 0 ; i < musicinfos.length ; i++){
            String music[] = musicinfos[i].split(",");
            
            music[3] = replace(music[3]);
            
            String start[] = music[0].split(":");
            String end[] = music[1].split(":");
            int time = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
            String str = "";
            int index = 0;
            for(int j = 0 ; j < time ; j++){
                index = j % music[3].length();
                str += music[3].charAt(index);
                
            }
            
            if(str.matches("(.*)" + m + "(.*)")){
                list.add(music[2]);
                times.add(time);
            }
            
        }
        
        if(list.size() == 1){
            answer = list.get(0);
        } else if(list.size() == 0){
            answer = "(None)";
        } else {
            int maxi = times.get(0);
            answer = list.get(0);
            for(int i = 1 ; i < list.size() ; i++){
                
                if(maxi < times.get(i)){
                    maxi = times.get(i);
                    answer = list.get(i);
                }
                
            }
        }
            
        
        return answer;
    }
    
    public String replace(String str){
        str = str.replaceAll("C#", "Z");
        str = str.replaceAll("D#", "Y");
        str = str.replaceAll("F#", "X");
        str = str.replaceAll("G#", "W");
        str = str.replaceAll("A#", "V");
        return str;
    }
}
