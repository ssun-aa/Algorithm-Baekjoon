package boj;

import java.util.Scanner;

public class boj1107 {
    static boolean wrong[] = new boolean[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i=0; i<M; i++){
            int num = sc.nextInt();
            wrong[num] = true;
        }

        int answer = Math.abs(N-100);
        for(int i=0; i<=1000000; i++){
            int len = check(i);
            if(len > 0){
                int rest = Math.abs(N - i);
                answer = Math.min(answer, len + rest);
            }
        }
        System.out.println(answer);
    }
    static int check(int n){
        if(n == 0){
            if(wrong[0])
                return 0;
            else
                return 1;
        }
        int len = 0;
        while(n > 0){
            if(wrong[n % 10])
                return 0;
            n /= 10;
            len++;
        }
        return len;
    }
}
