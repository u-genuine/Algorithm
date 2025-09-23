import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        boolean find = false;
        
        for(int i = N-1; i >= 0; i--) {
            if(find) {
                break;
            }
            
            int target = arr[i];

            for(int j = i - 1; j >= 0; j--) {
                if(find) break;    
                
                int idx1 = 0;
                int idx2 = j;
                int num3 = arr[j];

                int targetSum = target - num3;
                while(idx1 <= idx2) {
                    int num1 = arr[idx1];
                    int num2 = arr[idx2];

                    if(num1 + num2 == targetSum) {
                        find = true;
                        System.out.println(target);
                        break;
                    } else if (num1 + num2 > targetSum) {
                        idx2--;
                    } else {
                        idx1++;
                    }
                }
            }
        }
    }
}