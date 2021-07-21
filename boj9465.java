package test;

import java.util.Scanner;

public class boj9465 {
    static int dp[][];
    static int cost[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i=0; i<testcase; i++){
            int n = sc.nextInt();
            dp = new int[2][n+1];
            cost = new int[2][n+1];
            for(int j=0; j<2; j++) {
                for (int k=1; k<=n; k++)
                    cost[j][k] = sc.nextInt();
            }
            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];

            for(int j=2; j<=n; j++){//점화식!!
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + cost[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + cost[1][j];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
