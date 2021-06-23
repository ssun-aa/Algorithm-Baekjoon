package test;

import java.util.Scanner;

public class boj9461 {
    static long dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i=0; i<test; i++){
            System.out.println(func(sc.nextInt()));

        }
    }
    static long func(int n){
        if(dp[n] == 0)
            dp[n] = func(n-1) + func(n-5);
        return dp[n];
    }
}
