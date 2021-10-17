package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String names[] = new String[N+1];

        for(int i=1; i<=N; i++){
            String name = br.readLine();
            map.put(name, i);
            names[i] = name;
        }

        for(int i=1; i<=M; i++){
            String quest = br.readLine();

            if(quest.matches("[+-]?\\d*(\\.\\d+)?"))//숫자이면
                System.out.println(names[Integer.parseInt(quest)]);
            else
                System.out.println(map.get(quest));

        }
    }
}
