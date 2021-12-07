#include <iostream>
#include <vector>


using namespace std;



int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;

    cin >> n >> m;

    vector<vector<int>> flo (n, vector<int>(n));

    int a, b, c;

    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            if(i == j)continue;
            flo[i][j] = 1000000000;
        }
    }

    for(int i = 0 ; i < m ; i++){
        cin >> a >> b >> c;

        flo[a-1][b-1] = min(flo[a-1][b-1], c);
    }

    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            for(int k = 0 ; k < n ; k++){
                flo[j][k] = min(flo[j][i]+flo[i][k], flo[j][k]);
            }


        }

    }

    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            if(flo[i][j] == 1000000000){
                cout << "0" << " ";
            } else{
                cout << flo[i][j] << " ";                
            }
        }
        cout << "\n";
    }



}