import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb =new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            if (str.length() < M) continue;
            if (hashMap.containsKey(str) == true){
                hashMap.put(str, hashMap.get(str) + 1);
            } else{
                hashMap.put(str, 1);
            }

        }

        for (String key : hashMap.keySet()){
            pq.add(new Node(hashMap.get(key), key));
        }

        while (!pq.isEmpty()){
            sb.append(pq.poll().value + "\n");
        }

        System.out.print(sb.toString());
    }

    public static class Node implements Comparable<Node>{
        int cnt;
        String value;

        public Node(int cnt, String value){
            this.cnt = cnt;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt != o.cnt){
                return o.cnt - this.cnt;
            }
            if (this.value.length() != o.value.length()){
                return o.value.length() - this.value.length();
            }

            return this.value.compareTo(o.value);
        }
    }
}
