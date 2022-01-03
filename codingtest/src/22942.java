import java.util.*;

class Main3 {

    static int n;

    public static void main(String[] args){
        // 첫 번째 줄에는 원의 개수 N이 주어진다.
        // 두 번째 줄부터 N+1 번째 줄까지 원의 중심 x좌표, 원의 반지름 r이 공백으로 구분되어 주어진다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int r = sc.nextInt();
            list.add(x);
            list.add(r);
        }

        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }


    }
}
