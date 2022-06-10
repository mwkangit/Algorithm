package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 지려따 // 15989와 매우 유사
public class BJ2293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coin[] = new int[n+1];
        for(int i = 1 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coin);
        int dp[][] = new int[n+1][10001];
        for(int i = 1 ; i <= n ; i++){
            if(coin[i] > k)break;
            dp[i][coin[i]] = 1;
        }
        for(int i = 1 ; i <= k ; i++){ // 열
            for(int j = 1 ; j <= n ; j++){ // 행
                if(i - coin[j] <= 0)break;
                for(int m = j ; m > 0 ; m--){
                    dp[j][i] += dp[m][i-coin[j]];
                }
            }
        }
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            result += dp[i][k];
        }
        System.out.println(result);
//        System.out.println(Arrays.deepToString(dp));



    }
}
