import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        ArrayList<Job> list = new ArrayList<>();
        
        for(int i = 0 ; i < jobs.length ; i++){
            list.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        Collections.sort(list, new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                return j1.req - j2.req;
            }
        });
        
        PriorityQueue<Job> q = new PriorityQueue<>(new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                return j1.exe - j2.exe;
            }
        });
        
        int end = 0;
        int index = 0;
        int result = 0;
        int count = 0;
        
        while(count < list.size()){
            
            
            while(index < list.size() && list.get(index).req <= end){
                q.add(list.get(index++));
            }
            
            
            if(q.isEmpty()){
                end = list.get(index).req;
            } else{
                Job j = q.poll();
                end += j.exe;
                result += end - j.req;
                count++;
            }
        }
        
        answer = result / jobs.length;
        
        return answer;
    }
    
    static class Job{
        int req;
        int exe;
        
        public Job(int r, int e){
            req = r;
            exe = e;
        }
    }
}
