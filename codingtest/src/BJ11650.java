import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11650 {
    public static void main(String[] args) throws IOException {
        ArrayList<Map> maps = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maps.add(new Map(x, y));
        }
        Collections.sort(maps);

        for (int i=0; i<n; i++){
            System.out.println(maps.get(i).x+" "+ maps.get(i).y);
        }
    }
    static class Map implements Comparable<Map> {
        int x;
        int y;
        public Map(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Map o) {
            if (x < o.x){
                return -1;
            } else if(x > o.x){
                return 1;
            } else{
                if (y > o.y){
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}


