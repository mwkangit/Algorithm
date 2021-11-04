#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    
    vector<int> vec;
    int mok;
    int sub;
    string result = "";
    
    if( n == 1) result = to_string(1);
    if( n == 2) result = to_string(2);
        
    while(n / 3 != 0){
        
        sub = n % 3;
        n = n / 3;
        
        if(sub == 0){
            result = to_string(4) + result;
            n--;
        } else {
            result = to_string(sub) + result;
        }
        
        if(n / 3 == 0){
            if(n != 0){
                result = to_string(n) + result;
            }
            break;
        }
        
        
    }
    answer = result;
    return answer;
}
