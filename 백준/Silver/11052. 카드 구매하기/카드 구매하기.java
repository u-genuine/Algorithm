import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N + 1]; // 1 ~ N 인덱스에 값 저장
        int[] dp = new int[N + 1]; // 인덱스 개수 최대 금액 저장
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = price[1];
        for(int i = 2; i <= N; i++) {
            dp[i] = price[i];
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], (i / j)*dp[j] + dp[i%j]);
            }
        }
        
        System.out.println(dp[N]);
    }
}