package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Vertex implements Comparable<Vertex>{
    int num;//연결된 정점
    int value;//경로값

    Vertex(int num, int value){
        this.num = num;
        this.value = value;
    }

    @Override//PriorityQueue에서 사용하기 위해서 우선순위 재정의
    public int compareTo(Vertex o) {
        return value - o.value;//경로값이 작은 것이 먼저 오도록 정렬
    }
}
public class boj1753 {
    static LinkedList<Vertex> list[];
    static int weight[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        visit = new boolean[V+1];
        list = new LinkedList[V+1];
        weight = new int[V+1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        for(int i=1; i<=V; i++){
            list[i] = new LinkedList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());//정점
            int v = Integer.parseInt(st.nextToken());//연결된 정점
            int w = Integer.parseInt(st.nextToken());//경로값
            list[u].add(new Vertex(v,w));//각 정점에 연결된 정점의 번호와, 경로값을 추가함
        }

        weight[start] = 0;//시작점의 weight는 0
        route(start);

        for(int i=1; i<=V; i++){//출력
            if(visit[i])
                System.out.println(weight[i]);
            else
                System.out.println("INF");
        }
    }
    public static void route(int start){
        PriorityQueue<Vertex> que = new PriorityQueue<>();
        que.add(new Vertex(start, 0));//시작점 추가

        while(!que.isEmpty()){
            Vertex current = que.poll();
            if(visit[current.num])//방문했으면 pass
                continue;
            visit[current.num] = true;//방문함으로 표시
            for(Vertex v : list[current.num]){//현재 정점에서 간선으로 연결된 다음 정점마다 반복해서
                if(weight[v.num] > weight[current.num] + v.value){//다음 정점까지가는 최소 경로값구하기
                    weight[v.num] = weight[current.num] + v.value;
                    que.add(new Vertex(v.num,weight[v.num]));
                }
            }
        }
    }

}
