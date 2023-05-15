package 프로그래머스;

public class 디펜스_게임 {

    public static int max;
    public static boolean[] check;

    public static void main(String[] args) {
        max = 0;
        System.out.println(solution(7, 3, new int[]{4,2,4,5,3,3,1}));
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        check = new boolean[enemy.length];
        dfs(k, enemy, n, 0, 0);
        answer = max;
        return answer;
    }

    public static void dfs(int k, int[] enemy, int n, int cnt, int idx){

        if (n <= 0){
            System.out.print("n");
            return;
        }

        if (k < 0 && n < 0){
            System.out.print("k");
            return;
        }

        if (idx >= enemy.length){
            System.out.print("idx");
            return;
        }

        if (n >= 0 && k >= 0) {
            max = Math.max(max, cnt);
        }

        dfs(k-1, enemy, n, cnt + 1, idx + 1);
        k++;
        n = n - enemy[idx];
        dfs(k, enemy, n, cnt + 1, idx + 1);
        n = n + enemy[idx];
    }
}
