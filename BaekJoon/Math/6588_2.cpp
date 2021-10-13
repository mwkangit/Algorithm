#include <iostream>
#include <string>
#include <stack>
#include <queue>

using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num[1000001];
    num[0] = true;
    num[1] = true;
    int size = sizeof(num);

    for(int i = 2 ; i < size ; i++){
        if(!num[i]){
            for(int j = i * 2 ; j < size ; j += i){
                num[j] = true;
            }
        }
    }

    int prime1, prime2;
    int input;

    cin >> input;

    while(input != 0){
        for(int i = input ; i > 2 ; i--){
            if(!num[i]){
                prime2 = i;
                prime1 = input - i;
                if(num[prime1]) break;
            }
        }
    }

    

}