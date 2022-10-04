package 바킹독.연습문제0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2143 {
    static int t;
    static int n;
    static int m;
    static int[] aList;
    static ArrayList<Integer> listA;
    static ArrayList<Integer> listB;
    static int[] bList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        listA = new ArrayList<>();
        listB = new ArrayList<>();
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        aList = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            aList[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        bList = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            bList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++){
            int sum = 0;
            for (int j=i; j<n; j++){
                sum += aList[j];
                listA.add(sum);
            }
        }

        for (int i=0; i<m; i++){
            int sum = 0;
            for (int j=i; j<m; j++){
                sum += bList[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        System.out.print(getCount());
    }

    public static long getCount(){
        int start = 0;
        int end = listB.size() - 1;
        long cnt = 0;

        while (start < listA.size() && 0 <= end){

            long sum = listA.get(start) + listB.get(end);

            if (sum == t){
                long aCnt = 0;
                long bCnt = 0;
                int a = listA.get(start);
                int b = listB.get(end);

                while (start < listA.size() && listA.get(start) == a){
                    start++;
                    aCnt++;
                }

                while (end >= 0 && listB.get(end) == b){
                    end--;
                    bCnt++;
                }

                cnt += aCnt * bCnt;

            } else if (sum < t){
                start++;
            } else{
                end--;
            }

        }
        return cnt;
    }
}
