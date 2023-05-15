package 바킹독.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2457 {
    public static void main(String[] args) throws IOException {
        ArrayList<Node> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int lastTime = dateToInt(12,1);

        StringTokenizer st;

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.valueOf(st.nextToken())*100+Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken())*100+Integer.valueOf(st.nextToken())));
        }

        Collections.sort(list);

        int ans = 0;
        int fidx = 0;
        int start = 301;
        int max = 0;

        while (start < 1201){
            max = 0;
            boolean flag = false;
            for (int i = fidx; i < N; i++){
                Node cur = list.get(i);
                if (cur.st > start) break;
                if (cur.st <= start && max < cur.en){
                    max = cur.en;
                    fidx = i + 1;
                    flag = true;
                }
            }
            if (flag){
                start = max;
                ans++;
            }else{
                break;
            }
        }
        if (max < 1201){
            System.out.print("0");
        } else{
            System.out.print(ans);
        }
    }

    public static int dateToInt(int month, int day){
        int value = 0;

        if (month == 1){
            value += day;
        } else if(month == 2){
            value += day + 31;
        } else if(month == 3){
            value += 28 + 31 + day;
        } else if(month == 4){
            value += 28 + 31 + 31 + day;
        } else if(month == 5){
            value += 28 + 31 + 31 + 30 + day;
        } else if(month == 6){
            value += 28 + 31 + 31 + 30 + 31 + day;
        } else if(month == 7){
            value += 28 + 31 + 31 + 30 + 31 + 30 + day;
        } else if(month == 8){
            value += 28 + 31 + 31 + 30 + 31 + 30 + 31 + day;
        } else if(month == 9){
            value += 28 + 31 + 31 + 30 + 31 + 30 + 31 + 31 + day;
        } else if(month == 10){
            value += 28 + 31 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
        } else if(month == 11){
            value += 28 + 31 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
        } else{
            value += 28 + 31 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 1;
        }

        return value;
    }

    public static class Node implements Comparable<Node>{
        int st;
        int en;

        public Node(int st, int en){
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(Node o) {
            if (this.st == o.st){
                return this.en - o.en;
            }
            return this.st - o.st;
        }
    }
}
