import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));    
        }
        
        int result = 0;
        for(int i = 0; i < N-1; i++){
            int group1 = pq.poll();
            int group2 = pq.poll();
            result += group1;
            result += group2;
            pq.add(group1 + group2);
        }
        
        System.out.println(result);
    }
}