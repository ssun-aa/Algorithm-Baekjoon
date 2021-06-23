package test;

import java.util.Scanner;

public class boj1010 {
    static long dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new long[31][31];
        for(int i=1; i<30; i++){
            dp[1][i] = i;
        }
        int test = sc.nextInt();
        for(int i=0; i<test; i++){
            System.out.println(func(sc.nextInt(), sc.nextInt()));
        }
    }
    static long func(int n, int m){
        if(dp[n][m] == 0){
            for(int i=1; i<=m-n+1; i++){
                dp[n][m] += func(n-1, m-i);
            }
        }
        return dp[n][m];
    }
}
