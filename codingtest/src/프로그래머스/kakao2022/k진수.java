package 프로그래머스.kakao2022;

class Solution {
    static boolean[] prime = new boolean[1000000];
    public int solution(int n, int k) {
        String a = "";
        String p1 = "";

        int answer=0;

        while(n > 0){
            a += n % k;
            n = n/k;
        }

        for(int i=0; i<a.length();i++){
            p1 += a.charAt(a.length() - i -1);
        }


        String tmp = "";
        long num = 0;

        String[] intList = p1.split("0");

        for(String b: intList){
            if(b.equals("")) continue;
            if(isCheck(Long.parseLong(b))) answer++;
        }

        return answer;
    }
    public static boolean isCheck(long num){
        if(num < 2) return false;

        for(long i = 2; i*i <= num; i++)
            if(num % i == 0) return false;

        return true;
    }
}
