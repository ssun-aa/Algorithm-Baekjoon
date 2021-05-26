package test;

import java.util.Scanner;

public class boj14501 {
    static int n, answer;
    static int[][] schedule;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        schedule = new int[n][2];

        for(int i=0; i<n; i++){
            schedule[i][0] = sc.nextInt();//걸리는 기간
            schedule[i][1] = sc.nextInt();//받는 금액
        }
        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int day, int sum){
        if(day >= n){//상담 날짜를 다 채운경우
            answer = Math.max(sum, answer);//비교해서 최대값 가져오기
            return;
        }
        if(schedule[day][0] + day <= n)//현재 날짜에 걸리는 기간을 더했을때 n 이내인 경우
            dfs(schedule[day][0] + day, schedule[day][1] + sum);
            //해당 기간을 더하고, 금액도 더해준 후 dfs로 넘긴다
        dfs(1 + day, sum);//해당 날짜의 상담을 하지 않고 다음날로 그냥 넘어가는 경우
    }
}
