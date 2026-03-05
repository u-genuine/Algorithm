import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] inWindow = new boolean[1000001];
        long count = 0;
        int start = 0;
        for(int i = 0; i < N; i++) {
            while(inWindow[arr[i]]) {
                inWindow[arr[start]] = false;
                start++;
            }
            inWindow[arr[i]] = true;
            count += i - start + 1;
        }

        System.out.println(count);
    }
}