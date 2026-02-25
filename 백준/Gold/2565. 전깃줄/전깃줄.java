import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());

        List<Wire> wires = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < lines; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            wires.add(new Wire(A, B));
        }

        wires.sort((w1, w2) -> w1.a - w2.a); // a기준 오름차순 정렬

        int arr[] = new int[lines];
        for(int i = 0; i < lines; i++) {
            arr[i] = wires.get(i).b;
        }

        // Longest Increasing Subsequence
        int longestLength = 0;
        int[] dp = new int[lines];
        for (int i = 0; i < lines; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longestLength = Math.max(dp[i], longestLength);
        }

        System.out.println(lines - longestLength);
    }
}

class Wire {
    int a;
    int b;

    Wire(int a, int b) {
        this.a = a;
        this.b = b;
    }
}