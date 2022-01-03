package 바킹독.연습문제0x03;
import java.util.*;

class Main4 {
    public static String name;
    public static int[] number = new int[26];
    public static int[] number2 = new int[26];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        name = sc.next();

        //func1(name);// 첫번째 풀이
        //System.out.println("");
        func2(name);// 효율적인 두번째 풀이


    }

    public static void func1(String name){
        for(int i=0;i<26;i++){
            for(int j=0;j<name.length();j++){
                if(i == name.charAt(j)-97){
                    number[i]++;
                }
            }
        }

        for(int i=0; i<26; i++){
            System.out.print(number[i]+" ");
        }
    }

    public static void func2(String name){
        for(int i=0;i<name.length();i++){
            number2[name.charAt(i)-97]++;
        }

        for(int i=0; i<26; i++){
            System.out.print(number2[i]+" ");
        }
    }

}
