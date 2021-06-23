package test;

import java.util.Scanner;

public class boj2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long dp[][] = new long[n+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        long sum = 0;
        sum += dp[n][0] + dp[n][1];
        System.out.println(sum);
    }
}
