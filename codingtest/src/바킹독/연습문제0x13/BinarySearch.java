package 바킹독.연습문제0x13;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] list = {1,5,3,99,95,93};
        Arrays.sort(list);

        int idx = binarySort(list, 99);

        System.out.print(Arrays.binarySearch(list, 1));
    }

    public static int binarySort(int[] list, int findNum){

        int st=0;
        int en=list.length-1;
        int mid = (st+en)/2;

        while (true){
            if (list[mid] < findNum){
                st = mid+1;
            }
            if (list[mid] > findNum){
                en = mid-1;
            }
            if (list[mid] == findNum){
                return mid;
            }
            if (st > en){
                return -1;
            }
            mid = (st+en)/2;
        }

    }


}

