import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrN = new int[N];
  
        for(int i = 0; i < N; i++) {
            arrN[i] = sc.nextInt();
        }
        
        Arrays.sort(arrN);
        
        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            int answer = binarySearch(arrN, 0, N-1, sc.nextInt());
            System.out.println(answer);
        }
        
    }
    
    public static int binarySearch(int[] arr, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}