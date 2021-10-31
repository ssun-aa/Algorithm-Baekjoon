package boj;

import java.util.Scanner;

public class boj11659 {
    static int numbers[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        numbers = new int[n+1];
        numbers[0] = 0;
        for(int i=1; i<=n; i++){
            numbers[i] = numbers[i-1] + sc.nextInt();
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(numbers[b] - numbers[a-1]);
        }

    }
}
