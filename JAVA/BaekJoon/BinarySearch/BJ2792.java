package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2792 {

	static int N, M;
	static int arr[];
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < M ; i++) {
        	int num = Integer.parseInt(br.readLine());
        	arr[i] = num;
        	right = Math.max(right, num);
        }
        int answer = right;
        
        while(left < right) {
        	int mid = (left + right) / 2;
        	if(mid==0) break;
        	int sum = 0;
        	for(int i = 0 ; i < arr.length ; i++) {
        		sum += arr[i] / mid;
        		if(arr[i] % mid != 0) {
        			sum++;
        		}
        	}
        	if(N < sum) {
        		left = mid+1;
        	}else {
        		right = mid;
        	}
        	
        }
        System.out.print(right);
        
        
	}

}
