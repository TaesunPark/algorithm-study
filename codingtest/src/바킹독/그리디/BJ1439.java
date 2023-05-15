package 바킹독.그리디;

import java.util.Scanner;
import java.util.Stack;

public class BJ1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String str = sc.next();
        stack.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++){
            if (stack.peek() == str.charAt(i)) continue;
            stack.add(str.charAt(i));
        }

        System.out.print(stack.size() / 2);

    }
}
