#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define INF 1000000000

vector<pair<int, int>> a[20001];
int d[20001];

void dijkstra(int start){

    d[start] = 0;
    priority_queue<pair<int, int>> pq;
    pq.push(make_pair(start, 0));
    while(!pq.empty()){
        int current = pq.top().first;
        int distance = -pq.top().second;
        pq.pop();

        if(d[current] < distance) continue;
        for(int i = 0 ; i < a[current].size() ; i++){
            int next = a[current][i].first;

            int next_distance = distance + a[current][i].second;

            if(next_distance < d[next]){
                d[next] = next_distance;
                pq.push(make_pair(next, -next_distance));
            }
            

        }
    }


}

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int V, E;

    cin >> V >> E;
    

    

    for(int i = 1 ; i <= V ; i++){
        d[i] = INF;
    }

    int K;
    cin >> K;

    int u, v, w;

    for(int i = 0 ; i < E ; i++){
        cin >> u >> v >> w;
        a[u].push_back(make_pair(v,w));
    }

    dijkstra(K);

    for(int i = 1 ; i <= V ; i++){
        if(d[i] == INF){
            cout << "INF" << "\n";
        } else {
            cout << d[i] << "\n";
        }
    }


}