import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BJ20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> listInteger = new ArrayList<>();

        int t = Integer.parseInt(br.readLine());
        HashMap<Character, ArrayList<Integer>> map;

        for (int i = 0; i < t; i++){
            String str = br.readLine();
            list.add(str);
            listInteger.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < t; i++) {
            map = new HashMap<>();
            String str = list.get(i);
            Integer k = listInteger.get(i);
            int minValue = Integer.MAX_VALUE;
            int maxValue = -1;
            boolean check = false;

            for (int j = 0; j < str.length(); j++) {

                if (k == 1){
                    System.out.println("1 1");
                    check = true;
                    break;
                }

                if (map.containsKey(str.charAt(j)) == false) {
                    ArrayList<Integer> list2 = new ArrayList<>();
                    list2.add(j);
                    map.put(str.charAt(j), list2);
                } else {
                    map.get(str.charAt(j)).add(j);
                    if (map.get(str.charAt(j)).size() == k){
                        minValue = Math.min(map.get(str.charAt(j)).get(k-1) - map.get(str.charAt(j)).get(0), minValue);
                        maxValue = Math.max(map.get(str.charAt(j)).get(k-1) - map.get(str.charAt(j)).get(0), maxValue);
                        map.get(str.charAt(j)).remove(0);
                    }
                }
            }

            if (check == true) continue;

            if (minValue == Integer.MAX_VALUE || maxValue == -1){
                System.out.println("-1");
                continue;
            }

            System.out.print(minValue + 1 + " ");
            System.out.println(maxValue + 1);

        }


    }
}