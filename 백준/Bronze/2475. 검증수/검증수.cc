#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int num[5];
    for(int i = 0; i<5; i++)
        cin >> num[i];
    
    int sixth_num = 0;
    
    for(int i = 0; i<5; i++){
        sixth_num += pow(num[i], 2);
    }
    sixth_num %= 10;
    cout << sixth_num;
    
    return 0;
}