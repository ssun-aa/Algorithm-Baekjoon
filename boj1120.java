package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int cnt;
        String str = br.readLine();//문자열 두개 입력
        String A[] = str.split(" ");//공백 기준으로 문자열 나눔
        for(int i=0; i<=A[1].length()-A[0].length(); i++){//문자열 길이 차이만큼 반복
            cnt = 0;
            for(int j=0; j<A[0].length(); j++){//짧은 문자열 길이만큼 반복
                if(A[0].charAt(j) != A[1].charAt(j+i)){//문자 불일치시
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}
