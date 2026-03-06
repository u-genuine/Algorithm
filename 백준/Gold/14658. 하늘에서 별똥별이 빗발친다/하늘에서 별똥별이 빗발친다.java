import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 500,000
        int M = Integer.parseInt(st.nextToken()); // 500,000
        int L = Integer.parseInt(st.nextToken()); // 100,000
        int K = Integer.parseInt(st.nextToken()); // 100

        List<Star> stars = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new Star(x, y));
        }

        Collections.sort(stars, (a, b) -> a.x - b.x);
        int answer = 0;
        for(int i = 0; i < K; i++) {
            int right = i;
            Star s1 = stars.get(i);
            
            for(int j = i + 1; j < K; j++) {
                Star s2 = stars.get(j);
                if(s2.x <= s1.x + L) { // x좌표 먼저
                    right = j;
                }
            }

            int yArr[] = new int[right-i+1];
            for(int k = i; k <= right; k++) {
                yArr[k-i] = stars.get(k).y;
            }

            Arrays.sort(yArr); // y 좌표 정렬

            int yLeft = 0;
            int count = 0;
            for(int yRight = 0; yRight < yArr.length; yRight++) {
                while(yArr[yRight] > yArr[yLeft] + L) {
                    yLeft++;
                }
                count = Math.max(count, yRight - yLeft + 1);
            }

            answer = Math.max(answer, count);
        }

        System.out.println(K - answer);
    }
}

class Star {
    int x;
    int y;

    Star(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
