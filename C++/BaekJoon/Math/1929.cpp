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

    int N, M, flag = 1;
    cin >> M >> N;

    int index = 0;
    int size = N - M + 1;
    vector<int> inp(size);
    for(int j = M ; j <= N ; j++){
        inp[index] = j;
        index++;
    }


    for(int i = 0 ; i < size ; i++){
            flag = 1;
            for(int j = 2 ; j <= (int)sqrt(inp[i]) ; j++){
                if(inp[i] % j == 0){
                    flag = 0;
                    break;
                }
            }

            if(flag == 1){
                cout << inp[i] << "\n";
            }
        

    }



}

// 에라스토테네스 방법도 있다