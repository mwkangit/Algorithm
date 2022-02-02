import java.util.*;
import java.io.*;

class Solution {
    int pillar[][];
    int bo[][];
    int N;
    
    public int[][] solution(int n, int[][] build_frame) {
        
        pillar = new int[n+3][n+3];
        bo = new int[n+3][n+3];
        N = n;
        
        for(int i = 0 ; i < build_frame.length ; i++){
            int x = build_frame[i][0] + 1;
            int y = build_frame[i][1] + 1;
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            
            if(a == 0){
                if(b == 1){
                    if(checkPillar(x, y)){
                        pillar[y][x] = 1;
                    }
                }else if(b == 0){
                    pillar[y][x] = 0;
                    if(!checkDelete(x, y)){
                        pillar[y][x] = 1;
                    }
                }
                
            } else if(a == 1){
                if(b == 1){
                    if(checkBo(x, y)){
                        bo[y][x] = 1;
                    }
                } else if(b == 0){
                    bo[y][x] = 0;
                    if(!checkDelete(x, y)){
                        bo[y][x] = 1;
                    }
                    
                }
            }
        }
        
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 1 ; i <= N+1 ; i++){
            for(int j = 1 ; j <= N+1 ; j++){
                if(pillar[i][j] == 1){
                    list.add(new Node(i-1, j-1, 0));
                }
                if(bo[i][j] == 1){
                    list.add(new Node(i-1, j-1, 1));
                }
            }
        }
        
        Collections.sort(list, new Comparator<Node>(){
           @Override
            public int compare(Node n1, Node n2){
                if(n1.col > n2.col) return 1;
                else if(n1. col == n2.col){
                    if(n1.row > n2.row) return 1;
                    else if(n1.row == n2.row){  
                        if(n1.type > n2.type) return 1;
                        else return -1;
                        
                    } else return -1;
                } else return -1;
            }
        });
        
        int[][] answer = new int[list.size()][3];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i][0] = list.get(i).col;
            answer[i][1] = list.get(i).row;
            answer[i][2] = list.get(i).type;
        }
        
        return answer;
    }
    
    public boolean checkDelete(int col, int row){
        for(int i = 1 ; i <= N+1 ; i++){
            for(int j = 1 ; j <= N+1 ; j++){
                if(pillar[i][j] == 1 && !checkPillar(j, i)){
                    return false;
                }
                if(bo[i][j] == 1 && !checkBo(j, i)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkPillar(int col, int row){
        if(row == 1 || bo[row][col-1] == 1 || bo[row][col] == 1 || pillar[row-1][col] == 1){
            return true;
        } else return false;
    }
    
    public boolean checkBo(int col, int row){
        if(pillar[row-1][col] == 1 || pillar[row-1][col+1] == 1 || (bo[row][col-1] == 1 && bo[row][col+1] == 1)){
            return true;
        } else return false;
        
    }
    
    static class Node{
        int row;
        int col;
        int type;
        
        public Node(int r, int c, int t){
            row = r;
            col = c;
            type = t;            
        }
    }
}
