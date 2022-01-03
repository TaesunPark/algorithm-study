package 바킹독.연습문제0x03;

class Main {

    public static void main(String[] args){
        System.out.println(func2(new int[]{1, 52, 48}, 3));
        System.out.println(func2(new int[]{50, 42}, 2));
        System.out.println(func2(new int[]{4, 13, 63, 87}, 4));
    }

    public static int func2(int[] list, int N){
        int[] a = new int[101];
        for(int i=0; i<N;i++){
            if(a[100 - list[i]] == 1)
                return 1;
            a[list[i]] = 1;
        }
        return 0;
    }
}
