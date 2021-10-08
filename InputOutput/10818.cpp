#include <iostream>

using namespace std;

int main(){
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, a, big = 0, small = 1000001;
    cin >> T;
    
    for(int i = 0 ; i < T ; i++){
        cin >> a;
        big = max(big, a);
        small = min(small, a);
    }
    
    cout << small << " " << big << endl;
    return 0;
        
}