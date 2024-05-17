#include <iostream>
#include <string>
using namespace std;

int main(){
    int T;
    cin >> T;
    
    for (int i = 0; i<T; i++){
        string str;
        cin >> str;
        
        int combo = 0;
        int result = 0;
        
        for (int j = 0; j < str.length(); j++){
            if(str[j] == 'O'){
                combo++;
                result += combo;
            } else{
                combo = 0;
            }
        }
        
        cout << result << endl;
    }
    return 0;
}