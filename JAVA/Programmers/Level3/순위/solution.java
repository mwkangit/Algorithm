class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int arr[][] = new int[n][n];
        
        for(int[] sub : results){
            arr[sub[0]-1][sub[1]-1] = 1;
        }
        
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < n ; i++){
                for(int k = 0 ; k < n ; k++){
                    if(arr[i][j] == 1 && arr[j][k] == 1){
                        arr[i][k] = 1;
                    }
                }
            }
        }
        int count;
        for(int i = 0 ; i < n ; i++){
            count = 0;
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1 || arr[j][i] == 1){
                    count++;
                }
            }
            if(count == (n-1)){
                answer++;
            }
        }
        
        
        return answer;
    }
}
