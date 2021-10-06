#include <iostream>
#include <string>
#include <stack>
#include <queue>


using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, input, sub, count = 0;
    cin >> T;
    cin.ignore();
    sub = T;

    queue<int> seq;
    queue<char> answer;
    stack<int> num;

    while(sub--){
        cin >> input;
        seq.push(input);
    }

    for(int i = 1 ; i <= T ; i++){
        num.push(i);
        answer.push('+');
        while(!num.empty() && !seq.empty()){
            if(num.top() == seq.front()){
                answer.push('-');
                num.pop();
                seq.pop();
                count++;
            } else {
                break;
            }
        }
        // if(!num.empty() && !seq.empty()) {
        //     if(num.top() != seq.front()){
        //         answer.push('+');
        //     }
        // }
    }

    if(count == T){
        while(!answer.empty()){
            cout << answer.front() << '\n';
            answer.pop();
        }
    } else {
        cout << "NO" << '\n';
    }

}

// 스택의 수보다 큰 급이 입력될 때마다 그 수까지 +를 더해준다고 봐도 된다.