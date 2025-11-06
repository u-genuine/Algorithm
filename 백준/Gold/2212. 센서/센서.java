import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        int[] distance = new int[N-1];
        for(int i = 0; i < N - 1; i++) {
            distance[i] = sensor[i + 1] - sensor[i];
        }

        Arrays.sort(distance);
        int result = 0;
        for(int i = 0; i < N - K; i++) {
            result += distance[i];
        }

        System.out.println(result);
    }
}