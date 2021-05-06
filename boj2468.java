package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
class region{
	int x;
	int y;
	public region(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class boj2468 {
	
	static int n;
	static int local[][];//지역 높이 배열
	static boolean sink[][];//지역 침수 여부 배열
	static boolean visit[][]; //지역 방문 여부 배열
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void reset(){//visit배열 초기화
		for(boolean i[] : visit)
			Arrays.fill(i,false);
	}
	
	public static void bfs(int x, int y) {
		Queue<region> que = new LinkedList<region>();
		que.add(new region(x,y));//해당 지역을 큐에 삽입
		visit[x][y] = true;//해당 지역 방문함
		
		while(!que.isEmpty()) {//큐가 비어질 때까지
			region reg = que.poll();//큐의 첫번째 지역을 꺼냄
			for(int i=0; i<4 ;i++) {
				int nextX = reg.x + dx[i];
				int nextY = reg.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)//다음 지역이 지도범위를 벗어나는 경우
					continue;
				if(visit[nextX][nextY] == true || sink[nextX][nextY] == true)//다음 지역이 방문한 적 있거나, 물에 잠긴경우
					continue;
				que.add(new region(nextX, nextY));//위의 경우가 아니면 큐에 해당 지역 삽입
				visit[nextX][nextY] = true;//해당 지역 방문함
			}
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num=0, count = 0;
		Integer result[];
		n = sc.nextInt();//지도 범위 
		
		local = new int[n][n];//지역 높이 배열
		sink = new boolean[n][n];//지역 침수 여부 배열
		visit = new boolean[n][n];//지역 방문 여부 배열
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				local[i][j]=sc.nextInt();//지역 높이 입력
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();//입력받은 지역의 높이정보를 중복없이 저장할 set
		set.add(0);//비가 안오는 경우 추가!!
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				set.add(local[i][j]);//지역 높이 정보 저장
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);

		result = new Integer[list.size()];//중복없이 저장한 list의 size만큼 result 배열 생성
		
		while(num < list.size()) {//지역의 높이만큼 비가 오게 반복
			count=0;//bfs 횟수 count 초기화
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(local[i][j]<=list.get(num)) {//비의 양보다 지역 높이가 낮은경우
						sink[i][j]=true;//물에 잠김
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(sink[i][j]==false && visit[i][j]==false) {//물에 잠기지 않고, 방문한 적 없는 경우
						bfs(i,j);
						count++;//bfs 횟수 증가
					}
				}
			}
			result[num]=count;//결과 저장
			num++;
		}
		Arrays.sort(result, Collections.reverseOrder());//result 내림차순으로 정렬
		
		System.out.println(result[0]);
		
		sc.close();
	}

}
