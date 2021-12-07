#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int V, E;

    int INF = 987654321;

    cin >> V >> E;
    V++;
    vector<vector<int>> vec (V, vector<int> (V));

    // for(int i  = 1 ; i < V ; i++){
    //     for(int j = 1 ; j < V ; j++){
    //         cout << vec[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    for(int i = 1 ; i < V ; i++){
        for(int j = 1 ; j < V ; j++){
            vec[i][j] = INF;
        }
    }

    int a, b, c;

    for(int i = 0 ; i < E ; i++){
        cin >> a >> b >> c;
        vec[a][b] = c;
    }

    for(int i = 1 ; i < V ; i++){
        for(int j = 1 ; j < V ; j++){
            for(int k = 1 ; k < V ; k++){
                vec[j][k] = min(vec[j][k], vec[j][i] + vec[i][k]);
            }
        }
    }

    int result = 987654321;

    for(int i  = 1 ; i < V ; i++){
        for(int j = 1 ; j < V ; j++){
            result = min(result, vec[i][j] + vec[j][i]);
        }
    }

    if(result >= 987654321){
        cout << -1;
    } else {
        cout << result;
    }

}