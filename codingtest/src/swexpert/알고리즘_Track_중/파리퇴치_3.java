package swexpert;

import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
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
            M--;

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            int max = 0;

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    int num = 0;
                    num = Math.max(spreadPlus(i, j, map, M, N), spreadMulti(i, j, map, M, N));
                    max = Math.max(max, num);
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }

    public static int spreadPlus(int y, int x, int[][] map, int m, int n){
        int sum = 0;
        sum -= map[y][x];

        // 가로
        for (int sx = x - m; sx <= x + m; sx++){
            if (sx >= n || sx < 0) continue;
            sum += map[y][sx];
        }
        // 세로
        for (int sy = y - m; sy <= y + m; sy++){
            if (sy >= n || sy < 0) continue;
            sum += map[sy][x];
        }
        // y, x가 중앙값
        return sum;
    }

    public static int spreadMulti(int y, int x, int[][] map, int m, int n){
        int sum = 0;
        int pos = 0;
        sum += map[y][x];
        // 3
        for (int sx = x - 1; sx >= x - m; sx--){
            pos++;
            if (sx < 0){
                continue;
            }
            if (y + pos < n){
                sum += map[y + pos][sx];
            }
            if(y - pos >= 0){
                sum += map[y - pos][sx];
            }
        }
        pos = 0;

        for (int sx = x + 1; sx <= x + m; sx++){
            pos++;
            if (sx >= n){
                continue;
            }
            if (y + pos < n){
                sum += map[y + pos][sx];
            }
            if(y - pos >= 0){
                sum += map[y - pos][sx];
            }
        }

        return sum;
    }

}