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

    stack<char> st;
    string str;

    for(int i = 0 ; i < T ; i++){
 
        getline(cin, str);
        str += ' ';

        for(int j = 0 ; j < str.length() ; j++){
            if(str[j] == ' '){
                while(!st.empty()){
                    cout << st.top();
                    st.pop();
                }
                cout << str[j]; 
            } else {
                st.push(str[j]);
            }


        }
        cout << endl;

    }


    return 0;
}