package test;

import java.util.Scanner;

public class boj9251 {
    static String st1;
    static String st2;
    static Integer sequence[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        st1 = sc.next();
        st2 = sc.next();
        sequence = new Integer[st1.length()][st2.length()];

        System.out.println(LCS(st1.length()-1, st2.length()-1));
    }
    static int LCS(int x, int y){
        if(x == -1 || y == -1){
            return 0;
        }
        if(sequence[x][y] == null){
            if(st1.charAt(x) == st2.charAt(y))
                sequence[x][y] = LCS(x-1,y-1) + 1;
            else
                sequence[x][y] = Math.max(LCS(x-1,y), LCS(x,y-1));
        }
        return sequence[x][y];
    }
}
