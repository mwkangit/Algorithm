package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16953 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 0;
        boolean flag =true;

        while(true){
            if(B == A) {
                flag = true;
                break;
            } else if (B < A){
                flag = false;
                break;
            }

            if(B % 2 == 0){
                B /= 2;
                count++;
            } else if(B % 10 == 1){
                B = (int)(B/10);
                count++;
            } else{
                flag = false;
                break;
            }
        }
        System.out.println(flag ? count+1 : -1);



    }
}
