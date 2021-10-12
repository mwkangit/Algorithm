#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;


void dfs(vector<vector<int>>&graph, vector<vector<bool>>&visit, pair<int, int> start, int map_count, int N){

    int row = start.first;
    int col = start.second;
    visit[row][col] = true;
    graph[row][col] = map_count;

    if(col+1 != N && !visit[row][col + 1] && graph[row][col + 1] == 1){
        dfs(graph, visit, make_pair(row, col+1), map_count, N);
    }

    if(row+1 != N && !visit[row+1][col] && graph[row+1][col] == 1){
        dfs(graph, visit, make_pair(row+1, col), map_count, N);
    }
    
    if(col-1 >= 0 && !visit[row][col-1] && graph[row][col-1] == 1){
        dfs(graph, visit, make_pair(row, col-1), map_count, N);
    }

    if(row-1 >= 0 && !visit[row-1][col] && graph[row-1][col] == 1){
        dfs(graph, visit, make_pair(row-1, col), map_count, N);
    }

}


int bfs(vector<vector<int>>&graph, vector<vector<bool>>visit, int start_row, int start_col, int map_num, int N, int maxi){

    queue<vector<int>> q;
    visit[start_row][start_col] = true;

    vector<int> starter{start_row, start_col, 0};

    q.push(starter);

    while(!q.empty()){
        int row = q.front()[0];
        int col = q.front()[1];
        int dep = q.front()[2];
        q.pop();

        if(col+1 != N && graph[row][col + 1] != map_num && !visit[row][col+1]){
            if(graph[row][col+1] != 0){
                return min(maxi, dep);
            }
            vector<int>vec{row, col+1, dep+1};
            visit[row][col+1] = true;
            q.push(vec);
        }

        if(row+1 != N && graph[row+1][col] != map_num && !visit[row+1][col]){
            if(graph[row+1][col] != 0){
                return min(maxi, dep);
            }
            vector<int>vec{row+1, col, dep+1};
            visit[row+1][col] = true;
            q.push(vec);
        }


        if(col-1 >= 0 && graph[row][col-1] != map_num && !visit[row][col-1]){
            if(graph[row][col-1] != 0){
                return min(maxi, dep);
            }
            vector<int>vec{row, col-1, dep+1};
            visit[row][col-1] = true;
            q.push(vec);
        }


        if(row-1 >= N && graph[row-1][col] != map_num && !visit[row-1][col]){
            if(graph[row-1][col] != 0){
                return min(maxi, dep);
            }
            vector<int>vec{row-1, col, dep+1};
            visit[row-1][col] = true;
            q.push(vec);
        }


    }

    return maxi;


}



int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    int map_count = 1;
    int map_num;
    int maxi;
    int depth = 0;
    pair<int, int> start;

    cin >> N;

    maxi = N * N;
    

    vector<vector<int>>graph(N,vector<int>(N));
    vector<vector<bool>>visit(N,vector<bool>(N));

    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
            cin >> graph[i][j];
        }
    }

    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
            if(!visit[i][j] && graph[i][j] == 1){
                start = make_pair(i, j);
                dfs(graph, visit, start, map_count, N);
                map_count++;           
            }
        }
    }

    // fill(visit.begin(), visit.end(), false);

    // for(int i = 0 ; i < N ; i++){
    //     for(int j = 0 ; j < N ; j++){
    //             printf(visit[i][j] ? "true" : "false");
    //     }
    //     printf("\n");
    // }

    // for(int i = 0 ; i < N ; i++){
    //     for(int j = 0 ; j < N ; j++){
    //             printf("%d ", graph[i][j]);
    //     }
    //     printf("\n");
    // }

    vector<vector<bool>>visit2(N,vector<bool>(N));

    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
            if(graph[i][j] != 0){             
                map_num = graph[i][j];
                maxi = bfs(graph, visit2, i, j, map_num, N, maxi);
            }
        }
    }

    printf("%d", maxi);










}