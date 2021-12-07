#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

int MIN = 0;
int N, M;

void bfs(vector<int>start, vector<vector<int>>&graph, vector<vector<bool>>&visit){


    queue<vector<int>> q;
    q.push(start);

    while(!q.empty()){
        int row = q.front()[0];
        int col = q.front()[1];
        int dep = q.front()[2];
        q.pop();

    if(row + 1 == N && col + 1 == M){
        MIN = dep;
        return;
    }   

    if(col+1 != M && graph[row][col+1] == 1 && !visit[row][col+1]){
        visit[row][col+1] = true;
        vector<int>vec{row, col+1, dep+1};
        q.push(vec);
    } 
    if(row+1 != N && graph[row+1][col] == 1 && !visit[row+1][col]){
        visit[row+1][col] = true;
        vector<int>vec{row+1, col, dep+1};
        q.push(vec);
    } 
    if(col-1 >= 0 && graph[row][col-1] == 1 && !visit[row][col-1]){
        visit[row][col-1] = true;
        vector<int>vec{row, col-1, dep+1};
        q.push(vec);
    } 
    if(row-1 >= 0 && graph[row-1][col] == 1 && !visit[row-1][col]){
        visit[row-1][col] = true;
        vector<int>vec{row-1, col, dep+1};
        q.push(vec);
    }   


        
        



    }

}


int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    cin >> N >> M;
    string str;

    vector<vector<int>>graph(N, vector<int>(M));
    vector<vector<bool>>visit(N, vector<bool>(M));

    for(int i = 0 ; i < N ; i++){
        cin >> str;
        for(int j = 0 ; j < M ; j++){
            graph[i][j] = str[j] - '0';
        }
    }
    vector<int>start;
    start.push_back(0);
    start.push_back(0);
    start.push_back(1);

    bfs(start, graph, visit);
    printf("%d", MIN);


}