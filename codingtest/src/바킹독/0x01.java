package 바킹독;

class Main {

    public static int len;

    public static void main(String[] args){
        int [] arr = new int[10];
        len = 3;
        insert(1, 12, arr, 3);
    }

    public static void insert(int idx, int num, int arr[], int len){
        for(int i=idx; i<len;i++){
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }
    }

    public static void erase(int idx, int arr[], int len){

    }

    public static void printArr(int arr[], int len){

    }
}
