import java.util.*;
import java.io.*;



class Solution {
    
    boolean visit[];
    int answer = 0;
    ArrayList<String> list3 = new ArrayList<>();
    
    public int solution(String[][] relation) {
        
        visit = new boolean[relation[0].length];
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < relation[0].length ; i++){
            list.add(i);
            // System.out.print(list.get(i));
        }
        
        
        
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 1 ; i <= relation[0].length ; i++){
            dfs(relation, list2, list, i, 0);
        }
        
        answer = list3.size();
        return answer;
    }
    
    public void dfs(String[][] relation, ArrayList<Integer> list2, ArrayList<Integer> list, int m, int d){
        
        if(list2.size() == m){
            // for(int i = 0 ; i < list2.size() ; i++){
            //     System.out.print(list2.get(i));
            // }
            // System.out.println();
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0 ; i < relation.length ; i++){
                String str = "";
                for(int j = 0 ; j < list2.size() ; j++){
                    str += relation[i][list2.get(j)];
                }
                if(map.containsKey(str)){
                    return;
                } else{
                    map.put(str, 1);
                }
            }
            String str = "";
            for(int i = 0 ; i < list2.size() ; i++){
                str += String.valueOf(list2.get(i));
            }
            for(String s : list3){
                int count = 0;
                for(int j = 0 ; j < str.length() ; j++){
                    String c = String.valueOf(str.charAt(j));
                    if(s.contains(c)) count++;
                }
                if(count == s.length()) return;
            }
            list3.add(str);
        } else{
            for(int i = d ; i < list.size() ; i++){
                if(!visit[i]){
                    visit[i] = true;
                    list2.add(list.get(i));
                    dfs(relation, list2, list, m, i+1);
                    visit[i] = false;
                    list2.remove(list2.size()-1);
                    
                }
            }
        }
        
    }

}
