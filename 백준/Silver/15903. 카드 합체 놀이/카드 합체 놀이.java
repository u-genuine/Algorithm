import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }
        
        for(int i = 0; i < M; i++) {
            long card1 = pq.poll();
            long card2 = pq.poll();
            pq.add(card1 + card2);
            pq.add(card1 + card2);
        }
        
        long result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }
        
        System.out.println(result);
    }
}