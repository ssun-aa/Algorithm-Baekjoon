package boj;

import java.util.Scanner;

public class boj12871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String S = s;
        String t = sc.nextLine();
        String T = t;
        if(s.length() != t.length()){
            int x = (s.length() * t.length())/gcd(s.length(), t.length());
            System.out.println(x);
            while(S.length() != x){
                S += s;
            }
            System.out.println(s);
            while(T.length() != x){
                T += t;
            }
            System.out.println(t);
        }
        if(S.equals(T))
            System.out.println(1);
        else
            System.out.println(0);

    }
    static int gcd(int n, int m){
        while(m > 0){
            int temp = n;
            n = m;
            m = temp%m;
        }
        return n;
    }
}
