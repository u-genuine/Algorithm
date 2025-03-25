import java.util.*;
import java.io.*;

class Main {
    static class Meeting{
        int start;
        int end;
        
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        Meeting[] meetings = new Meeting[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            meetings[i] = new Meeting(start, end);
        }
        
        Arrays.sort(meetings, (m1, m2) -> {
            if (m1.end == m2.end) {
                return m1.start - m2.start;
            }
            return m1.end - m2.end;
        });
        
        int count = 1;
        int end = meetings[0].end;
        for(int i = 1; i < N; i++){
            if(meetings[i].start >= end) {
                end = meetings[i].end;
                count++;
            }
        }
        
        System.out.println(count);
    }
}