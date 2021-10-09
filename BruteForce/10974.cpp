#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> vt(N);

    for(int i = 0 ; i < N ; i++){
        vt[i] = i + 1;
    }

    do{

        for(int i = 0 ; i < N ; i++){
            cout << vt[i] << " ";
        }
        cout << "\n";

    }while(next_permutation(vt.begin(), vt.end()));


}