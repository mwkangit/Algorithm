#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    cin.ignore();

    string str;
    stack<char> st;

    while(T--){
        getline(cin, str);
        int size = str.length();
        
        if(str[0] == '('){
                st.push('(');
                int i;
        
            for(i = 1 ; i < size ; i++){
                if(str[i] == ')'){
                    if(st.empty()){
                        break;
                    } else {
                        st.pop();
                    }
                } else {
                    st.push(str[i]);
                }
                



            }
            if(st.empty() && i == size){
                cout << "YES" << endl;
            } else {
                cout << "NO" << endl;
            }
        } else {
            cout << "NO" << endl;
        }

        while(!st.empty()){
            st.pop();
        }

        


    }


}
// if(str[i] == ')') 이 아닌 '('을 기준으로 했으면 코드 짧아진다.