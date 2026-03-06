import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int increLen[] = new int[N];
        Arrays.fill(increLen, 1);
        for(int i = 0; i < N; i++) {
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]) {
                    increLen[i] = Math.max(increLen[i], increLen[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, increLen[i]);
        }

        System.out.println(N - max);
        
    }
}