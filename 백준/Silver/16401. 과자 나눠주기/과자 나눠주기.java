import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] snack = new int[N];
        for(int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        int left = 1;
        int right = snack[N-1];
        int result = BS(left, right, M, snack);
        System.out.println(result);
    }

    static int BS(int left, int right, int M, int[] snack) {
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            
            for(int i = N-1; i >= 0; i--) {
                count += snack[i] / mid;
                if(count > M) {
                    break;
                }
            }
    
            if(count >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;        
    }
}