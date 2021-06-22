package test;

import java.util.Scanner;

public class boj2579 {
    static Integer dp[];
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[n+1];
        arr = new int[n+1];
        for (int i=1; i<=n; i++)
            arr[i] = sc.nextInt();

        dp[0] = 0;
        dp[1] = arr[1];

        if(n >= 2)
            dp[2] = arr[1] + arr[2];
        System.out.println(func(n));
    }
    static int func(int n){
        if(dp[n] == null)
            dp[n] = Math.max(func(n-2), func(n-3) + arr[n-1]) + arr[n];
        return dp[n];
    }
}
