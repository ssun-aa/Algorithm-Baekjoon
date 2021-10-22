package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;
            int gcd = M * N / gcd(M,N);
            int num = x;
            boolean flag = false;

            while(num < N*M){
                if(num % N == y)
                    break;
                num += M;
            }
            num = num <= gcd ? num +1 : -1;
            System.out.println(num);
        }

    }
    static int gcd(int m, int n){
        if(m % n == 0)
            return n;
        else
            return gcd(n, m%n);
    }
}
