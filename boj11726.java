package test;

import java.util.Scanner;

public class boj11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[1001];// new int[n+1]으로 하면
        arr[1] = 1;
        arr[2] = 2;//n=1일 경우 이 부분에서 런타임 에러가 발생
        for(int i=3; i<=n; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        System.out.println(arr[n]);
    }
}
