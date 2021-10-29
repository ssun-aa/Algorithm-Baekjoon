package boj;

import java.util.*;

class Area{
    int x;
    int y;
    Area(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj10026 {
    static char arr[][];
    static boolean visit[][];
    static int n, dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        arr = new char[n][n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextLine().toCharArray();
        }

        visit = new boolean[n][n];
        int count1 = 0, count2 = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visit[i][j]){
                    count1++;
                    bfs(i, j, false);
                }
            }
        }
        visit = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visit[i][j]){
                    count2++;
                    bfs(i, j, true);
                }
            }
        }

        System.out.println(count1+" "+count2);
    }
    static void bfs(int x, int y, boolean color){
        Queue<Area> que = new LinkedList<>();
        que.add(new Area(x, y));

        while(!que.isEmpty()){
            Area area = que.poll();
            for(int i=0; i<4; i++){
                int nextX = area.x + dx[i];
                int nextY = area.y + dy[i];

                if(nextX >=0 && nextX < n && nextY >= 0 && nextY < n){
                    if(!color){
                        if(!visit[nextX][nextY] && arr[x][y] == arr[nextX][nextY]){
                            que.add(new Area(nextX, nextY));
                            visit[nextX][nextY] = true;
                        }
                    }
                    else{
                        if(!visit[nextX][nextY]){
                            if(arr[x][y] == 'R' && arr[nextX][nextY] == 'G' ||
                                    arr[x][y] == 'G' && arr[nextX][nextY] == 'R' ||
                                    arr[x][y] == arr[nextX][nextY]){
                                que.add(new Area(nextX, nextY));
                                visit[nextX][nextY] = true;
                            }

                        }
                    }
                }
            }
        }
    }
}
