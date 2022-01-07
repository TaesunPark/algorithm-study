package 바킹독.연습문제0x06;

public class Queue {

    public static int head = 0;
    public static int tail = 0;
    public static int[] dat = new int[1000001];
    public static void main(String[] args){

    }

    public static void push(int x){
        dat[tail++] = x;
    }

    public static void pop(){ // 삭제
        head +=1;
    }

    public static int front(){
        return dat[head];
    }

    public static int back(){
        return dat[tail-1];
    }
}
