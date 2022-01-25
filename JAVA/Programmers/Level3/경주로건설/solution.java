import java.util.*;
import java.io.*;

class Solution {
    
    int r[] = {0,1,0,-1};
    int c[] = {1,0,-1,0};
    int N;
    int INF = 987654321;
    
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        
        
        int graph[][][] = new int[N][N][4];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                Arrays.fill(graph[i][j], INF);
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        for(int i = 0 ; i < 4 ; i++){
            graph[0][0][i] = 0;
        }
        q.add(new Node(0,0,0,0));
        q.add(new Node(0,0,0,1));
        int cos;
        while(!q.isEmpty()){
            Node node = q.poll();
            int ro = node.row;
            int co = node.col;
            
            for(int i = 0 ; i < 4 ; i++){
                if(node.path == i){
                    cos = node.cost + 100;
                } else{
                    cos = node.cost + 600;
                }
                
                if(ro + r[i] >= 0 && ro + r[i] < N && co + c[i] >= 0 && co + c[i] < N && board[ro + r[i]][co + c[i]] != 1 && graph[ro + r[i]][co + c[i]][i] > cos){
                    graph[ro + r[i]][co + c[i]][i] = cos;
                    q.add(new Node(ro + r[i], co + c[i], cos, i));
                }
                
            }
            
            
        }
        int mini = INF;
        for(int i = 0 ; i < 4 ; i++){
            mini = Math.min(mini, graph[N-1][N-1][i]);
        }
        answer = mini;
        
        return answer;
    }
    
    static class Node{
        int row;
        int col;
        int cost;
        int path;
        
        public Node(int r, int c, int co, int p){
            row = r;
            col = c;
            cost = co;
            path = p;
        }
    }
}
