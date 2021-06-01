package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        String sub[] = str.split("-");//'-'기준으로 나눔
        for(int i=0; i<sub.length; i++){
            int temp = 0;
            String add[] = sub[i].split("\\+");//'+'기준으로 나눔

            for(int j=0; j<add.length; j++){//더하기 연산
                temp += Integer.parseInt(add[j]);
            }
            if(i == 0)//첫번째 수 이면
                sum = temp;//대입
            else//첫번째 수가 아니면
                sum -= temp;//뺄셈 연산
        }
        System.out.println(sum);
    }
}
