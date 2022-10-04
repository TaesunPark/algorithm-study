package 바킹독.연습문제0x04;

import java.io.*;
import java.util.LinkedList;

public class BJ1406RERE {
    static int cursorPoint;
    static LinkedList<Character> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstStr = br.readLine();
        cursorPoint = firstStr.length();
        list = new LinkedList<>();

        int loopCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<firstStr.length(); i++){
            list.add(firstStr.charAt(i));
        }

        for (int i=0; i<loopCnt; i++){
            String inputList = br.readLine();
            Character ch = null;

            if (inputList.length() == 3){
                ch = inputList.charAt(2);
            }
            Character cmd = inputList.charAt(0);

            switch (cmd){
                case 'L':
                    moveLeft();
                    break;
                case 'D':
                    moveRight();
                    break;
                case 'B':
                    delete();
                    break;
                case 'P':
                    add(ch);
                    break;
            }

        }

        for(Character chr:list){
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }

    // L
    public static void moveLeft(){
        if (cursorPoint <= 0) return;
        cursorPoint--;
    }

    // D
    public static void moveRight(){
        if (cursorPoint>=list.size()) return;
        cursorPoint++;
    }

    // B
    public static void delete(){
        if (cursorPoint <= 0) return;
        list.remove(cursorPoint-1);
        cursorPoint--;

    }

    public static void add(Character ch){
        list.add(cursorPoint, ch);
        cursorPoint++;
    }
}
