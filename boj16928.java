package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj16928 {
    static boolean visit[];
    static int count[];
    static int snakeOrLadder[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visit = new boolean[101];
        count = new int[101];
        snakeOrLadder = new int[101];
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n+m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            snakeOrLadder[a] = b;
        }
        bfs();
    }
    static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        count[1] = 0;
        visit[1] = true;

        while(!que.isEmpty()){
            int now = que.poll();
            if(now == 100){
                System.out.println(count[now]);
                return;
            }

            for(int i=1; i<=6; i++){
                int next = now + i;
                if(next > 100) continue;
                if(visit[next]) continue;
                visit[next] = true;

                if(snakeOrLadder[next] != 0){
                    if(!visit[snakeOrLadder[next]]){
                        que.add(snakeOrLadder[next]);
                        visit[snakeOrLadder[next]] = true;
                        count[snakeOrLadder[next]] = count[now] + 1;
                    }
                }
                else{
                    que.add(next);
                    count[next] = count[now] + 1;
                }
            }
        }
    }
}
