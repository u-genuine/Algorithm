import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottomCount = new int[H + 1]; // 1 ~ H
        int[] topCount = new int[H + 1]; // 1 ~ H
        for(int i = 0; i < N; i++) {
            int length = Integer.parseInt(br.readLine());
            if(i % 2 == 0) { // 석순
                bottomCount[length]++;
            } else { // 종유석
                topCount[length]++;
            }
        }

        int[] bottomHit = new int[H + 2]; // 1 ~ H+1(0);
        for(int i = H; i >= 1; i--) {
            bottomHit[i] = bottomHit[i+1] + bottomCount[i];
        }

        int[] topHit = new int[H + 1]; // 0(0) ~ H;
        for(int i = 1; i <= H; i++) {
            topHit[i] = topHit[i-1] + topCount[H-i+1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 1; i <= H; i++) {
            int hitSum = bottomHit[i] + topHit[i];
            if(min > hitSum) {
                min = hitSum;
                count = 1;
            } else if (min == hitSum) {
                count++;
            }
        }

        System.out.print(min + " " + count);
    }
}