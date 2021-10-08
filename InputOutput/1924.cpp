#include <iostream>

using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int x, y, sum = 0;

    cin >> x >> y;

    for(int i = 1 ; i < x ; i++){
        sum += month[i];
    }
    sum += y;

    switch(sum % 7){
        case 0:
            cout << "SUN";
            break;
        case 1:
            cout << "MON";
            break;
        case 2:
            cout << "TUE";
            break;
        case 3:
            cout << "WED";
            break;
        case 4:
            cout << "THU";
            break;
        case 5:
            cout << "FRI";
            break;
        case 6:
            cout << "SAT";
            break;

    }

        
}