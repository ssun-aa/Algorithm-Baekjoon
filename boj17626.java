package boj;

import java.util.Scanner;

public class boj17626 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        arr[1] = 1;

        int min = 0;
        for(int i=2; i<=n; i++){
            min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                int tmp = i - j * j;
                min = Math.min(min, arr[tmp]);
            }
            arr[i] = min + 1;
        }
        System.out.println(arr[n]);

    }
}
