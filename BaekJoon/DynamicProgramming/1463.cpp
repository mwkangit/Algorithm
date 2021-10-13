#include <iostream>
#include <string>
#include <stack>
#include <queue>


using namespace std;

int dp[1000001];

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int size = sizeof(dp) / sizeof(int);
    int index;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;

    for(int i = 4 ; i < size ; i++){
        
        dp[i] = dp[i-1];
        if(i % 3 == 0){
            if(dp[i/3] < dp[i]){
                dp[i] = dp[i/3];
            }

        }
        if(i % 2 == 0){
            if(dp[i/2] < dp[i]){
                dp[i] = dp[i/2];
            }
        }
        dp[i]++;

    }

    int N;
    cin >> N;
    printf("%d", dp[N]);


}