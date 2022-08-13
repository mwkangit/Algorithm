package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11497 {

	static int T;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = ps(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int loop = 0 ; loop < T ; loop++) {
			
			int num = ps(br.readLine());
			st = new StringTokenizer(br.readLine());
			int arr[] = new int[num];
			for(int i = 0 ; i < num ; i++) {
				arr[i] = ps(st.nextToken());
			}
			Arrays.sort(arr);
			int graph[] = new int[num];
			graph[0] = arr[0];
			graph[num-1] = arr[1];
			int maxi = graph[num-1] - graph[0];
			int left = 1;
			int right = num-2;
			for(int i = 2 ; i < num ; i++) {
				if(i == num-1) {
					graph[left] = arr[i];
					maxi = Math.max(maxi, Math.max(graph[left] - graph[left-1], graph[left] - graph[left+1]));
				}
				if(i % 2 == 0) {
					graph[left] = arr[i];
					maxi = Math.max(maxi, graph[left] - graph[left-1]);
					left++;
				}else {
					graph[right]  = arr[i];
					maxi = Math.max(maxi, graph[right] - graph[right+1]);
					right--;
				}
			}
			sb.append(maxi).append("\n");
		}
		System.out.print(sb);
		
		
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
