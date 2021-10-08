#include <iostream>
#include <string>
#include <stack>
#include <queue>
#include <vector>
#include <cmath>


using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, mod, cnt = 0;
    cin >> N;
    cnt = N;

    vector<int> inp(N);
    for(int i = 0 ; i < N ; i++){
        cin >> inp[i];
        if(inp[i] == 1){
            cnt--;
        }
    }

    for(int i = 0 ; i < N ; i++){

            for(int j = 2 ; j <= (int)sqrt(inp[i]) ; j++){
                if(inp[i] % j == 0){
                    cnt--;
                    break;
                }
            }
        

    }

    cout << cnt;


}