import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N]; // 1 ~ N-1 바로 다음 도시까지 거리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        
        long[] ppl = new long[N]; // 1 ~ N-1
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) {
            ppl[i] = Long.parseLong(st.nextToken());
        }

        long min = Integer.MAX_VALUE;
        long total = 0;
        
        for(int i = 1; i < N; i++) {
            if(min >= ppl[i]) {
                min = ppl[i];
                total += ppl[i] * distance[i];
                
            } else {
                total += min * distance[i];
            }
        }

        System.out.println(total);
    }
}
