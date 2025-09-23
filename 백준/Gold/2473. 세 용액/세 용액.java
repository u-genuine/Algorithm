import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long ThreeSum = 3000000000L;
        int answerNum1 = arr[0];
        int answerNum2 = arr[1];
        int answerNum3 = arr[N-1];
        
        for(int i = 0; i < N-2; i++) {
            int idx1 = i + 1;
            int idx2 = N-1;

            while(idx1 < idx2) {
                long tempThreeSum = (long)arr[i] + arr[idx1] + arr[idx2];
                if(Math.abs(tempThreeSum) < Math.abs(ThreeSum)) {
                    ThreeSum = tempThreeSum;
                    answerNum1 = arr[i];
                    answerNum2 = arr[idx1];
                    answerNum3 = arr[idx2];
                }

                if(tempThreeSum < 0) {
                    idx1++;
                } else if(tempThreeSum > 0) {
                    idx2--;
                } else {
                    System.out.print(answerNum1 + " " + answerNum2 + " " + answerNum3);
                    return;
                }
            }
        }
        System.out.print(answerNum1 + " " + answerNum2 + " " + answerNum3);
    }
}
