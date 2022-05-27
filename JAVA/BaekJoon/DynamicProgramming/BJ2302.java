package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2302 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        int graph[] = new int[N];
        int fix[] = new int[M];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            fix[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        int dp[] = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        if(N >= 2){
            dp[2] = 2;
        }
        for(int i = 3 ; i <= N ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }


        if(M > 0) {
            list.add(fix[0] - 1);
            for (int i = 0; i < M - 1; i++) {
                list.add(fix[i + 1] - fix[i] - 1);
            }
            list.add(N - fix[M - 1]);

            int answer = 1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) continue;
                answer *= dp[list.get(i)];
            }
            System.out.println(answer);

        } else{
            System.out.println(dp[N]);
        }


    }
}
