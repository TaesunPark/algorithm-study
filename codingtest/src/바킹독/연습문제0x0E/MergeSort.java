package 바킹독.연습문제0x0E;

public class MergeSort {
    static int n = 10;
    static int[] arr = new int[1000001];
    static int[] tmp = new int[1000001];

    public static void merge(int st, int en){
         int mid = (st+en)/2;
        int lidx = st;
        int ridx = mid;

        for (int i = st; i<en; i++){
            if (ridx == en) tmp[i] = arr[lidx++];
            else if (lidx == mid) tmp[i] = arr[ridx++];
            else if (arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
            else tmp[i] = arr[ridx++];
        }
        for (int i = st; i<en; i++) arr[i] = tmp[i];
    }
    public static void merge_sort(int st, int en){
        if (st + 1 == en){
            return;
        }
        int mid = (st+en)/2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }

    public static void main(String[] args) {
        merge_sort(0, n);
    }
}
