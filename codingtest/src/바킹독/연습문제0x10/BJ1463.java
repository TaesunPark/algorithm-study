package 바킹독.연습문제0x10;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ1463 {
    static int n;
    static int count;
    static Queue<Node> stack;
    static boolean[] check;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        check = new boolean[n+1];
        stack = new LinkedList<>();

        stack.add(new Node(n, 0));

        while(!stack.isEmpty()){
            Node node = stack.remove();
            int num = node.n;

            if(num == 1){
                System.out.println(node.count);
                break;
            }

            if(!check[num] && num > 1){
                int count = node.count + 1;
                check[num] = true;

                if(num % 3 == 0){
                    stack.add(new Node(num/3,count));
                }

                if(num % 2 == 0){
                    stack.add(new Node(num/2,count));
                }
                stack.add(new Node(num-1,count));
            }
        }
    }
}
class Node{
    int n;
    int count;
    public Node(int n, int count){
        this.n = n;
        this.count = count;
    }
}
