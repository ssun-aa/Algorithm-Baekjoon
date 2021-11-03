package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Num{
    int n;
    int cnt;
    Num(int n, int cnt){
        this.n = n;
        this.cnt = cnt;
    }
}
public class boj16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        int answer = 1;
        while(a != b) {
            if (a > b) {
                answer = -1;
                break;
            }
            String sb = String.valueOf(b);

            if (b % 2 == 0)
                b = b / 2;
            else if (b % 10 == 1){
                sb = sb.substring(0, sb.length() - 1);
                b = Long.parseLong(sb);
            }
            else{
                answer = -1;
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
