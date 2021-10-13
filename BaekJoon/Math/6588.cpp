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

    int n, a = 0, b = 0, half, flag;
    cin >> n;
    

    while(n){
        // half = (int)(n/2);
        flag = 0;
        a = 0;
        b = 0;
        for(int i = 3 ; i < n ; i += 2){
            // 왜 cout은 0 입력 후 뜨고 printf는 바로 뜰까?
            // cout << i << "\n";
            // printf("%d\n", i);
            if(i != 3){
                for(int j = 2 ; j <= sqrt(i) ; j++){
                    if(!(i%j)){
                        break;
                    }
                    if(j == sqrt(i)){
                        a = i;
                        b = n - a;
                        for(int k = 2 ; k <= sqrt(b) ; k++){
                            if(!b%k){
                                break;
                            }
                            if(k == sqrt(b)){
                                flag = 1;
                            }
                        }
                    }
                }
            } else {
                a = i;
                b = n - a;
                printf("1");
                for(int k = 2 ; k <= sqrt(b) ; k++){
                    if(!(b%k)){
                        break;
                    }
                    if(k == sqrt(b)){
                        flag = 1;
                    }
                }

            }
            if(flag == 1){
                cout << n << " = " << a << " + " << b << "\n";
                break;
            }
        }

        cin >> n;
    }


}

// 에리스토테네스 다시 공부하기
// 소수 문제는 에리스토테네스로 푼다