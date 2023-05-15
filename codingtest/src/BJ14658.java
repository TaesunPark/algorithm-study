import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14658 {
    static int N,M,L,K;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M+1][N+1];
        visited = new boolean[M][N];
        list = new ArrayList<>();



        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            list.add(new Node(x,y));
        }
        int max = 0;

        for (int i = 0; i < K; i++){
            for (int j = 0; j < K; j++){
                //max = Math.max(findStar(list.get(i).x, list.get(j).y));
            }
        }

    }

    public static int findStar(int x, int y){
        int cnt = 0;

        for (int i = 0; i < list.size(); i++){
            int lx = list.get(0).x;
            int ly = list.get(0).y;
        }
        return 0;
    }




    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x =x ;
            this.y =y;
        }
    }
}
