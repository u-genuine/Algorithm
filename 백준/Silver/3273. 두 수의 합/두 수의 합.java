import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        
        // 오름차순 정렬
        Arrays.sort(nums);
        
        int idx1 = 0;
        int idx2 = N-1;
        int count = 0;
        while(idx1 < idx2) {
            if(nums[idx1] + nums[idx2] == target) {
                count++;
                idx1++;
                idx2--;
            } else if (nums[idx1] + nums[idx2] < target) {
                idx1++;
            } else {
                idx2--;
            }
        }
        
        System.out.println(count);
    }
}