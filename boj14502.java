package test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class boj14502 {
    static int lab[][];//연구소 지도
    static int virus_lab[][];//복사된 연구소 지도
    static int n, m;
    static int dx[] ={-1, 0, 1, 0};
    static int dy[] ={0, -1, 0, 1};
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lab = new int[n][m];
        virus_lab = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                lab[i][j] = sc.nextInt();
            }
        }
        wall(0);
        System.out.println(max);
    }
    public static void wall(int cnt){
        if(cnt == 3) {//벽 3개 다 세웠으면
            virus();//바이러스 퍼뜨리기
            return;
        }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(lab[i][j] == 0){//0인 부분에
                    lab[i][j] = 1;//벽 세우기
                    wall(cnt+1);
                    lab[i][j] = 0;
                }
            }
        }
    }
    public static void virus(){
        Queue<Pair> que = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                virus_lab[i][j] = lab[i][j];//바이러스 퍼뜨리기 전에 연구소 지도 복사
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(virus_lab[i][j] == 2){//바이러스(2)인 부분 큐에 추가
                    que.add(new Pair(i,j));
                }
            }
        }
        while(!que.isEmpty()){
            Pair p = que.poll();
            for(int i=0; i<4; i++) {//바이러스의 상하좌우에 0 이 있으면 퍼뜨리기
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (nextX >= n || nextY >= m || nextX < 0 || nextY < 0)
                    continue;
                if (virus_lab[nextX][nextY] != 0)
                    continue;
                virus_lab[nextX][nextY] = 2;
                que.add(new Pair(nextX, nextY));
            }
        }
        safe();//0의개수 count
    }
    public static void safe(){
        int count = 0;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_lab[i][j] == 0)
                    count++;
            }
        }
        max = Math.max(count, max);//최대값 뽑아내기
    }
}
