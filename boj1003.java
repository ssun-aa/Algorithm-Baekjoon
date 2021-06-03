package test;

import java.util.Scanner;

public class boj1003 {
    static int arr[][] = new int[41][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            arr[0][0] = 1;
            arr[0][1] = 0;
            arr[1][0] = 0;
            arr[1][1] = 1;
            func(x);
            System.out.println(arr[x][0]+" "+arr[x][1]);
        }
    }
    public static void func(int n){
        for(int i=2; i<=n; i++){
            arr[i][0] = arr[i-1][0]+ arr[i-2][0];
            arr[i][1] = arr[i-1][1]+ arr[i-2][1];
        }
    }
}
