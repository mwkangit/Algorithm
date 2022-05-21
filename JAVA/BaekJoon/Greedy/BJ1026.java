package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1026 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> subB = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            B.add(Integer.parseInt(st.nextToken()));
            subB.add(B.get(i));
        }

        Collections.sort(subB, Collections.reverseOrder());
        Collections.sort(A);
        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer += A.get(i) * subB.get(i);
        }
        System.out.println(answer);

    }
}
