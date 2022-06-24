package programmers.menuRenewal;

import java.util.*;

class SolutionAgain {
    
    static HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int i = 0 ; i < orders.length ; i++){
            char array[] = orders[i].toCharArray();
            Arrays.sort(array);
            orders[i] = new String(array);
        }
        
        for(int i = 0 ; i < orders.length ; i++){
            dfs(orders[i], 0, new StringBuilder());
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < course.length ; i++){
            int maxi = 0;
            for(String str : map.keySet()){
                if(map.get(str) > 1 && str.length() == course[i]){
                    maxi = Math.max(maxi, map.get(str));
                }
            }
            for(String str : map.keySet()){
                if(map.get(str) == maxi && str.length() == course[i]){
                    list.add(str);
                }
            }
        }
        
        Collections.sort(list);
        String answer[] = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static void dfs(String target, int curr, StringBuilder sb){
        if(sb.length() > 1){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        for(int i = curr ; i < target.length() ; i++){
            sb.append(target.charAt(i));
            dfs(target, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
