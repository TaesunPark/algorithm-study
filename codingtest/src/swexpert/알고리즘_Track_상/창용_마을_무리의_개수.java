package swexpert;
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class 창용_마을_무리의_개수
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N, M;
            N = sc.nextInt();
            M = sc.nextInt();
            int result = 0;
            boolean[] visited = new boolean[N + 1];
            ArrayList<Integer>[] list = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++){
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                list[a].add(b);
                list[b].add(a);
            }

            for (int i = 1; i <= N; i++){
                if (visited[i] == true) continue;
                result++;
                bfs(i, visited, list);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
    public static void bfs(int start, boolean[] visited, ArrayList<Integer>[] list){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int num = queue.poll();

            for (int value : list[num]){
                if (visited[value] == true) continue;
                visited[value] = true;
                queue.add(value);
            }
        }
    }
}