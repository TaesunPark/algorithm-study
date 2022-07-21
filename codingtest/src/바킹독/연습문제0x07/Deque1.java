package 바킹독.연습문제0x07;

public class Deque1 {

    public static int MX = 1000005;
    public static int[] dat = new int[2*MX];
    public static int head = MX;
    public static int tail = MX;

    public static void main(String[] args){
        
    }

    public static void push_front(int x){
            dat[--head] = x;
    }

    public static void push_back(int x){
            dat[tail++] = x;
    }

    public static void pop_front(){
            head++;
    }

    public static void pop_back(){
            tail--;
    }

    public static int front(){
            return dat[head];
    }

    public static int back(){
            return dat[tail];
    }

    public static void test(){

    }

}
