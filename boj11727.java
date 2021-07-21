package test;

import java.util.Scanner;

public class boj11727 {
    static Integer dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[n+1];
        dp[1] = 1;
        dp[2] = 3;
        System.out.println(func(n));
    }
    static int func(int n){
        if(dp[n] == null)
            dp[n] = (func(n-1) + (2 * func(n-2))) %10007;
        return dp[n];
    }
}
