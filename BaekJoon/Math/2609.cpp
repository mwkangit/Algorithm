#include <iostream>
#include <string>
#include <stack>
#include <queue>
#include <vector>


using namespace std;

int gcd(int num1, int num2){
    int mod;
    mod = num1 % num2;
    while(mod != 0){
        num1 = num2;
        num2 = mod;
        mod = num1 % num2;
    }

    return num2;

}

int lcd(int num1, int num2){

    return num1 * num2 / gcd(num1, num2);
}


int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num1, num2, temp;
    cin >> num1 >> num2;

    if(num1 < num2){
        temp = num1;
        num1 = num2;
        num2 = temp;
    }

    cout << gcd(num1, num2) << "\n" << lcd(num1, num2);


}
