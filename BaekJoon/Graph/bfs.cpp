#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

void bfs(int V, vector<int>* graph, bool* check){
    queue<int> q;

    q.push(V);
    check[V] = true;

    // 너비 우선 탐색이므로 큐에서 하나 뺀 것에 대해 다 찾아보면서 큐에 하나하나 넣는다
    // 그후 뺀것을 다 탐색하면 넣었던 것 중 가장 먼저 넣은 것을 다시 큐에서 빼서 탐색한다
    // level 마다 탐색한다
    while(!q.empty()){
        int tmp = q.front();
        q.pop();
        printf("%d ", tmp);
        for(int i = 0 ; i < graph[tmp].size() ; i++){
            // 방문하지 않았으면
            if(check[graph[tmp][i]] == false){
                // 큐에 넣어주고 방문했다고 표시한다
                q.push(graph[tmp][i]);
                check[graph[tmp][i]] = true;
            }
        }
    }
}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, V;
    cin >> N >> M >> V;

    vector<int>* graph = new vector<int>[N+1];
    bool* check = new bool[N+1];
    fill(check, check + N + 1, false);

    for(int i = 0 ; i < M ; i++){
        int u, v;
        cin >> u >> v;

        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for(int i = 0 ; i <= N ; i++){
        sort(graph[i].begin(), graph[i].end());
    }

    bfs(V, graph, check);

}