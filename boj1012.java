package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Position{
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class boj1012 {
    static int field[][];
    static int M, N;
    static int dx[] ={-1, 0, 1, 0};
    static int dy[] ={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            field = new int[M][N];//배추밭
            int count = 0;//배추흰지렁이

            for (int j = 0; j < K; j++) {//배추가 있는 위치에 1 입력
                st = new StringTokenizer(br.readLine(), " ");
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                field[m][n] = 1;
            }
            for (int j = 0; j < M; j++) {
                for (int o = 0; o < N; o++) {
                    if(field[j][o] == 1) {//배추 위치에서 worm함수 호출
                        worm(j, o);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void worm(int x, int y){
        Queue<Position> que = new LinkedList();
        que.add(new Position(x,y));

        while(!que.isEmpty()){
            Position position = que.poll();
            for(int i=0; i<4; i++) {//상하좌우에 배추가 있다면
                int nextX = position.x + dx[i];
                int nextY = position.y + dy[i];
                if(nextX < M && nextY < N && nextX >= 0 && nextY >= 0){
                    if(field[nextX][nextY] == 1) {
                        field[nextX][nextY] = 0;//0으로 만들고
                        que.add(new Position(nextX,nextY));//큐에 넣기
                    }
                }
            }
        }
    }
}
