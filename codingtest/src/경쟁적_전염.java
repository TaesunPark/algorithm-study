import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 경쟁적_전염 {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int[][] map;

    public static int N, M;
    public static void main(String[] args) throws IOException {
        // N x N 시험관
        // 모든 바이러스는 1번부터 K번까지의 바이러스 종류 중 하나
        // 1초마다 상, 하, 좌, 우 방향 증식
        // 가장 왼 쪽 위 (1,1) x,y
        // S초가 지난 후에 (x,y)에 존재하는 바이러스 종류
        // 존재하지 않으면 0
        PriorityQueue<Node> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rS, rX, rY;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    queue.add(new Node(j,i, map[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        rS = Integer.parseInt(st.nextToken());
        rX = Integer.parseInt(st.nextToken());
        rY = Integer.parseInt(st.nextToken());

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;
            int now_value = node.value;
            int now_time = node.time;
            if (now_time >= rS) break;

            for (int i = 0; i < 4; i++){
                int n_x = dx[i] + now_x;
                int n_y = dy[i] + now_y;
                if (n_x < 0 || n_x >= N || n_y < 0 || n_y >= N) continue;
                if (map[n_y][n_x] != 0) continue;
                map[n_y][n_x] = now_value;
                queue.add(new Node(n_x, n_y, now_value, now_time + 1));
            }
        }

        System.out.print(map[rX - 1][rY - 1]);

    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        int time;
        public Node(int x, int y, int value, int time){
            this.x = x;
            this.y = y;
            this.value = value;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time == o.time){
                return this.value - o.value;
            } else{
                return this.time - o.time;
            }
        }
    }
}
