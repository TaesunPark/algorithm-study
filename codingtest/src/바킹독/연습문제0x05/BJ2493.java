package 바킹독.연습문제0x05;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        Stack<Node> stack = new Stack<>();

        int n = sc.nextInt();

        for(int i=1; i<=n; i++){

            int m = sc.nextInt();

            if(stack.isEmpty()){
                System.out.print("0 ");
                stack.push(new Node(m, i));
            } else{
                while(true){
                    if(stack.isEmpty()){
                        System.out.print("0 ");
                        stack.push(new Node(m, i));
                        break;
                    }

                    Node node = stack.peek();

                    if(node.num > m){
                        System.out.print(node.index+ " ");
                        stack.push(new Node(m, i));
                        break;
                    } else{
                        stack.pop();
                    }

                }
            }

        }
    }
}
class Node{
    int num;
    int index;
    public Node(int n, int index){
        this.num = n;
        this.index = index;
    }
}