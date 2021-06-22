package test;

import java.util.Scanner;

public class boj1932 {
    static int arr[][];
    static Integer dp[][];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        dp = new Integer[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            dp[n-1][i] = arr[n-1][i];
        }
        System.out.println(DP(0,0));

    }
    public static int DP(int i, int j){
        if(dp[i][j] == null)
            dp[i][j] = Math.max(DP(i+1, j),DP(i+1,j+1)) + arr[i][j];
        return dp[i][j];
    }
}
