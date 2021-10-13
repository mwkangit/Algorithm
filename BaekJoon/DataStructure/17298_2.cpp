#include <iostream>
#include <string>
#include <stack>
#include <queue>
#include <vector>


using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, last;

    
    cin >> N;

    stack<int> st;
    stack<int> ret;
    vector<int> V(N);


    for(int i = 0 ; i < N ; i++){
        cin >> V[i];
    }

    for(int i = N - 1 ; i >= 0 ; i--){
        while(!st.empty() && st.top() <= V[i]){
            st.pop();
        }

        if(st.empty()){
            st.push(V[i]);
            ret.push(-1);
        } else {
            ret.push(st.top());
        }

        st.push(V[i]);
    }

    last = ret.size();
    for(int i = 0 ; i < last ; i++){
        cout << ret.top() << " ";
        ret.pop();
    }



}