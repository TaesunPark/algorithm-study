package 바킹독.연습문제0x05;

public class Stack {
    public static int MX = 1000005;
    public static int[] data = new int[MX];
    public static int pos = 0;

    public static void main(String[] args){
        test();
    }

    public static void push(int x){
        data[pos++] = x;
    }

    public static void pop(){
        pos--;
    }

    public static int top(){
        return data[pos-1];
    }

    public static void test(){

    }

}
