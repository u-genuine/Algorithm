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

        int answer = 0;
        for(int i = 0; i < N; i++) {
            int count = 0;
            // 왼쪽
            double linL = Double.MAX_VALUE;
            for(int j = i - 1; j >= 0; j--) {
                double curLin = (double)(arr[i] - arr[j]) / (i - j);
                if(linL > curLin) {
                    count++;
                    linL = curLin;
                }
            }
            
            // 오른쪽
            double linR = - Double.MAX_VALUE;
            for(int j = i + 1; j < N; j++) {
                double curLin = (double)(arr[j] - arr[i])/(j - i);
                if(linR < curLin) {
                    count++;
                    linR = curLin;
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}