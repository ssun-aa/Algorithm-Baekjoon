package test;

import java.util.Scanner;

public class boj9095 {
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp= new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=0; i<n; i++){
            System.out.println(func(sc.nextInt()));

        }
    }
    public static int func(int n){
        for(int i=4; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        return dp[n];
    }
}
