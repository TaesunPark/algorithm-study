package 바킹독;
import java.util.*;


class Main5 {

    public static void main(String[] args){
        System.out.println(func4(5));
        System.out.println(func4(97615282));
        System.out.println(func4(1024));

    }

    public static int func1(int N){
        int sum = 0;
        for(int i=1; i<=N; i++){
            if(i%5 == 0 || i%3 == 0)
                sum += i;
        }
        return sum;
    }

    public static int func2(int arr[], int N){
        for(int i=0;i<N-1;i++){
            for(int j=i+1; j<N;j++){
                if(arr[i]+arr[j] == 100)
                    return 1;
            }
        }
        return 0;
    } // 시간 복잡도 O(N^2)

    public static int func3(int N){
        for(int i=1;i<N;i++){
            if(i*i > N){ // 시간복잡도 O(루트N)
                break;
            }
            if(i*i == N){
                return 1;
            }
        }
        return 0;
    }

    public static int func4(int N){
        double temp=1.0;
        // O(lgN)
        for(int i=1;Math.pow(2,i)<=N;i++){
            temp = Math.pow(2,i);
        }
        return (int)Math.round(temp);
    }
}
