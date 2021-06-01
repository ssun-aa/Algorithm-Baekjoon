package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            if(i % 10 == 0 && i != 0){
                System.out.println();
            }
            System.out.print(str.charAt(i));
        }
    }
}
