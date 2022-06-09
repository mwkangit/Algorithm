package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9657 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int dp[] = new int[1001];

        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;
        for(int i = 5 ; i < 1001 ; i++){
            if(dp[i-1] + dp[i-3] + dp[i-4] == 3){
                dp[i] = 0;
            }else{
                dp[i] = 1;
            }
        }
        System.out.println(dp[N] == 1 ? "SK" : "CY");

    }
}
