package 바킹독.MST;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4};

        int low_bound_idx = lower_bound(1, arr);
        int upper_bound_idx = upper_bound(1, arr);
        int binary_idx = binary_search(1, arr);

        System.out.println(low_bound_idx);
        System.out.println(upper_bound_idx);
        System.out.println(binary_idx);
    }

    public static int binary_search(int key, int[] arr){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] < key){
                low = mid + 1;
            } else if(arr[mid] > key){
                high = mid - 1;
            } else{
                return mid;
            }
        }
        return low;
    }

    public static int upper_bound(int key, int[] arr){
        int low = 0;
        int high = arr.length - 1;

        while (low < high){
            int mid = low + (high - low) / 2;

            if (key >= arr[mid]){
                low = mid + 1;
            } else{
                high = mid;
            }
        }

        return low;
    }

    public static int lower_bound(int key, int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;

            if (key > arr[mid]){
                low = mid + 1;
            } else{
                high = mid;
            }
        }

        return low;
    }
}
