import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Flower> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken()) * 100;
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken()) * 100;
            int endD = Integer.parseInt(st.nextToken());    
            pq.add(new Flower(startM + startD, endM + endD));
        }

        int count = 0;
        int startDay = 301;
        int targetDate = 1201;
        int maxDate = startDay;
        
        while(startDay < targetDate) {
            while(!pq.isEmpty() &&
                  pq.peek().startDate <= startDay) {
                Flower temp = pq.poll();
                maxDate = Math.max(maxDate, temp.endDate);
            }

            if(maxDate == startDay) {
                count = 0;
                break;
            }

            count++;
            startDay = maxDate;
        }

        if(startDay < targetDate) {
            System.out.println(0);
            return;
        }
        
        System.out.println(count);
    }
}
    
// 1) 시작일 빠른 순. 2) 종료일 느린 순
class Flower implements Comparable<Flower> {
    int startDate;
    int endDate;

    Flower(int startDate, int endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public int compareTo(Flower f2) {
     if(this.startDate < f2.startDate) {
            return -1;
        } else if(this.startDate > f2.startDate) {
            return 1;
        } else {
            if (this.endDate > f2.endDate) {
                return -1;
            } else if(this.endDate < f2.endDate) {
                return 1;
            } else {
                return 0;
            }
         }
    }
}