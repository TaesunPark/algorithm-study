package 바킹독.연습문제0x17;

public class Heap {

    public static int[] heap = new int[100005];
    public static int size = 0; // heap에 들어있는 원소 수

    public static void push(int x){
        heap[++size] = x;
        int idx = size;
        while (idx != 1){
            int par = idx/2;
            if (heap[par]<=heap[idx]) break;
            int tmp = heap[par];
            heap[par] = heap[idx];
            heap[idx] = tmp;
            idx = par;
        }

    }
    public static int top(){
        return heap[1];
    }
    public static void  pop(){
        heap[1] = heap[size--];
        int idx = 1;
        // 왼쪽 자식의 인덱(2*idx) 가 sz보다 크면 idx는 리프
        while (2*idx <= size){
            int lc = 2*idx, rc = 2*idx+1;
            int min_child = lc;
            if(rc <= size && heap[rc] < heap[lc]){
                min_child = rc;
            }
            if (heap[idx]<= heap[min_child])break;
            int tmp = heap[idx];
            heap[idx] = heap[min_child];
            heap[min_child] = tmp;
            idx = min_child;
        }
    }
    public static void test(){

    }
    public static void main(String[] args) {
        test();
    }
}
