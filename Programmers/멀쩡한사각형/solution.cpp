using namespace std;

int gcd(int w, int h){
    int c;
    while(h != 0){
        c = w % h;
        w = h;
        h = c;
    }
    return w;
}


long long solution(int w,int h) {
    long long first = (long long)w * (long long)h;
    long long w_low = (long long)w / (long long)gcd(w,h);
    long long h_low = (long long)h / (long long)gcd(w,h);
    long long minus = w_low + h_low - 1;
    
    long long answer = first - (minus * (long long) (long long)gcd(w,h));
    return answer;
}
