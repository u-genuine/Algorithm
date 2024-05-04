#include <iostream>
using namespace std;

int main(){
    string a;
    int cnt = 1;
    getline(cin, a);
    
    for (int i = 0; i < a.length(); i++){
        if(a[i] == ' ')
            cnt++;
    }
    
    if(a[0] == ' ')
        cnt--;
    
    if(a[a.length() - 1] == ' ')
        cnt--;
    
    cout << cnt;
    return 0;
}