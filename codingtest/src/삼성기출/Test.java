package 삼성기출;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, map.getOrDefault(1, 0) + 1);
    }
}
