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

    int flag = 0;
    int sum = 0;
    vector<int> vt(9);

    for(int i = 0 ; i < 9 ; i++){
        cin >> vt[i];
    }  

    for(int i = 0 ; i < 9 ; i++){
        sum += vt[i];
    }

    sort(vt.begin(), vt.end());

    for(int i = 0 ; i < 8 ; i++){
        for(int j = i + 1 ; j < 9 ; j++){
            if(sum - vt[i] - vt[j] == 100){
                vt.erase(vt.begin() + i);
                vt.erase(vt.begin() + j - 1);
                flag = 1;
            }
        }
        if(flag == 1)break;
    }

    for(int i = 0 ; i < 7 ; i++){
        cout << vt[i] << "\n";
    }




}