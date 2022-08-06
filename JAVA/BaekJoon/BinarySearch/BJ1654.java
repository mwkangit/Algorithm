package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[K];
        
        long left = 1;
        long right = 0;
        
        for(int i = 0 ; i < K ; i++) {
        	int num = Integer.parseInt(br.readLine());
        	arr[i] = num;
        	right = Math.max(right, num);
        }
        
        long answer = 0;
        
        while(left <= right) {
        	long mid = (left + right)/2;
        	long sum = 0;
        	for(int i = 0 ; i < arr.length ; i++) {
        		sum += arr[i] / mid;
        	}
        	if(N <= sum) {
        		left = mid + 1;
        		answer = mid;
        	}else {
        		right = mid -1;
        	}
        }
        System.out.print(answer);
        
	}

}
