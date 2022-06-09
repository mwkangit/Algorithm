package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10211 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int loop = 0 ; loop < T ; loop++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int arr[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int dp[] = new int[N];
            dp[0] = arr[0];
            int curr = arr[0];

            for(int i = 1 ; i < N ; i++){
                if(dp[i-1] < 0) dp[i-1] = 0;
                dp[i] = dp[i-1] + arr[i];
                curr = Math.max(dp[i], curr);
            }
            sb.append(curr).append("\n");


        }
        System.out.println(sb);
    }
}
