package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463 {

    static Integer arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new Integer[n+1];
        arr[0] = arr[1] = 0;

        System.out.println(dynamic(n));

    }
    public static int dynamic(int n){
        if(arr[n] == null) {
            if(n % 6 == 0){
                arr[n] = Math.min(dynamic(n - 1),Math.min(dynamic(n / 3), dynamic(n / 2))) + 1;
            }
            else if (n % 3 == 0) {
                arr[n] = Math.min(dynamic(n / 3), dynamic(n - 1)) + 1;
            } else if (n % 2 == 0) {
                arr[n] = Math.min(dynamic(n / 2), dynamic(n - 1)) + 1;
            } else {
                arr[n] = dynamic(n - 1) + 1;
            }
        }
        return arr[n];
    }
}
