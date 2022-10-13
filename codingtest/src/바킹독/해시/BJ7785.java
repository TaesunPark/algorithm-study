package 바킹독.해시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BJ7785 {
    public static void main(String[] args){
        HashMap<String, Boolean> enterMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String value = sc.next() + " " + sc.next();

            String[] values = value.split(" ");
            if(values[1].equals("enter")){
                enterMap.put(values[0], true);
            } else{
                enterMap.put(values[0], false);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for(Entry<String, Boolean> entry : enterMap.entrySet()){
            if(entry.getValue() == true){
                list.add(entry.getKey());
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
