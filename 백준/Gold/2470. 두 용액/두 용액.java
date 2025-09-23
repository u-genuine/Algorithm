import java.util.*;
import java.io.*;


class Main {
    static int[] arr;
    static int minGap = Integer.MAX_VALUE;
    static int resultIdx1;
    static int resultIdx2;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int idx1 = 0;
        int idx2 = N-1;

        while(idx1 < idx2) {
            int sum = arr[idx1] + arr[idx2];
            int abs = Math.abs(sum);
            
            if(abs < minGap) {
                minGap = abs;
                resultIdx1 = idx1;
                resultIdx2 = idx2;
            }

            if(sum > 0) {
                idx2--;
            } else if (sum < 0) {
                idx1++;
            } else {
                break;
            }
        }

        System.out.println(arr[resultIdx1] + " " + arr[resultIdx2]);
    }
}