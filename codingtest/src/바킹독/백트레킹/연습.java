package 바킹독.백트레킹;

public class 연습 {

    public static int[][] map;

    public static void main(String[] args) {
        map = new int[5][5];
        dfs(0);
    }

    public static void dfs(int depth){
        if (depth == 3){
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println("");
            }
            return;
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
