package boj;

import javax.management.QueryEval;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Tomato{
    int x;
    int y;
    int z;
    int d;
    Tomato(int x, int y, int z, int d){
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
    }
}
public class boj7569 {
    static int M, N, H, tomatos[][][], copy[][][],
    dx[] = {-1, 0, 0, 1, 0, 0}, dy[] = {0, -1, 0, 0, 1, 0}, dz[] = {0, 0, -1, 0, 0, 1}, day = 0;
    static boolean visit[][][];
    static Queue<Tomato> que;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        tomatos = new int[H][N][M];
        que = new LinkedList<>();

        for (int i=0; i<H; i++){
            for (int j=0; j<N; j++){
                for (int k=0; k<M; k++){
                    tomatos[i][j][k] = sc.nextInt();
                    if(tomatos[i][j][k] == 1)
                        que.add(new Tomato(k, j, i, 0));
                }
            }
        }

        bfs();

        if(check())
            System.out.println(day);
        else
            System.out.println(-1);
    }
    static void bfs(){
        while(!que.isEmpty()){
            Tomato tomato = que.poll();
            day = tomato.d;

            for(int i=0; i<6; i++){
                int nextX = tomato.x + dx[i];
                int nextY = tomato.y + dy[i];
                int nextZ = tomato.z + dz[i];

                if(nextX >=0 && nextX < M && nextY >=0 && nextY < N && nextZ >=0 && nextZ < H){
                    if(tomatos[nextZ][nextY][nextX] == 0){
                        tomatos[nextZ][nextY][nextX] = 1;
                        que.add(new Tomato(nextX, nextY, nextZ, day+1));
                    }
                }
            }
        }
    }

    static boolean check(){
        for (int i=0; i<H; i++){
            for (int j=0; j<N; j++){
                for (int k=0; k<M; k++) {
                    if (tomatos[i][j][k] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}
