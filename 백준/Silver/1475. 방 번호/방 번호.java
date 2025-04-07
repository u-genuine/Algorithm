import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine(); // 9999
        String[] arrN = N.split(""); // 9, 9, 9, 9
        
        int[] nums = new int[10];
        
        for(String num : arrN) {
            int n = Integer.parseInt(num);
            nums[n]++;
        }
        
        double temp = Math.ceil(((double)(nums[6] + nums[9])) / 2) ;
        nums[6] = (int)temp;
        nums[9] = (int)temp;
        
        int result = 0;
        for(int i = 0; i < 10; i++) {
            result = Math.max(result, nums[i]);
        }
        
        System.out.println(result);
    }
}