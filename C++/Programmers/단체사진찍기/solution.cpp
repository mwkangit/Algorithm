#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    int answer = 0;
    int count;
    bool flag;
    string dat;
    string first = "";
    string second = "";
    string oper = "";
    int len;
    
    vector<string> vec = {"A", "C", "F", "J", "M", "N", "R", "T"};
    sort(vec.begin(), vec.end());
    
    do{
        flag = false;
        for(int i = 0 ; i < n ; i++){
            count = i * 5;
            dat = data[i];
            first = dat[0];
            second = dat[2];
            oper = dat[3];
            len = dat[4] - '0';
            if(oper == "="){
                if(abs(find(vec.begin(), vec.end(), first) - find(vec.begin(), vec.end(), second)) == len + 1){
                    continue;
                } else{
                    flag = true;
                    break;
                }
            } else if(oper == "<"){
                if(abs(find(vec.begin(), vec.end(), first) - find(vec.begin(), vec.end(), second)) < len + 1){
                    continue;
                } else{
                    flag = true;
                    break;
                }
            } else if(oper == ">"){
                if(abs(find(vec.begin(), vec.end(), first) - find(vec.begin(), vec.end(), second)) > len + 1){
                    continue;
                } else{
                    flag = true;
                    break;
                }
            }
            
        }
        
        if(flag == true){
            continue;
        } else{
            answer++;
        }
        
        
    }while(next_permutation(vec.begin(), vec.end()));
    
    
    
    return answer;
}
