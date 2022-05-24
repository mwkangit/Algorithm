package BaekJoon.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ21609 {
    static int N, M;
    static int graph[][];
    static boolean visit[][];
    static int r[] = {0, 1, 0, -1};
    static int c[] = {1, 0, -1, 0};
    static ArrayList<Node> list;
    static Block block;
    static int score = 0;
    static boolean visitNum[][];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            list = new ArrayList<>();
            block = new Block();
            visitNum = new boolean[N][N];

            block.count = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visitNum[i][j] && graph[i][j] != -1 && graph[i][j] != 0 && graph[i][j] != -100) {
                        search(i, j);
                    }
                }
            }
            if (block.count <= 1) break;
            score += Math.pow(block.count, 2);
            delete();
            gravity();
            rotate();
            gravity();



        }
        System.out.println(score);
    }
    static void rotate(){
        int subGraph[][] = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            for(int j = N-1 ; j >= 0 ; j--){
                subGraph[N-j-1][i] = graph[i][j];
            }
        }
        graph = subGraph;
    }
    static void gravity(){
        for(int i = N-1 ; i >= 0 ; i--){
            for(int j = N-1 ; j >= 0 ; j--){
                if(graph[i][j] == -1 || graph[i][j] == -100)continue;
                int down = i;
                while(true){
                    if(down+1 < N && graph[down+1][j] == -100){
                        down++;
                    }else{
                        break;
                    }
                }
                int sub = graph[down][j];
                graph[down][j] = graph[i][j];
                graph[i][j] = sub;
            }
        }
    }
    static void delete(){
        int size = list.size();
        for(int i = 0 ; i < size ; i++){
            Node node = list.get(i);
            graph[node.row][node.col] = -100;
        }
    }
    static void search(int rw, int cl){
        boolean visit[][] = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(rw, cl));
        int num = graph[rw][cl];
        visit[rw][cl] = true;
        int rainbow = 0;
        int count = 1;
        ArrayList<Node> subList = new ArrayList<>();
        subList.add(new Node(rw, cl));
        visitNum[rw][cl] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int row = node.row+r[i];
                int col = node.col+c[i];

                if(row < 0 || row >= N || col < 0 || col >= N || visit[row][col] || graph[row][col] == -1)continue;
                if(graph[row][col] == 0){
                    visit[row][col] = true;
                    visitNum[row][col] = true;
                    rainbow++;
                    count++;
                    subList.add(new Node(row, col));
                    q.add(new Node(row, col));
                } else if(graph[row][col] == num){
                    visit[row][col] = true;
                    visitNum[row][col] = true;
                    count++;
                    subList.add(new Node(row, col));
                    q.add(new Node(row, col));
                }
                continue;

            }

        }

        if(block.count == -1){
            block = new Block(count, rainbow, rw, cl, num);
            list = subList;
        }else{
            if(block.count == count){
                if(block.rainbow == rainbow){
                    if(block.row == rw){
                        if(block.col < cl){
                            block = new Block(count, rainbow, rw, cl, num);
                            list = subList;
                        }
                    }else if(block.row < rw){
                        block = new Block(count, rainbow, rw, cl, num);
                        list = subList;
                    }
                }else if(block.rainbow < rainbow){
                    list = subList;
                    block = new Block(count, rainbow, rw, cl, num);

                }

            } else if(block.count < count){
                block = new Block(count, rainbow, rw, cl, num);
                list = subList;
            }
        }

    }
    static void print(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Block{
        int count;
        int rainbow;
        int row;
        int col;
        int num;

        public Block() {
        }

        public Block(int count, int rainbow, int row, int col, int num) {
            this.count = count;
            this.rainbow = rainbow;
            this.row = row;
            this.col = col;
            this.num = num;
        }

    }
    static class Node{
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
