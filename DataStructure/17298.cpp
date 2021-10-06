#include <iostream>
#include <string>
#include <stack>
#include <queue>
#include <vector>


using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, left, last, flag;


    cin >> N;

    vector<int> V(N), ret(N);


    for(int i = 0 ; i < N ; i++){
        cin >> V[i];
    }

    for(int i = 0 ; i < N ; i++){
        flag = 0;
        last = N - 1;
        if(i != N - 1){
            for(int j = N - i - 1 ; j > 0 ; j--){
                if(V[i] < V[last]){
                    left = V[last];
                    flag = 1;
                }
                last--;
            }
        }

        if(flag == 1){
            cout << left << " ";
        } else {
            cout << "-1" << " ";
        }


    }

}
// 다시 하시오