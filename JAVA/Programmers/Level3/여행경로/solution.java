import java.util.*;
import java.io.*;

class Solution {
    
    boolean visit[];
    ArrayList<String> result = new ArrayList<>();
    int N;
    
    public String[] solution(String[][] tickets) {
        
        visit = new boolean[tickets.length];
        for(int i = 0 ; i < tickets.length ; i++){
            if(tickets[i][0].equals("ICN")){
                ArrayList<String> sub = new ArrayList<>();
                sub.add(tickets[i][1]);
                visit[i] = true;
                dfs(tickets, sub, 0);
                visit[i] = false;
            }
        }
        
        Collections.sort(result, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });
                
        String[] answer = new String[tickets.length+1];
        for(int i = 0 ; i < tickets.length + 1 ; i++){
            answer[i] = result.get(0).substring(i * 3, i * 3 + 3);
        }
        return answer;
    }
    
    public void dfs(String[][] tickets, ArrayList<String> str, int d){
        if(d+1 == tickets.length){
            String sub2 = "ICN";
            for(String s : str){
                sub2 += s;
            }
            result.add(sub2);
            return;
        } else{
            for(int i = 0 ; i < tickets.length ; i++){
                if(!visit[i] && tickets[i][0].equals(str.get(d))){
                    visit[i] = true;
                    str.add(tickets[i][1]);
                    dfs(tickets, str, d + 1);
                    str.remove(d+1);
                    visit[i] = false;
                }
            }
        }
    }
    
}
