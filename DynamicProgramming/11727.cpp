#include <iostream>
#include <string>
#include <stack>
#include <queue>



using namespace std;


int dp[1001];

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    dp[1] = 1;
    dp[2] = 3;
    int size = sizeof(dp) / sizeof(int);

    for(int i = 3 ; i < size ; i++){
        dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
    }

    int n;
    cin >> n;

    printf("%d", dp[n]);


}