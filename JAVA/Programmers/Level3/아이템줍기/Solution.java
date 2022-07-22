package programmers.pickupItem;

import java.util.*;

class Solution {
    
    static int r[] = {0, 1, 0, -1};
    static int c[] = {1, 0, -1, 0};
    static ArrayList<Node> recList = new ArrayList<>();
    static int answer = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int i = 0 ; i < rectangle.length ; i++){
            recList.add(new Node(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2));
        }
        
        bfs(characterY*2, characterX*2, itemY*2, itemX*2);
        
        return answer;
    }
    static void bfs(int cRow, int cCol, int iRow, int iCol){
        boolean visit[][] = new boolean[101][101];
        Queue<Curr> q = new LinkedList<>();
        visit[cRow][cCol] = true;
        q.add(new Curr(cRow, cCol, 0));
        
        while(!q.isEmpty()){
            Curr curr = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ro = curr.row + r[i];
                int co = curr.col + c[i];
                
                if(ro == iRow && co == iCol){
                    answer = (curr.count+1) / 2;
                    return;
                }
                
                if(ro < 0 || ro > 100 || co < 0 || co > 100 || visit[ro][co])continue;
                if(!check(ro, co))continue;
                
                visit[ro][co] = true;
                q.add(new Curr(ro, co, curr.count+1));
            }
        }
        
    }
    static boolean check(int row, int col){
        boolean flag= false;
        for(int i = 0 ; i < recList.size() ; i++){
            Node node = recList.get(i);
            if(row > node.LRow && col > node.LCol && row < node.RRow && col < node.RCol)return false;
            else if(row >= node.LRow && row <= node.RRow && col == node.LCol){
                flag = true;
            } else if(row >= node.LRow && row <= node.RRow && col == node.RCol){
                flag = true;
            } else if(col >= node.LCol && col <= node.RCol && row == node.LRow){
                flag = true;
            } else if(col >= node.LCol && col <= node.RCol && row == node.RRow){
                flag = true;
            }
        }
        if(!flag)return false;
        return true;
    }
    static class Curr{
        int row,col,count;
        public Curr(int r, int c, int co){
            row = r;
            col = c;
            count = co;
        }
    }
    
    static class Node{
        int LRow;
        int LCol;
        int RRow;
        int RCol;
        public Node(int LC, int LR, int RC, int RR){
            LCol = LC;
            LRow = LR;
            RCol = RC;
            RRow = RR;
        }
    }
}