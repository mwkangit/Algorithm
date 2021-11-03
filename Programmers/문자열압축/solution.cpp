#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    answer = s.length();
    
    for(int i = 1 ; i <= (s.length()/2) ; i++){
        
        int cnt = 1;
        string sub = s.substr(0, i);
        string tmp = "";
        
        
        
        for(int j = i ; j < s.length() ; j+=i){
            if(sub == s.substr(j, i)){
                cnt++;
            } else {
                if(cnt != 1){
                    tmp += (to_string(cnt) + sub);
                    sub = s.substr(j,i);
                    cnt = 1;
                } else {
                    tmp += sub;
                    sub = s.substr(j,i);
                    cnt = 1;
                }
            }
            
        }
        if(cnt != 1){
            tmp += to_string(cnt);
        }
        tmp += sub;
        
        int len = tmp.length();
        answer = min(answer, len);        
        
    }
    
    
    
    
    return answer;
}
