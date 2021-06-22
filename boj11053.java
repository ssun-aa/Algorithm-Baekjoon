package test;

import java.util.Scanner;

public class boj11053 {
    static int arr[];
    static Integer dp[];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new Integer[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            LTS(i);
        }
        for(int i=0; i<n; i++){
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
    static int LTS(int n){
        if(dp[n] == null){
            dp[n] = 1;

            for(int i=n-1; i>=0; i--){
                if(arr[n] > arr[i])
                    dp[n] = Math.max(dp[n], LTS(i)+1);
            }
        }
        return dp[n];
    }
}
