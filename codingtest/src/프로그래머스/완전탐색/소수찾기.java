package 프로그래머스.완전탐색;

import java.util.ArrayList;

public class 소수찾기 {

    public static ArrayList<Integer> list;
    public static boolean[] check;

    public static void main(String[] args) {
        System.out.print(solution("011"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        list = new ArrayList<>();
        check = new boolean[7];

        for (int i = 0; i < numbers.length(); i++){
            dfs(numbers, "", i+1);
        }

        for (int i = 0; i < list.size(); i++){
            if(isPrime(list.get(i)) == true) {
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(String numbers, String tmp, int n){

        if(n == tmp.length()){

            if(!list.contains(Integer.parseInt(tmp))){
                list.add(Integer.parseInt(tmp));
            }

        }

        for(int i = 0; i < numbers.length(); i++){

            if(check[i] == true){
                continue;
            }

            check[i] = true;
            tmp += numbers.charAt(i);
            dfs(numbers, tmp, n);
            check[i] = false;
            tmp = tmp.substring(0, tmp.length() -1);

        }
    }

    public static boolean isPrime(int value){

        if(value < 2){
            return false;
        }

        for(int i=2; i * i <= value; i++){

            if(value % i == 0){
                return false;
            }

        }

        return true;

    }
}
