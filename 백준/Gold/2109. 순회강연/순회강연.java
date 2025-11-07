import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Request> requestPQ = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Request r = new Request(d, p);
            requestPQ.add(r);
        }

        PriorityQueue<Integer> payPQ = new PriorityQueue<>();

        while(!requestPQ.isEmpty()) {
            Request r = requestPQ.poll();
            payPQ.add(r.p);

            while(payPQ.size() > r.d) {
                payPQ.poll();
            }
        }

        int result = 0;
        while(!payPQ.isEmpty()) {
            result += payPQ.poll();
        }

        System.out.println(result);
    }
}

class Request implements Comparable<Request> {
    int d;
    int p;

    Request(int d, int p) {
        this.d = d;
        this.p = p;
    }

    @Override
    public int compareTo(Request request) {
        if (this.d > request.d) {
            return 1;
        } else if (this.d < request.d) {
            return -1;
        } else {
            return 0;
        }
    }
}