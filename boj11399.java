package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = 0;
        int p[] = new int[n];
        String str = br.readLine();
        String[] ps = str.split(" ");
        for(int i=0; i<n; i++)
            p[i] = Integer.parseInt(ps[i]);//String -> int로 변환
        Arrays.sort(p);//오름차순으로 정렬

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                min+=p[j];
            }
        }
         System.out.println(min);
    }

}
