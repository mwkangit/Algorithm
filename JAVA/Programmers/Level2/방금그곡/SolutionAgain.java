package programmers.justThatSong;

import java.util.*;
//H, I, J, K, L
class SolutionAgain {
 public String solution(String m, String[] musicinfos) {
     
     m = converter(m);
     int maxi = -1;
     String answer = "(None)";
     
     for(int i = 0 ; i < musicinfos.length ; i++){
         String str[] = musicinfos[i].split("[,]");
         str[3] = converter(str[3]);
         String start[] = str[0].split("[:]");
         String end[] = str[1].split("[:]");
         int time = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
         StringBuilder sb = new StringBuilder();
         int index = 0;
         for(int j = 0 ; j <= time ; j++){
             if(index == str[3].length()){
                 index = 0;
             }
             sb.append(str[3].charAt(index));
             index++;
         }
         if(sb.toString().contains(m)){
             if(maxi < time){
                 maxi = time;
                 answer = str[2];
             }
         }
     }
     
     return answer;
 }
 static String converter(String str){
     str = str.replaceAll("C#", "H");
     str = str.replaceAll("D#", "I");
     str = str.replaceAll("F#", "J");
     str = str.replaceAll("G#", "K");
     str = str.replaceAll("A#", "L");
     
     return str;
 }
}