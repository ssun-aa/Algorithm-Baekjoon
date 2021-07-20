package test;

import java.util.*;

public class boj9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i=0; i<testcase; i++){
            Map<String,Integer> map = new HashMap<>();
            int n = sc.nextInt();
            for(int j=0; j<n; j++){
                String cloth = sc.next();
                String type = sc.next();
                if(map.containsKey(type))
                    map.put(type, map.get(type) + 1);
                else
                    map.put(type, 1);
            }
            int answer = 1;
            for(int val : map.values())
                answer *= (val+1);

            System.out.println(answer - 1);
        }
    }
}
