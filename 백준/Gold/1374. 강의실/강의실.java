import java.util.*;
import java.io.*;

class Main {
    static class Lecture {
        int number;
        long start;
        long end;
        
        Lecture(int number, long start, long end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        Lecture[] lectures = new Lecture[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            
            lectures[i] = new Lecture(number, start, end);
        }
        
        Arrays.sort(lectures, (l1, l2) -> {
            if(l1.start == l2.start){
                return Long.compare(l1.end, l2.end);
            }
            return Long.compare(l1.start, l2.start);
        });
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);
        
        for(int i = 1; i < N; i++) {
            if(lectures[i].start >= pq.peek()){
                pq.poll();
            }
            pq.add(lectures[i].end);
        }
        
        System.out.println(pq.size());
    }
}