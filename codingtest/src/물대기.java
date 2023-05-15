import java.util.ArrayList;
import java.util.Scanner;

public class 물대기 {
    static int[] p;
    static ArrayList<Node> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        int n = sc.nextInt();

        p = new int[n + 1];
        p[0] = 0;

        for (int i = 1; i <= n; i++){
            p[i] = i;
            int value = sc.nextInt();
            list.add(new Node(0, i, value));
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                int value = sc.nextInt();
                if (i != j) {
                    list.add(new Node(i, j, value));
                }
            }
        }

        list.sort((o1,o2)->{
            return o1.val - o2.val;
        });

        int result = 0;
        int cnt = 0;
        for (Node node : list){
            if (cnt == n) break;
            int st = find(node.st);
            int en = find(node.en);
            if (st == en) continue;
            p[en] = st;
            result += node.val;
            cnt++;
        }

        System.out.print(result);

    }

    public static int find(int st){
        if (p[st] == st){
            return st;
        } else{
            return p[st] = find(p[st]);
        }
    }

    public static class Node{
        int st;
        int en;
        int val;

        public Node(int st, int en, int val){
            this.st = st;
            this.en = en;
            this.val = val;
        }

    }

}
