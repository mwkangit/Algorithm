package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9658 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dp[] = new int[1001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 1;
        dp[5] = 1;
        for(int i = 6 ; i < 1001 ; i++){
            int comp = dp[i-4] + dp[i-3] + dp[i-1];
            if(comp == 3){
                dp[i] = 0;
            }else{
                dp[i] = 1;
            }
        }

        int N = Integer.parseInt(st.nextToken());
        System.out.println(dp[N] == 1 ? "SK" : "CY");


    }
}
