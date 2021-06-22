package test;

import java.util.Scanner;

public class boj1912 {
    static int n;
    static int max;
    static int arr[];
    static Integer dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new Integer[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        max = arr[0];
        dp[0] = arr[0];
        DP(n-1);
        System.out.println(max);
    }
    static int DP(int n){
        if(dp[n] == null){
            dp[n] = Math.max(DP(n-1)+arr[n], arr[n]);
            max = Math.max(max,dp[n]);
        }
        return dp[n];

    }
}
