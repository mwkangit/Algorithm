package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class BJ13904 {
	// 0718 re
	static int N;
	static int arr[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ps(st.nextToken());
		
		arr = new int[N][2];
		int maxi = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int left = ps(st.nextToken());
			int right = ps(st.nextToken());
			arr[i][0] = left;
			arr[i][1] = right;
			maxi = Math.max(maxi, left);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int []i1, int []i2) {
				return i1[0] - i2[0];
			}
		});
		int index = N-1;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.right < n2.right) {
					return 1;
				}else if(n1.right == n2.right) {
					if(n1.left > n2.left) {
						return 1;
					}else if(n1.left == n2.left) {
						return 0;
					}else {
						return -1;
					}
				}else {
					return -1;
				}
			}
		});
		int answer = 0;
		while(maxi > 0) {
			for(int i = index ; i >= 0 ; i--) {
				if(maxi == arr[i][0]) {
					pq.add(new Node(arr[i][0], arr[i][1]));
				}else {
					index = i;
					break;
				}
			}
			if(!pq.isEmpty()) {
				answer += pq.poll().right;
			}
			
			maxi--;
		}
		System.out.print(answer);
	}
	static class Node{
		int left, right;
		public Node(int l, int r) {
			left = l;
			right = r;
		}
	}
	
	static int ps(String str) {
		return Integer.parseInt(str);
	}

}
