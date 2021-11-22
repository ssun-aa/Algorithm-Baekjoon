package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class boj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String inputs[] = br.readLine().split(" ");
        int nums[] = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        int sort[] = nums.clone();
        Arrays.sort(sort);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i : sort){
            if(!map.containsKey(i))
                map.put(i, idx++);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : nums){
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
