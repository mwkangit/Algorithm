package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16401 {

	static int M, N;
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int answer = 0;
        int left = 1;
        int right = 0;
        
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	arr[i] = num;
        	right = Math.max(right, num);
        }

        Arrays.sort(arr);
        
        while(left <= right) {
        	int mid = (left + right) / 2;
        	int sum = 0;
        	for(int i = 0 ; i < arr.length ; i++) {
        		sum += arr[i] / mid;
        	}
        	if(sum >= M) {
        		left = mid + 1;
        		answer = mid;
        	}else {
        		right = mid - 1;
        	}
        }
        System.out.print(answer);
        
        
	}

}
