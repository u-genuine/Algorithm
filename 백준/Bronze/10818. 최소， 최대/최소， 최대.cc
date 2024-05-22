#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]){

    int N;
    cin >> N;
    
    int min = 1000000;
    int max = -1000000;
    
    int num;
 
    for(int i = 0; i < N; i++){
        cin >> num;
        if(min > num) min = num;
        if(max < num) max = num;
    }
    
   
    cout << min << ' ' << max;
}