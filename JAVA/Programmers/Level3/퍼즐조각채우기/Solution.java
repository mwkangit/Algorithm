package programmers.fillPuzzle;

import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Node>> gameList = new ArrayList<ArrayList<Node>>();
    static ArrayList<ArrayList<Node>> tableList = new ArrayList<ArrayList<Node>>();
    
    static boolean fit[];
    
    static int r[] = {0, 1, 0, -1};
    static int c[] = {1, 0, -1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        
        boolean [][]visitG = new boolean[game_board.length][game_board[0].length];
        boolean [][]visitT = new boolean[table.length][table[0].length];
        
        for(int i = 0 ; i < game_board.length ; i++){
            for(int j = 0 ; j < game_board[0].length ; j++){
                if(game_board[i][j] == 0 && !visitG[i][j]){
                    gameList.add(bfs(i, j, game_board.length, game_board[0].length, game_board, 0, visitG));
                }
            }
        }
        for(int i = 0 ; i < table.length ; i++){
            for(int j = 0 ; j < table[0].length ; j++){
                if(table[i][j] == 1 && !visitT[i][j]){
                    tableList.add(bfs(i, j, table.length, table[0].length, table, 1, visitT));
                }
            }
        }
        fit = new boolean[tableList.size()];
        
        int answer = search();
        
        
        return answer;
    }
    static int search(){
        int result = 0;
        for(int i = 0 ; i < gameList.size() ; i++){
            
            for(int j = 0 ; j < tableList.size() ; j++){
                if(!fit[j] && gameList.get(i).size() == tableList.get(j).size()){
                    if(rotate(gameList.get(i), tableList.get(j))){
                        fit[j] = true;
                        result += tableList.get(j).size();
                        break;
                    }
                }
                
            }
        }
        return result;
    }
    static boolean rotate(ArrayList<Node> game, ArrayList<Node> table){
        boolean flag;
        for(int i = 0 ; i < 4 ; i++){
            flag = true;
            for(int j = 0 ; j < game.size() ; j++){
                if((game.get(j).row != table.get(j).row) || (game.get(j).col != table.get(j).col)){
                    flag = false;
                    break;
                }
            }
            if(flag)return true;
            
            for(int j = 0 ; j < table.size() ; j++){
                int sub = table.get(j).row;
                table.get(j).row = table.get(j).col;
                table.get(j).col = (sub * -1);
            }
            Collections.sort(table, new Comparator<Node>(){
               @Override
                public int compare(Node n1, Node n2){
                    if(n1.row > n2.row){
                        return 1;
                    }else if(n1.row == n2.row){
                        return n1.col - n2.col;
                    }else{
                        return -1;
                    }
                }
            });
            int rowMinus = table.get(0).row;
            int colMinus = table.get(0).col;
            for(int j = 0 ; j < table.size() ; j++){
                table.get(j).row -= rowMinus;
                table.get(j).col -= colMinus;
            }
        }
        return false;
    }
    
    static ArrayList<Node> bfs(int row, int col, int N, int M, int [][]board, int diff, boolean[][]visit){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));
        visit[row][col] = true;
        
        ArrayList<Node> sub = new ArrayList<>();
        sub.add(new Node(0, 0));
        
        while(!q.isEmpty()){
            Node nod = q.poll();
            
            for(int i = 0 ; i < 4 ; i++){
                int ro = nod.row + r[i];
                int co = nod.col + c[i];
                
                if(ro < 0 || ro >= N || co < 0 || co >= M || visit[ro][co] || board[ro][co] != diff) continue;
                visit[ro][co] = true;
                q.add(new Node(ro, co));
                sub.add(new Node(ro - row, co - col));
                
            }
            
        }
        
        Collections.sort(sub, new Comparator<Node>(){
           @Override
            public int compare(Node n1, Node n2){
                if(n1.row > n2.row){
                    return 1;
                }else if(n1.row == n2.row){
                    return n1.col - n2.col;
                }else{
                    return -1;
                }
            }
        });
        
        return sub;
    }
    
    static class Node{
        int row,col;
        public Node(int r, int c){
            row = r;
            col = c;
        }
    }
}