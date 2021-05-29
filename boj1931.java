package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int meeting[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            String[] ps = str.split(" ");
            meeting[i][0] = Integer.parseInt(ps[0]);//시작시간
            meeting[i][1] = Integer.parseInt(ps[1]);//종료시간

        }
        Arrays.sort(meeting, new Comparator<int[]>() {//종료시간기준으로 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])//종료시간이 같다면
                    return o1[0]-o2[0];//시작시간이 빠른 순으로 정렬
                return o1[1]- o2[1];
            }
        });

        int count = 0;//회의 수 count
        int prev_end = 0;//이전 회의의 종료 시간
        for(int i=0; i<n; i++) {
            if(prev_end <= meeting[i][0]){//이전회의의 종료시간이 다음 회의의 시작시간과 같거나 작다면
                count++;
                prev_end = meeting[i][1];
            }
        }
        System.out.println(count);
    }
}
