package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int alpha[] = new int[26];
        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) <='Z')//대문자면
                alpha[str.charAt(i) - 'A']++;
            else if(str.charAt(i) <='z')//소문자면
                alpha[str.charAt(i) - 'a']++;
        }
        char n = '?';
        for(int i=0; i<alpha.length; i++){
            if(max < alpha[i]) {//최대값 갱신
                max = alpha[i];
                n = (char)('A'+i);
            }
            else if(max == alpha[i]) {//최대값이 같으면
                n = '?';
            }
        }
        System.out.println(n);
    }
}
