package BaekJoon.samsung;

import java.io.*;
import java.util.*;

public class BJ21608 {

    static int N;
    static ArrayList<Integer> list[];
    static int[] order;
    static int[][] graph;
    static int r[] = {0, 1, 0, -1};
    static int c[] = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parse(st.nextToken());
        list = new ArrayList[N*N+1];
        order = new int[N*N];
        graph = new int[N][N];

        for(int i = 1 ; i <= N*N ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= N*N ; i++){
            st = new StringTokenizer(br.readLine());
            int num = parse(st.nextToken());
            order[i-1] = num;
            list[num].add(parse(st.nextToken()));
            list[num].add(parse(st.nextToken()));
            list[num].add(parse(st.nextToken()));
            list[num].add(parse(st.nextToken()));
        }

        for(int loop = 0 ; loop < N * N ; loop++){
            ArrayList<Node> first = first(order[loop]);
            if(first.size() >= 2){
                ArrayList<Node> second = second(first);
                if(second.size() >= 2){
                    Node third = third(second);
                    graph[third.row][third.col] = third.num;

                }else{
                    graph[second.get(0).row][second.get(0).col] = second.get(0).num;
                }

            }else{
                graph[first.get(0).row][first.get(0).col] = first.get(0).num;
            }
        }

        int answer = check();
        System.out.println(answer);
    }

    static int check(){
        int result = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){

                int count = 0;
                for(int k = 0 ; k < 4; k++){
                    int ro = i + r[k];
                    int co = j + c[k];
                    if (ro >= N || ro < 0 || co < 0 || co >= N) continue;

                    if(list[graph[i][j]].contains(graph[ro][co])){
                        count++;
                    }

                }
                if(count == 1){
                    result++;
                } else if(count == 2){
                    result += 10;
                } else if(count == 3){
                    result += 100;
                } else if(count == 4){
                    result += 1000;
                }
            }
        }

        return result;

    }

    static Node third(ArrayList<Node> second){

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.row > o2.row){
                    return 1;
                }else if(o1.row == o2.row){
                    return o1.col - o2.col;
                }else{
                    return -1;
                }
            }
        });
        for(int i = 0 ; i < second.size() ; i++){
            pq.add(second.get(i));
        }

        return pq.poll();
    }
    static ArrayList<Node> second(ArrayList<Node> first){
        int maxi = 0;
        ArrayList<Node> secondList = new ArrayList<>();
        for(int i = 0 ; i < first.size() ; i++){
            Node node = first.get(i);
            int count = 0;
            for(int j = 0 ; j < 4 ; j++){
                int ro = node.row + r[j];
                int co = node.col + c[j];

                if (ro >= N || ro < 0 || co < 0 || co >= N) continue;

                if (graph[ro][co] == 0) {
                    count++;
                }

            }

            if(count > maxi){
                maxi = count;
                secondList = new ArrayList<>();
                secondList.add(new Node(node.row,node.col,node.num));
            }else if(count == maxi){
                secondList.add(new Node(node.row,node.col,node.num));
            }

        }
        return secondList;

    }

    static ArrayList<Node> first(int num){

        ArrayList<Node> firstList = new ArrayList<>();
        int maxi = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(graph[i][j] != 0){
                    continue;
                }
                int count = 0;
                for(int k = 0 ; k < 4 ; k++) {
                    int ro = i + r[k];
                    int co = j + c[k];

                    if (ro >= N || ro < 0 || co < 0 || co >= N) continue;

                    if (list[num].contains(graph[ro][co])) {
                        count++;
                    }

                }

                if(count > maxi){
                    maxi = count;
                    firstList = new ArrayList<>();
                    firstList.add(new Node(i,j,num));
                }else if(count == maxi){
                    firstList.add(new Node(i,j,num));
                }

            }
        }

        return firstList;
    }


    static class Node{
        int row, col, num;

        public Node(int row, int col, int num) {
            this.row = row;
            this.col = col;
            this.num = num;
        }
    }
    static int parse(String str){
        return Integer.parseInt(str);
    }
}
