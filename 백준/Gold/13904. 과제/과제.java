import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Homework> homeworks = new PriorityQueue<>((h1, h2) -> h1.dday - h2.dday);
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            homeworks.add(new Homework(d, w));
        }

        PriorityQueue<Integer> get = new PriorityQueue<>();
        while(!homeworks.isEmpty()) {
            Homework cur = homeworks.poll();
            get.add(cur.point);

            while(get.size() > cur.dday) {
                get.poll();
            }
        }

        int result = 0;
        while(!get.isEmpty()) {
            result += get.poll();
        }

        System.out.println(result);
    }
}

class Homework {
    int dday;
    int point;

    Homework(int dday, int point) {
        this.dday = dday;
        this.point = point;
    }
}