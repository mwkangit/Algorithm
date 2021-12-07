#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

int N, M;
bool flag = false;
int k = 0;
int curX, curY;

void dfs(pair<int, int>start, vector<vector<char>>&graph, vector<vector<bool>>&visit){

    int row = start.first;
    int col = start.second;
    int let = graph[row][col];
    k++;
    visit[row][col] = true;

    if(k >= 4 && ((row == curX && col + 1 == curY) || (row - 1 == curX && col == curY))){
        // printf("Cur X Y : %d, %d\n", curX, curY);
        // printf("Now X Y : %d, %d\n", row, col);
        flag = true;
        return;
    }

    if(col+1 != M && graph[row][col+1] == let && !visit[row][col+1]){
        dfs(make_pair(row, col+1), graph, visit);
    }
    if(row+1 != N && graph[row+1][col] == let && !visit[row+1][col]){
        dfs(make_pair(row+1, col), graph, visit);
    }
    if(col-1 >= 0 && graph[row][col-1] == let && !visit[row][col-1]){
        dfs(make_pair(row, col-1), graph, visit);
    }
    if(row-1 >= 0 && graph[row-1][col] == let && !visit[row-1][col]){
        dfs(make_pair(row-1, col), graph, visit);
    }

    visit[row][col] = false;
    k--;



}

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    string str;

    vector<vector<char>>graph(N,vector<char>(M));
    vector<vector<bool>>visit(N,vector<bool>(M));

    pair<int, int> start;

    for(int i = 0 ; i < N ; i++){
        cin >> str;
        for(int j = 0 ; j < M ; j++){
            graph[i][j] = str[j] -'0';
        }
    }


    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M ; j++){
            if(flag)break;
            start = make_pair(i, j);
            curX = i;
            curY = j;
            dfs(start, graph, visit);
            k = 0;
        }
        if(flag)break;
    }

    if(flag){
        printf("Yes");
    } else {
        printf("No");
    }


}