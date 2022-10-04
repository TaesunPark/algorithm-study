package 바킹독.연습문제0x04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;


public class BJ5397 {
    public static void main(String[] args) throws IOException {
        // 백스페이스 '-'
        // 커서의 위치가 줄의 마지막이 아니라면, 커시 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다. ??

        int n;
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            LinkedList<Character> list = new LinkedList<Character>();
            ListIterator<Character> iter = list.listIterator();
            str = br.readLine();
            for(int j=0; j<str.length();j++){
                if(str.charAt(j) == '<'){
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                } else if(str.charAt(j) == '>'){
                    if(iter.hasNext()){
                        iter.next();
                    }
                } else if(str.charAt(j) == '-'){
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                } else{
                    iter.add(str.charAt(j));
                }
            }

            for(char s : list) {
                sb.append(s);
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
