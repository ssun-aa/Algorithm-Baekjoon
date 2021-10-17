package boj;

import java.util.Scanner;

public class boj1389 {
    static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int friends[][] = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                friends[i][j] = INF;
                if(i == j){
                    friends[i][j] = 0;
                }
            }
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(friends[i][j] > friends[i][k] + friends[k][j])
                        friends[i][j] = friends[i][k] + friends[k][j];
                }
            }
        }

        int max = INF;
        int answer = 0;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += friends[i][j];
            }
            if(max > sum){
                max = sum;
                answer = i;
            }
        }
        System.out.println(answer);

    }
}
