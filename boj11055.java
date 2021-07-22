package test;

import java.util.Scanner;

public class boj11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            dp[i] = arr[i];
            for(int j=0; j<i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[j] + arr[i] , dp[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i: dp) {
            if (i > max)
                max = i;
        }
        System.out.println(max);
    }
}
