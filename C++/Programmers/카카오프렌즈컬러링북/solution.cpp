#include <vector>

using namespace std;

void dfs(vector<vector<int>>picture, vector<vector<bool>>&visit, int num, int row, int col, int &count_all, int m, int n){
    visit[row][col] = true;
    count_all++;
    
    if(col + 1 < n && picture[row][col+1] == num && visit[row][col+1] == false){
        dfs(picture, visit, picture[row][col+1], row, col+1, count_all, m, n);
    }
    if(row + 1 < m && picture[row+1][col] == num && visit[row+1][col] == false){
        dfs(picture, visit, picture[row+1][col], row+1, col, count_all, m, n);
    }
    if(col - 1 >= 0 && picture[row][col-1] == num && visit[row][col-1] == false){
        dfs(picture, visit, picture[row][col-1], row, col-1, count_all, m, n);
    }
    if(row - 1 >= 0  && picture[row-1][col] == num && visit[row-1][col] == false){
        dfs(picture, visit, picture[row-1][col], row-1, col, count_all, m, n);
    }
    
    
    
}


// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    
    
    vector<vector<bool>> visit(m, vector<bool>(n));
    int count = 0;
    int count_all = 0;
    int maxi = 0;
    
    for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
            if(picture[i][j] != 0 && visit[i][j] == false){
                dfs(picture, visit, picture[i][j], i, j, count_all, m, n);
                maxi = max(maxi, count_all);
                count_all = 0;
                count++;
            }
            
            
        }
    }
    
    number_of_area = count;
    max_size_of_one_area = maxi;
    
    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}
