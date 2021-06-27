package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1149 {
    static int n;
    static int arr[][];
    static int cost[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        cost = new int[n][3];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cost[0][0] = arr[0][0];
        cost[0][1] = arr[0][1];
        cost[0][2] = arr[0][2];

        System.out.println(Math.min(calculation(n-1,0),Math.min(calculation(n-1,1),calculation(n-1,2))));
    }
    public static int calculation(int n, int color){
        if(cost[n][color] == 0){
            if(color == 0){//red
                cost[n][0] = arr[n][0] + Math.min(calculation(n-1,1),calculation(n-1,2));
            }
            else if(color == 1){//green
                cost[n][1] = arr[n][1] + Math.min(calculation(n-1,0),calculation(n-1,2));
            }
            else if(color == 2){//blue
                cost[n][2] = arr[n][2] + Math.min(calculation(n-1,0),calculation(n-1,1));
            }
        }
        return cost[n][color];
    }
}
