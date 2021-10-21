package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1992 {
    static int arr[][];
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            String str[] = line.split("");
            for(int j=0; j<str.length; j++)
                arr[i][j] = Integer.parseInt(str[j]);
        }

        partition(0, 0, n);
        System.out.println(sb.toString());

    }
    static void partition(int r,int c,int s){
        if(check(r,c,s)){
            if(arr[r][c] == 1)
                sb.append("1");
            else
                sb.append("0");
            return;
        }

        int newSize = s / 2;
        sb.append("(");
        partition(r, c, newSize);
        partition(r, c + newSize, newSize);
        partition(r + newSize, c, newSize);
        partition(r + newSize, c + newSize, newSize);
        sb.append(")");
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
