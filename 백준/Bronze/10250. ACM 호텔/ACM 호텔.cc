#include <iostream>
using namespace std;

int main(){
    int T;
    
    
    cin >> T;
    
    for(int i = 0; i < T; i++){
        int H, W, N;
        cin >> H >> W >> N;
        
        int result;
       
        if(N % H == 0)
            result = H * 100 + (N/H);
        else
            result = (N%H)*100 + N/H + 1 ;
        
        cout << result << endl;
    }
    
    return 0;
}