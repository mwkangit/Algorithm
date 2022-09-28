package programmers.checkDistance;

import java.util.*;

class Solution {
    static int r[] = {0, 1, 0, -1};
    static int c[] = {1, 0, -1, 0};
    static ArrayList<Integer> ans = new ArrayList<>();
    public int[] solution(String[][] places) {
        
        for(int i = 0 ; i < places.length ; i++){
            ArrayList<Node> list = new ArrayList<>();
            char arr[][] = new char[5][5];
            for(int j = 0 ; j < 5 ; j++){
               for(int k = 0 ; k < 5 ; k++){
                   char c = places[i][j].charAt(k);
                   if(c == 'P'){
                       list.add(new Node(j, k, 0));
                   }
                   arr[j][k] = c;
               }
            }
            bfs(arr, list);
        }
        int[] answer = new int[5];
        for(int i = 0 ; i < 5 ; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    static void bfs(char[][] arr, ArrayList<Node> list){
        
        // for(int i = 0 ; i < 5 ; i++){
        //     for(int j = 0 ; j < 5 ; j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        boolean flag = false;
        for(int i = 0 ; i < list.size() ; i++){
            boolean visit[][] = new boolean[5][5];
            Queue<Node> q = new LinkedList<>();
            q.add(list.get(i));
            visit[list.get(i).row][list.get(i).col] = true;
            while(!q.isEmpty()){
                Node node = q.poll();
                if(node.dist+1 >= 3){
                    break;
                }
                
                for(int j = 0 ; j < 4 ; j++){
                    int row = node.row + r[j];
                    int col = node.col + c[j];
                    
                    if(row < 0 || row >= 5 || col < 0 || col >=5 || arr[row][col] == 'X' || visit[row][col]) continue;
                    
                    if(arr[row][col] == 'P'){
                        // System.out.println(row + " " + col);
                        flag = true;
                        break;
                    }
                    visit[row][col] =true;
                    q.add(new Node(row, col, node.dist+1));
                    
                }
                if(flag) break;
            }
            if(flag) break;
        }
        if(flag) ans.add(0);
        else ans.add(1);
        
    }
    static class Node{
        int row;
        int col;
        int dist;
        public Node(int r, int c, int d){
            row = r;
            col = c;
            dist = d;
        }
    }
}