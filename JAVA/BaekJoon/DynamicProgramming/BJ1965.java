import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1965 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int box[] = new int[N];
		int dp[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		int maxi = 0;
		Arrays.fill(dp, 1);
		
		for(int i = 1 ; i < N ; i++) {
			for(int j = i-1 ; j >= 0 ; j--) {
				if(box[i] > box[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			maxi = Math.max(maxi, dp[i]);
		}
		
		System.out.print(maxi);
		
	}

}
