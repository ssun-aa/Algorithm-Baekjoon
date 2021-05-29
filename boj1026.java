package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj1026 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer A[] = new Integer[n];
        Integer B[] = new Integer[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);//오름차순 정렬
        Arrays.sort(B, Collections.reverseOrder());//내림차순 정렬

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += A[i] * B[i];
        }
        System.out.println(sum);
    }
}
