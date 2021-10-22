package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = 0;
        int memo[] = new int[m];
        char arr[] = br.readLine().toCharArray();

        for(int i=1; i<m-1; i++){
            if(arr[i] == 'O' && arr[i+1] == 'I'){
                memo[i+1] = memo[i-1] + 1;

                if(memo[i+1] >= n && arr[i - 2*n + 1] == 'I')
                    answer++;
            }
        }

        System.out.println(answer);
    }
}
