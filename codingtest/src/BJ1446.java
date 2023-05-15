import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BJ1446 {

    static int N;
    static int D;
    static ArrayList<Node> list;
    static int[] di;
    static HashMap<Integer, ArrayList<Node>> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = sc.nextInt();
        list = new ArrayList<>();

        di = new int[D + 1];
        map = new HashMap<>();

        for (int i = 0; i < N; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();
            int d = sc.nextInt();

            if (!map.containsKey(en)){
                map.put(en, new ArrayList<>());
            }
            map.get(en).add(new Node(st, d));
        }

        for (int i = 1; i <= D; i++){
            di[i] = di[i - 1] + 1;

            if (map.containsKey(i)){
                for (Node node : map.get(i)){
                    di[i] = Math.min(di[i], node.val + di[node.st]);
                }
            }
        }

        System.out.print(di[D]);

    }

    public static class Node{
        int st;
        int val;

        public Node(int st, int val){
            this.st = st;
            this.val = val;
        }
    }

}
