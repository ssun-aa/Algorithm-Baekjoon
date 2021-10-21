package boj;

import java.io.*;
import java.util.*;

public class boj1780 {
    static int arr[][], minus = 0, zero = 0, plus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
    static void partition(int r, int c, int s){
        if(check(r,c,s)){
            if(arr[r][c] == -1)
                minus++;
            else if(arr[r][c] == 0)
                zero++;
            else
                plus++;
            return;
        }

        int newSize = s / 3;

        partition(r, c, newSize);
        partition(r, c + newSize, newSize);
        partition(r, c + 2 * newSize, newSize);

        partition(r + newSize, c, newSize);
        partition(r + newSize, c + newSize, newSize);
        partition(r + newSize, c + 2 * newSize, newSize);

        partition(r + 2 * newSize, c, newSize);
        partition(r + 2 * newSize, c + newSize, newSize);
        partition(r + 2 * newSize, c + 2 * newSize, newSize);
    }

    static boolean check(int r, int c, int s){
        int color = arr[r][c];
        for(int i=r; i<r+s; i++){
            for(int j=c; j<c+s; j++){
                if(color != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
