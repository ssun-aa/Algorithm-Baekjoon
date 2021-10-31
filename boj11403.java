package boj;

import java.util.Scanner;

public class boj11403 {
    static int  N, graph[][], answer[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        answer = new int[N][N];
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        floyd();

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void floyd(){
        for (int k = 0; k < N; k++) {
            for(int i=0; i<N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
                }
            }
        }
    }
}
