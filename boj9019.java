package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj9019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            String command[] = new String[10000];
            boolean visit[] = new boolean[10000];
            Queue<Integer> que = new LinkedList<>();

            visit[A] = true;
            que.add(A);
            command[A] = "";

            while(!que.isEmpty() && !visit[B]){
                int n = que.poll();
                int D = (2*n) % 10000;
                int S = n == 0 ? 9999 : n-1;
                int L = (n % 1000) * 10 + (n / 1000);
                int R = (n % 10) * 1000 + (n / 10);

                if(!visit[D]){
                    que.add(D);
                    visit[D] = true;
                    command[D] = command[n] + "D";
                }
                if(!visit[S]){
                    que.add(S);
                    visit[S] = true;
                    command[S] = command[n] + "S";
                }
                if(!visit[L]){
                    que.add(L);
                    visit[L] = true;
                    command[L] = command[n] + "L";
                }
                if(!visit[R]) {
                    que.add(R);
                    visit[R] = true;
                    command[R] = command[n] + "R";
                }
            }
            System.out.println(command[B]);
        }

    }
}
