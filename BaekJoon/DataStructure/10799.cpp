#include <iostream>
#include <string>
#include <stack>
#include <queue>


using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int length, result = 0;
    string str;

    stack<char> st;

    getline(cin, str);
    length = str.length();

    for(int i = 0 ; i < str.length() ; i++){
        if(str[i] == '('){
            st.push('(');
            if(str[i+1] == '('){
                result++;
            }
        } else {
            if(str[i-1] == (')')){
                st.pop();
            } else {
                st.pop();
                result += st.size();
            }
        }


    }
    cout << result;

}
// 레이져인 경우와 자투리인 경우로 보면 더 좋은 코드 나올 수 있다.