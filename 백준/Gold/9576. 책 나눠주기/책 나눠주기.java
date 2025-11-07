import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Request> pq = new PriorityQueue<>((r1, r2) -> {
                if(r1.end == r2.end) return r1.start - r2.start;
                return r1.end - r2.end;
            });
            
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                pq.add(new Request(start, end));
            }

            boolean[] takenBook = new boolean[N+1];
            
            int count = 0;
            while(!pq.isEmpty()) {
                Request cur = pq.poll();

                for(int i = cur.start; i <= cur.end; i++) {
                    if(!takenBook[i]) {
                        takenBook[i] = true;
                        count++;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }
}

class Request {
    int start;
    int end;
    
    Request(int start, int end) {
        this.start = start;
        this.end = end;
    }
}