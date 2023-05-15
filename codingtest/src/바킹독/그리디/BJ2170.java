package 바킹독.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        int n = Integer.parseInt(br.readLine());
        Node[] list = new Node[n];
        StringTokenizer stn;

        for (int i = 0; i < n; i++){
            stn = new StringTokenizer(br.readLine());
            long st1 = Integer.parseInt(stn.nextToken());
            long en = Integer.parseInt(stn.nextToken());
            list[i] = new Node(st1, en);
        }

        Arrays.sort(list, (o1, o2) -> {
            if (o1.x == o2.x){
                return (int) (o1.y - o2.y);
            } else{
                return (int) (o1.x - o2.x);
            }
        });

        long st = list[0].x;
        long en = list[0].y;

        for (int i = 1; i < n; i++){
            if (list[i].x <= en){
                if (list[i].y <= en){
                    continue;
                }
                en = list[i].y;
            } else{
                result += Math.abs(en - st);
                st = list[i].x;
                en = list[i].y;
            }
        }

        result += Math.abs(en - st);
        System.out.print(result);

    }

    public static class Node{
        long x;
        long y;

        public Node(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
}
