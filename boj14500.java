package test;

import java.util.Scanner;

public class boj14500 {

	static int n, m, max=0;
	static int paper[][];
	static boolean visit[][];
	static int dx[]= {-1, 0, 1, 0};
	static int dy[]= {0, -1, 0, 1};
	
	public static void exception(int x, int y) {
		int sum = paper[x][y];
		int wings = 4;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX<0 || nextY<0 || nextX>=n ||nextY>=m) {//날개가 범위를 벗어나면 
				wings--;
				continue;
			}
			if(wings<3)//'ㅗ'모양은 날개가 3개는 있어야 완성되기 때문에 3개 미만인경우 종료
				return;
			min = Math.min(min, paper[nextX][nextY]);//날개 중 가장 작은 값 저장
			sum += paper[nextX][nextY];
		}
		if(wings == 4){//'+'모양일 경우 날개 하나를 빼야 'ㅗ'모양이 됨
			sum -=min;
		}
		max = Math.max(max, sum);//최대값 갱신
	}
	public static void dfs(int x, int y, int sum, int depth) {
		if(depth == 4) {//4칸 다 채웠으면
			max = Math.max(max, sum);//최대값 갱신
			return;
		}
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX<0 || nextY<0 || nextX>=n ||nextY>=m)//다음 칸이 범위를 벗어나면 
				continue;
			if(visit[nextX][nextY])//이미 방문 한 칸이면
				continue;
			visit[nextX][nextY] = true;
			dfs(nextX, nextY, sum+paper[nextX][nextY], depth+1);
			visit[nextX][nextY] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		paper = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dfs(i,j,0,0);//'ㅗ'모양을 제외한 나머지 모양
				exception(i,j);//'ㅗ'모양
			}
		}
		System.out.println(max);
	}

}
