class Solution {
    boolean visit[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        int count = 0;
        for(int i = 0 ; i < computers.length ; i++){
            if(!visit[i]){
                count++;
                dfs(computers, n, i);
            }
        }
        answer = count;
        return answer;
    }
    public void dfs(int [][]computers, int n, int row){
        visit[row] =true;
        for(int i = 0 ; i < n ; i++){
            if(computers[row][i] == 1 && !visit[i]){
                dfs(computers, n, i);
            }
        }
        
        
    }
}
