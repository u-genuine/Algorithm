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

        // 두 수의 합을 미리 저장
        Set<Integer> twoSum = new HashSet<>();
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                twoSum.add(arr[i] + arr[j]);
            }
        }
        
        for(int i = N-1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(twoSum.contains(arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}