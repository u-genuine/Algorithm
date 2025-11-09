import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 입국심사대
        int M = Integer.parseInt(st.nextToken()); // 대기자 수

        int[] time = new int[N];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
            if(min > time[i]) {
                min = time[i];
            }
        }
        
        long left = 1;
        long right = (long)min * M; // 최소 시간 심사대에 모두 다 받는 경우
        long result = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long capacity = 0;
            for(int i = 0; i < N; i++) {
                capacity += mid / time[i]; // 각 심사대에서 시간 안에 처리 가능한 사람 수
                if(capacity >= M) {
                    break;
                }
            }

            if(capacity >= M) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}

/*
M명이 한 줄로 서있음
N개의 입국심사대

최소 시간을 구해야 하니까 시간 기준으로 이분탐색

*/