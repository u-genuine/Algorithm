#include <iostream>
#include <string>
using namespace std;

int main(){
    int N;
    string num;
    
    cin >> N;
    cin >> num;
    
    int sum = 0;
    for(int i = 0; i < num.length(); i++){
        sum += (int)num[i] - '0';
    }
    
    cout << sum;
}