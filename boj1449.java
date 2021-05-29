package test;

import java.util.Arrays;
import java.util.Scanner;

public class boj1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int leak[] = new int[n];
        for(int i=0; i<n; i++){
            leak[i] = sc.nextInt();
        }
        Arrays.sort(leak);
        int start = leak[0];
        int count = 1;
        for(int i=0; i<n; i++){
            if(leak[i] > start + l){
                start = leak[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
