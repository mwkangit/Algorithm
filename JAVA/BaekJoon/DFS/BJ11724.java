package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11724 {
    static int graph[][];
    static boolean visit[];
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        visit = new boolean[N+1];
        for(int i = 1 ; i < N+1 ; i++){
            if(!visit[i]){
                bfs(N, M, i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void bfs(int N, int M, int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visit[num] = true;
        while(!q.isEmpty()){
            int index = q.poll();

            for(int i = 1 ; i < N+1 ; i++){
                if(visit[i]) continue;
                if(graph[index][i] == 1){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }

    }
}
