package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class BJ11501 {

	static int T;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        T = ps(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        for(int loop = 0 ; loop < T ; loop++) {
        	st = new StringTokenizer(br.readLine());
        	int N = ps(st.nextToken());
        	int arr[] = new int[N];
        	int dp[] = new int[N];
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0 ; i < N ; i++) {
        		arr[i] = ps(st.nextToken());
        	}
        	int curr = 0;
        	long answer = 0;
        	for(int i = N-1 ; i >= 0 ; i--) {
        		if(arr[i] > curr) {
        			curr = arr[i];
        		}else {
        			answer += curr - arr[i];
        		}
        	}
        	
        	sb.append(answer).append("\n");
        }
        System.out.print(sb);
        
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
