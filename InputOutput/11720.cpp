#include <iostream>

using namespace std;

int main(){
    int T, tmp, sum = 0;
    string str;
    cin >> T;
    cin >> str;

    for(int i = 0 ; i < str.length() ; i++){
        tmp = str[i] - '0';
        sum += tmp;
    }
    cout << sum << endl;
    
    
        return 0;
}