package 바킹독;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 빈도_정렬 {
    static int N, C;
    static ArrayList<Node> list;
    static HashMap<Integer, Node> hashMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        list = new ArrayList<>();
        hashMap = new HashMap<>();

        for (int i = 0; i < N; i++){
            int value = sc.nextInt();
            if (hashMap.containsKey(value)){
                hashMap.get(value).addCnt();
            } else{
                hashMap.put(value, new Node(value,1, i));
            }
        }

        ArrayList<Node> list = new ArrayList<>();

        for (Node node : hashMap.values()){
            list.add(node);
        }

        list.sort((o1, o2) ->
                {
                    if (o1.cnt == o2.cnt) {

                        return o1.idx - o2.idx;
                    }

                    return o2.cnt - o1.cnt;
                });

        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).cnt; j++) {
                System.out.print(list.get(i).value + " ");
            }
        }
    }

    public static class Node{
        int cnt;
        int idx;
        int value;

        public Node(int value, int cnt, int idx){
            this.cnt = cnt;
            this.idx = idx;
            this.value = value;
        }

        public void addCnt(){
            this.cnt += 1;
        }
    }

}
