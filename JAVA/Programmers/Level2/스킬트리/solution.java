import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int arr[] = new int[skill.length()];

        boolean flag;

        for(int i = 0 ; i < skill_trees.length ; i++){

            if(skill.length() == 1){
                answer += skill_trees.length;
                break;
            }

            flag = false;

            for(int j = 0 ; j < skill.length() ; j++){
                arr[j] = skill_trees[i].indexOf(skill.charAt(j));
            }



            for(int j = 0; j < skill.length() ; j++){
                // System.out.println(arr[j] + " " + j);
                if(flag == true && arr[j] != -1){
                    break;
                }

                if(arr[j] == -1){
                    flag = true;
                    if(j == skill.length() - 1) answer++;
                    continue;
                }

                if(j == 0){
                    continue;
                }

                if(arr[j] < arr[j-1]){
                    break;
                }
                if(j == skill.length()-1){
                    answer++;
                }
            }

        }


        return answer;
    }
}
