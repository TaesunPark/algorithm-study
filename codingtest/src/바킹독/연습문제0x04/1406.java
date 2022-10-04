package 바킹독.연습문제0x04;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

// 틀린 코드
class Main {

    public static void main(String[] args) throws IOException{
        String str;
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<Character>();

        str = br.readLine();
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<str.length();i++){
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        // 커서 맨 뒤로 이동
        while(iter.hasNext()){
            iter.next();
        }

        for(int i=0; i<n; i++){
            String cmd = br.readLine();
            if(cmd.charAt(0) == 'L'){
                if(iter.hasPrevious()){
                    iter.previous();
                }
            } else if(cmd.charAt(0) == 'D'){
                if(iter.hasNext()){
                    iter.next();
                }
            } else if(cmd.charAt(0) == 'B'){
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            } else if(cmd.charAt(0) == 'P'){
                iter.add(cmd.charAt(2));
            }
        }

        for(Character chr:list){
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }
}
