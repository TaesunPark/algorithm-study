package swexpert.알고리즘_Track_상;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class 공통조상 {

    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] tree;
    static int root;
    static int[] parents;
    static boolean[] visited;
    static int V, E;
    static int v1, v2;
    static ArrayList<Integer> p1;
    static ArrayList<Integer> p2;
    static int result2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_c = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 1; t <= t_c; t++){
            st = new StringTokenizer(br.readLine());
            p1 = new ArrayList<>();
            p2 = new ArrayList<>();
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            list = new ArrayList[V + 1];
            tree = new ArrayList[V + 1];
            parents = new int[V + 1];
            visited = new boolean[V + 1];

            for (int i = 0; i <= V; i++){
                list[i] = new ArrayList<>();
                tree[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++){
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                list[vertex1].add(vertex2);
                list[vertex2].add(vertex1);
            }

            root = 1;
            makeTree(root);
            findParents1(v1);
            findParents2(v2);

            int r1 = 1;
            result2 = 0;
            boolean check = false;
            for (int i = 0; i < p1.size(); i++){
                for (int j = 0; j < p2.size(); j++){
                    if (p1.get(i).equals(p2.get(j))){
                        r1 = p1.get(i);
                        check = true;
                        break;
                    }
                }
                if (check) break;
            }

            findSize(r1);
            result2 += 1;
            System.out.println("#"+t+" "+ r1+" "+result2);

        }
    }

    public static void findSize(int root1){
        result2 += tree[root1].size();

        for (int leaf : tree[root1]){
            findSize(leaf);
        }
    }

    public static void findParents1(int v){
        if (parents[v] == 0) return;
        p1.add(v);
        findParents1(parents[v]);
    }
    public static void findParents2(int v){
        if (parents[v] == 0) return;
        p2.add(v);
        findParents2(parents[v]);
    }

    public static void makeTree(int rootNum){
        visited[rootNum] = true;

        for (int leaf : list[rootNum]){
            if (visited[leaf] == true) continue;
            parents[leaf] = rootNum;
            tree[rootNum].add(leaf);
            makeTree(leaf);
        }
    }

}
