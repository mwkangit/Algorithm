package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1946 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int loop = 0 ; loop < T ; loop++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int list[][] = new int[N][2];
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = Integer.parseInt(st.nextToken());
            }

            int num = 0;
            Arrays.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int comp = list[0][1];
            int result = 1;

            for(int i = 1 ; i < N ; i++){
                if(comp > list[i][1]){
                    comp = list[i][1];
                    result++;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);


    }
}
