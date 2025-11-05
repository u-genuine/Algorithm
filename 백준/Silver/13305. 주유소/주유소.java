import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N]; // 1 ~ N-1 바로 다음 도시까지 거리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] ppl = new int[N]; // 1 ~ N-1
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) {
            ppl[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 값
        int min = ppl[1];
        int total = min * distance[1];
        
        for(int i = 2; i < N; i++) {
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
