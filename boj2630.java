package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630 {
    static int arr[][], white = 0, blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }
    static void partition(int r,int c,int s){
        if(check(r,c,s)){
            if(arr[r][c] == 0)
                white++;
            else
                blue++;
            return;
        }

        int newSize = s / 2;
        partition(r, c, newSize);
        partition(r, c + newSize, newSize);
        partition(r + newSize, c, newSize);
        partition(r + newSize, c + newSize, newSize);
    }

    static boolean check(int r, int c, int s){
        int num = arr[r][c];

        for(int i=r; i<r+s; i++){
            for(int j=c; j<c+s; j++){
                if(num != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
