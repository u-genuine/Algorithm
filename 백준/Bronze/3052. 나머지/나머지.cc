#include <iostream>
using namespace std;

int main(){
    int mod42[42] = {0};
    int num;
    int count = 0;
    
    for (int i = 0; i<10; i++){
        cin >> num;
        mod42[num % 42]++;
    }
    
    
    for (int i = 0; i<42; i++){
        if(mod42[i] > 0)
            count++;
    }
    cout << count;
    
    return 0;
}