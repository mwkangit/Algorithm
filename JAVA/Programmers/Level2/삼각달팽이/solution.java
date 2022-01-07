class Solution {
    public int[] solution(int n) {
        int size = 0;
        for(int i = 1 ; i <= n ; i++){
            size += i;
        }
        
        int[] answer = new int[size];
        
        int graph[][] = new int [n][n];
        
        int count = 1;
        int dx = -1;
        int dy = 0;
        
        
        for(int i = 0 ; i < n ; i++){
            if(i % 3 == 0){
                for(int j = i ; j < n ; j++){
                    dx++;
                    graph[dx][dy] = count++;
                }
            } else if(i % 3 == 1){
                for(int j = i ; j < n ; j++){
                    dy++;
                    graph[dx][dy] = count++;
                }
            } else if(i % 3 == 2){
                for(int j = i ; j < n ; j++){
                    dx--;
                    dy--;
                    graph[dx][dy] = count++;
                }
            }
            
            
        }
        count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i + 1 ; j++){
                answer[count++] = graph[i][j];
            }
        }
        
        
        
        return answer;
    }
}
