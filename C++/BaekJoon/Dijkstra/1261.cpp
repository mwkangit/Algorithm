#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define INF 987654321

vector<pair<int,int>> graph [10001];
int d[10001];

void bfs(vector<vector<int>> &vec, vector<vector<int>> &dist, int N, int M){

    queue<pair<int,int>> q;
    dist[0][0] = 0;
    q.push(make_pair(0,0));

    int dx[4] = {0, 1, 0, -1};
    int dy[4] = {1, 0, -1, 0};

    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for(int i = 0 ; i < 4 ; i++){
            int bx = x + dx[i];
            int by = y + dy[i];

            if(bx < 0 || bx >= N || by < 0 || by >= M) continue;

            if(vec[bx][by] == 1){
                if(dist[bx][by] > dist[x][y] + 1){
                    dist[bx][by] = dist[x][y] + 1;
                    q.push(make_pair(bx, by));
                }
            }else{
                if(dist[bx][by] > dist[x][y]){
                    dist[bx][by] = dist[x][y];
                    q.push(make_pair(bx, by));
                }
            }

        }



    }


}

int main(void){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int M, N;
    cin >> M >> N;

    vector<vector<int>> vec (N, vector<int>(M));
    vector<vector<int>> dist(N, vector<int>(M));

    string maze;
    for(int i = 0 ; i < N ; i++){
        cin >> maze;
        for(int j = 0 ; j < M ; j++){
            vec[i][j] = maze[j] - '0';
            dist[i][j] = INF;            
        }
    }

    bfs(vec, dist, N, M);

    cout << dist[N-1][M-1];

}