public class number2 {
    public static void main(String[] args) {
        int [][] rc = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        String[] operations = {"Rotate", "ShiftRow", "ShiftRow"};

        for (int i=0; i<operations.length; i++){
            if (operations[i].equals("Rotate"))
                rc = rotate(rc);
            else if (operations[i].equals("ShiftRow")){
                rc = shiftRow(rc);
            }
        }

        print(rc);

        return;
    }
    public static void print(int[][] rc){
        for (int i=0; i<rc.length; i++){
            for (int j=0; j<rc[0].length; j++){
                System.out.print(rc[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] shiftRow(int [][] rc){
        int[][] array = new int[rc.length][rc[0].length];

        // 맨 아래 row 저장
        for (int i=0; rc[rc.length - 1].length > i; i++){
            array[0][i] = rc[rc.length - 1][i];
        }

        for (int i=0; i< rc.length-1; i++){
            int [] tmp = new int[rc.length];

            for (int j=0; rc[rc.length - 1].length > j; j++){
                array[i+1][j] = rc[i][j];
            }
        }

        return array;
    }

    public static int[][] rotate(int [][] rc){
        int curRow = 0;
        int curCol = 0;
        int beforeNum, curNum;
        int n = rc[0].length;
        int m = rc.length;

        while (curCol < n && curRow < m){

            if (curRow + 1 == m || curCol + 1 == n) break;

            beforeNum = rc[curRow+1][curCol];

            for (int i = curCol; i<n; i++){
                curNum = rc[curRow][i];
                rc[curRow][i] = beforeNum;
                beforeNum = curNum;
            }
            curRow++;

            for (int i=curRow; i<m;i++){
                curNum = rc[i][n-1];
                rc[i][n-1] = beforeNum;
                beforeNum = curNum;
            }
            n--;

            if (curRow<m){
                for (int i=n-1; i>=curCol; i--){
                    curNum = rc[m-1][i];
                    rc[m-1][i] = beforeNum;
                    beforeNum = curNum;
                }
            }
            m--;

            if (curCol < n){
                for (int i=m-1; i>= curRow; i--){
                    curNum = rc[i][curCol];
                    rc[i][curCol] = beforeNum;
                    beforeNum = curNum;
                }
            }
            curCol++;
        }

        return rc;
    }
}
