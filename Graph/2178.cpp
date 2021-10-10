#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

int MIN = 0;
int depth = 0;
int N, M;

void dfs(pair<int, int> start, vector<vector<int>>&graph, vector<vector<bool>>&visit){
    
    depth++;
    int row = start.first;
    int col = start.second;
    visit[row][col] = true;

    if(row + 1 == N && col + 1 == M){
        visit[row][col] = false;
        if(MIN == 0){
            MIN = depth;
        } else {
            MIN = min(MIN, depth);
        }
        depth--;        
        return;
    }

    if(col+1 != M && graph[row][col+1] == 1 && !visit[row][col+1]){
        dfs(make_pair(row,col+1), graph, visit);
    } 
    if(row+1 != N && graph[row+1][col] == 1 && !visit[row+1][col]){
        dfs(make_pair(row+1,col), graph, visit);
    } 
    if(col-1 >= 0 && graph[row][col-1] == 1 && !visit[row][col-1]){
        dfs(make_pair(row,col-1), graph, visit);
    } 
    if(row-1 >= 0 && graph[row-1][col] == 1 && !visit[row-1][col]){
        dfs(make_pair(row-1,col), graph, visit);
    }   

    depth--;
    visit[row][col] = false;

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
    pair<int,int> start = make_pair(0,0);

    dfs(start, graph, visit);
    printf("%d", MIN);

}