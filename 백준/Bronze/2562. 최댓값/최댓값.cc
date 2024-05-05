#include <iostream>
using namespace std;

int main(){
    int num[9];
    
    for(int i = 0; i < 9; i++){
        string line;
        getline(cin, line);
        num[i] = stoi(line);
    }
    
    int max_index = 0;
    for(int i = 1; i < 10; i++){
        if(num[max_index] < num[i])
            max_index = i;
    }
    
    cout << num[max_index] << endl;
    cout << max_index + 1 << endl;
    
    return 0;
}