package swmaestro;

import java.util.*;
import java.io.*;


public class BJ17829 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int graph[][] = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			int sub[][] = new int[N/2][N/2];
			for(int i = 0 ; i < N ; i=i+2) {
				for(int j = 0 ; j < N ; j=j+2) {
					ArrayList<Integer> list = new ArrayList<>();
					for(int k = i ; k < i+2 ; k++) {
						for(int l = j ; l < j+2 ; l++) {
							list.add(graph[k][l]);
						}
					}
					Collections.sort(list);
					sub[i/2][j/2] = list.get(2);
				}
			}
			
			if(sub.length == 1) {
				System.out.print(sub[0][0]);
				break;
			}
			graph = sub;
			N /= 2;
			
		}
		
	}

}
