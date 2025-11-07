import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewels = new PriorityQueue<>((j1, j2) -> {
            return j1.m - j2.m;
        });
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }

        // 가방 무게 가벼운 순
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for(int i = 0; i < K; i++) {
            int capacity = Integer.parseInt(br.readLine());
            bags.add(capacity);
        }

        long result = 0;

        PriorityQueue<Integer> tempJewels = new PriorityQueue<>((i1, i2) -> {
          return i2 - i1;
        });
    
        while(!bags.isEmpty()) {
            int capacity = bags.poll();
            while(!jewels.isEmpty()) {
                Jewel next = jewels.peek();
                if(next.m <= capacity) {
                    tempJewels.add(jewels.poll().v);
                } else {
                    break;
                }
            }

            if(!tempJewels.isEmpty()) result += tempJewels.poll();
        }

        System.out.println(result);
    }
}

class Jewel {
    int m;
    int v;

    Jewel (int m, int v) {
        this.m = m;
        this.v = v;
    }
}