package swExpertAcademy;

import java.util.*;
import java.io.*;

public class SWEA4112 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
 
        StringBuilder sb = new StringBuilder();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
 
            if(start > end){
                int sub = start;
                start = end;
                end = sub;
            }
            int result;
 
            int sRow = searchRow(start);
            int eRow = searchRow(end);
 
            int left = searchLeft(eRow) - searchLeft(sRow) + start;
            int right = left + eRow - sRow;
            if(sRow == eRow){
                result = end - start;
            } else if(end < left){
                result = eRow - sRow + left - end;
            } else if(end > right){
                result = eRow - sRow + end - right;
            } else {
                result = eRow - sRow;
            }
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
 
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
 
    }
    static int searchRow(int num){
        int left;
        int right;
        int index = 1;
        while(true){
            left = searchLeft(index);
            right = searchRight(index);
            if(left > num || right < num){
                index++;
            }else{
                break;
            }
        }
        return index;
    }
    static int searchLeft(int index){
        return (int)(0.5 * (index * index - index) + 1);
    }
    static int searchRight(int index){
        return (int)(0.5 * (index * index + index));
    }

}
