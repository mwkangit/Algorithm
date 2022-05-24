package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ1541 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String minusSplit[] = str.split("[-]");
        int minuslength = minusSplit.length-1;

        ArrayList<Integer> list = new ArrayList<>();

        for(String s : minusSplit){
            String sub[] = s.split("[+]");
            int sum = 0;
            for(String s1 : sub){
                sum += Integer.parseInt(s1);
            }
            list.add(sum);
        }

        int answer = list.get(0);
        for(int i = 1 ; i < list.size() ; i++){
            answer -= list.get(i);
        }
        System.out.println(answer);


    }
}
