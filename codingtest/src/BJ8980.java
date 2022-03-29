import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ8980 {
    public static ArrayList<Node> arrayList = new ArrayList<>();
    public static int N, C, M;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        M = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to, from, w;
            to = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arrayList.add(new Node(to, from, w));
        }
        
        Collections.sort(arrayList);
    }

    public static class Node implements Comparable<Node>{
        int from;
        int to;
        int w;

        public Node(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if (this.from == node.from) return this.to-node.to;
            else return this.from-node.from;
        }
    }
}
