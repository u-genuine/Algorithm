import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Integer.parseInt(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 합배열 O(N)
        long[] SumA = new long[N];
        SumA[0] = A[0];
        for(int i = 1; i < N; i++) {
            SumA[i] = SumA[i-1] + A[i];
        }
                
        long[] SumB = new long[M];
        SumB[0] = B[0];
        for(int i = 1; i < M; i++) {
            SumB[i] = SumB[i-1] + B[i];
        }

        // 부배열 합 저장 O(N^2) = O(10^6)
        List<Long> subtotalA = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            subtotalA.add(SumA[i]);
            for(int j = 0; j < i; j++) {
                subtotalA.add(SumA[i] - SumA[j]);
            }
        }
        
        List<Long> subtotalB = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            subtotalB.add(SumB[i]);
            for(int j = 0; j < i; j++) {
                subtotalB.add(SumB[i] - SumB[j]);
            }
        }

        Collections.sort(subtotalA);
        Collections.sort(subtotalB);
        int idxA = 0;
        int idxB = subtotalB.size() - 1;
        long total = 0;

        // 투포인터로 경우의 수 계산
        while(idxA < subtotalA.size() && idxB >= 0) {
            long temp = subtotalA.get(idxA) + subtotalB.get(idxB);
            
            if(temp > T) {
                idxB--; 
            } else if (temp < T) {
                idxA++;
            } else { // 합이 T인 경우
                long valueA = subtotalA.get(idxA);
                long valueB = subtotalB.get(idxB);
                
                long countA = 0;
                long countB = 0;

                // A 부배열 합에서 같은 값 개수 카운트
                while(idxA < subtotalA.size() && (valueA == subtotalA.get(idxA))) {
                    idxA++;
                    countA++;
                }

                
                // B 부배열 합에서 같은 값 개수 카운트
                while(idxB >= 0 && (valueB == subtotalB.get(idxB))) {
                    idxB--;
                    countB++;
                }

                total += countA * countB;
            }
        }
        
        System.out.println(total);
    }
}