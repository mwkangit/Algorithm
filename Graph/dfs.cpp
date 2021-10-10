#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

void dfs(int V, vector<int>* graph, bool* check){
    check[V] = true;
    printf("%d ", V);

    for(int i = 0 ; i < graph[V].size() ; i++){
        int next = graph[V][i];

        if(check[next] == false){
            dfs(next, graph, check);
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

    dfs(V, graph, check);

}