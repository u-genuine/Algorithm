import java.util.Scanner;

public class Main{
    static int[] D;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        D = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            D[i] = -1;
        }
        
        D[0] = 0;
        D[1] = 1;
        
        fibo(n);
        System.out.println(D[n]);
    }
    
    public static int fibo(int n){
        if(D[n] != -1)
            return D[n];
        
        D[n] = fibo(n-1) + fibo(n-2);
        return D[n];
    }
}