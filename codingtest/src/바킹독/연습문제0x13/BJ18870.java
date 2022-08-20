package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {
    public static void main(String[] args) throws IOException {
        int n;
        int[] list;
        int[] sortList;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        sortList = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        sortList = Arrays.stream(list).sorted().distinct().toArray();

        for (int i=0; i<sortList.length; i++){
            hashMap.put(sortList[i], i);
        }

        for (int i=0; i<list.length; i++){
            sb.append(hashMap.get(list[i]) + " ");
        }

        System.out.print(sb);
    }
}
