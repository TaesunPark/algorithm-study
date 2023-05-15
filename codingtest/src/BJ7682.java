import java.util.Scanner;

public class BJ7682 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true){
            String cmd = sc.nextLine();
            if (cmd.equals("end")) break;
            char[][] map = new char[3][3];
            int idx = 0;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    map[i][j] = cmd.charAt(idx++);
                }
            }

            if (bfs(map)){
                sb.append("valid"+"\n");
            } else{
                sb.append("invalid"+"\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean bfs(char[][] map){
        // 가로, 세로, 대각선, X 개수
        int[] cnts = new int[2]; // 0은 X 1은 O
        int[] dCnts = new int[2];
        int[] totals = new int[2];
        for (int i = 0; i < 3; i++){
            if (map[i][0] == map[i][1] && map[i][1] == map[i][2] && map[i][0] == 'O'){
                cnts[1]++;
            } else if(map[i][0] == map[i][1] && map[i][1] == map[i][2] && map[i][0] == 'O'){
                cnts[0]++;
            }
        }

        for (int j = 0; j < 3; j++){
            if (map[0][j] == map[1][j] && map[1][j] == map[2][j] && map[0][j] == 'O') {
                cnts[1]++;
            }else if (map[0][j] == map[1][j] && map[1][j] == map[2][j] && map[0][j] == 'X'){
                cnts[0]++;
            }
        }

        if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] == 'O'){
            cnts[1]++;
        } else if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] == 'X'){
            cnts[0]++;
        }

        if (map[2][0] == map[1][1] && map[1][1] == map[2][0] && map[2][0] == 'O'){
            dCnts[1]++;
        } else if (map[2][0] == map[1][1] && map[1][1] == map[2][0] && map[2][0] == 'X'){
            dCnts[0]++; // 대각선
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (map[i][j] == 'O'){
                    totals[1]++;
                }else{
                    totals[0]++;
                }
            }
        }


        if (cnts[0] > 1 || cnts[1] > 1){
            return false;
        }

        if (totals[1] > totals[0]){
            return false;
        }

        if (dCnts[0] > 1 || dCnts[1] > 1){
            return false;
        }

        if (cnts[0] == 1 && cnts[1] == 0){
            return true;
        }

        if (cnts[0] == 0 && cnts[1] == 1){
            if (totals[0] > totals[1]){
                return false;
            }
            return true;
        }

        if (dCnts[0] == 1 && dCnts[1] == 0){
            return true;
        }

        if (dCnts[0] == 0 && dCnts[1] == 1){
            if (totals[0] > totals[1]){
                return false;
            }
            return true;
        }

        // 말이 가득 차면 끝나기
        if (totals[0] == 5 && totals[1] == 4 && cnts[0] == 0 && cnts[1] == 0 && dCnts[0] == 0 && dCnts[1] == 0)
            return true;

        return false;
    }
}
