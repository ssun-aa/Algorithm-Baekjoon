package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1074 {
    static int n, r, c, cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers[] = br.readLine().split(" ");
        n = Integer.parseInt(numbers[0]);
        r = Integer.parseInt(numbers[1]);
        c = Integer.parseInt(numbers[2]);
        func((int)Math.pow(2,n), r, c);
        System.out.println(cnt);
    }
    static void func(int n, int x, int y){
        if(n == 1)
            return;
        if(x < n/2 && y< n/2)//1사분면
            func(n/2, x, y);
        else if(x < n/2 && y >= n/2){//2사분면
            cnt += n * n / 4;
            func(n/2, x,y - n/2);
        }
        else if(x >= n/2 && y < n/2){//3사분면
            cnt += (n * n / 4) * 2;
            func(n/2, x - n/2, y);
        }
        else {//4사분면
            cnt += (n * n / 4) * 3;
            func(n / 2, x - n / 2, y - n / 2);
        }
    }
}
