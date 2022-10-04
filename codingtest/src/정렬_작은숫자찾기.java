public class 정렬_작은숫자찾기 {
    public static void main(String[] args) {
        int[] answer = {};
        int[] p = {1,2,3,4,5};
        int[] cnt = new int[p.length];
        answer = cnt;
        for (int i=0; i<p.length-1; i++){
            int index = 0;
            int index2 = 0;
            int min = p[i];
            int tmp = 0;
            boolean flag = false;

            for (int j=i+1; j<p.length; j++){
                if (min > p[j]){
                    flag = true;
                    min = p[j];
                    index = j; // 최종
                }
            }
            if (flag == true) {
                cnt[index]++;
                cnt[i]++;
                tmp = p[index];
                p[index] = p[i];
                p[i] = tmp;
            }
        }
        for (int i=0; i<answer.length;i++){
            System.out.print(answer[i]);
        }
    }
}
