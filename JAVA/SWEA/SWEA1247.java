package swExpertAcademy;

import java.io.*;
import java.util.*;
 
 
 
public class SWEA1247
{
    static int result;
    static Node company;
    static Node home;
    static int N;
    static boolean visit[];
    static ArrayList<Node> list;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        //int T = 10;
        StringBuilder sb = new StringBuilder();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
 
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
             
            company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
             
            list = new ArrayList<>();
            result = Integer.MAX_VALUE;
            //Node node = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int i = 0 ; i < N ; i++){
                list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            /*while(st.hasMoreTokens()){
                int k =Integer.parseInt(st.nextToken());
            }*/
            visit = new boolean[N];
 
            dfs(0, 0, company);
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
 
 
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
         
    }
    static void dfs(int count, int size, Node curr){
        if(size >= result)return;
        if(count == N){
            size += Math.abs(home.row - curr.row) + Math.abs(home.col - curr.col);
            result = Math.min(result, size);
 
        }else{
            for(int i = 0 ; i < N ; i++){
                if(!visit[i]){
                    visit[i] = true;
                    dfs(count+1, size + Math.abs(curr.row - list.get(i).row) + Math.abs(curr.col - list.get(i).col), list.get(i));
                    visit[i] = false;
                }
            }
        }
    }
 
}
class Node{
        int row, col;
 
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
}