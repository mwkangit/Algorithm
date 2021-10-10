#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

int w, h;

int dx[8] = {1, 1, 0, -1, -1, -1, 0, 1};
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};



void dfs(int row, int col, vector<vector<int>>&graph, vector<vector<bool>>&visit){

    visit[row][col] =true;
    
    for(int i = 0 ; i < 8 ; i++){
        int ny = row + dy[i];
        int nx = col + dx[i];
        if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;

        if(graph[ny][nx] == 1 && !visit[ny][nx]){
            dfs(ny, nx, graph, visit);
        }

    

    }
}

void bfs(pair<int, int>start, vector<vector<int>>&graph, vector<vector<bool>>&visit){
    visit[start.first][start.second] = true;
    queue<pair<int, int>> q;
    q.push(start);
    int row, col;

    while(!q.empty()){
        row = q.front().first;
        col = q.front().second;
        q.pop();

        for(int i = 0 ; i < 8 ; i++){
            int ny = row + dy[i];
            int nx = col + dx[i];
            if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;

            if(graph[ny][nx] == 1 && !visit[ny][nx]){
                visit[ny][nx] = true;
                q.push(make_pair(ny, nx));

            }


        }



    }



}


int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    cin >> w >> h;

    pair<int, int> start;

    // int** graph = new int*[w]



    // cout << graph[2][3] << graph[1][1] << "\n";


    while(w != 0 && h != 0){

        // graph.resize(h);
        // visit.resize(h);
        // for(int i = 0 ; i < h ; i++){
        //     graph[i].resize(w);
        //     visit[i].resize(w);
        // }
        
        vector<vector<int>>graph(h,vector<int>(w, -1));
        vector<vector<bool>>visit(h,vector<bool>(w, false));

        int result = 0;

        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                cin >> graph[i][j];
            }
        }

        // dfs
        /*for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                if(graph[i][j] == 1 && !visit[i][j]){
                    result++;
                    dfs(i, j, graph, visit);
                }

            }
        }*/

        // bfs
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                if(graph[i][j] == 1 && !visit[i][j]){
                    result++;
                    start = make_pair(i, j); 
                    bfs(start, graph, visit);
                }

            }
        }

        printf("%d\n", result);


        cin >> w >> h;
    }

}