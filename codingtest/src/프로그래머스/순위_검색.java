package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;

public class 순위_검색 {

    public static HashMap<String, ArrayList<Integer>> hashMap;

    public static void main(String[] args) {
            String[] info = new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
            String[] query = new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

            hashMap = new HashMap<>();
            
            for (String str : info){
                String[] value = str.split(" ");
                String[] las = new String[]{value[0], "-"};
                String[] jobs = new String[]{value[1], "-"};
                String[] terms = new String[]{value[2], "-"};
                String[] foods = new String[]{value[3], "-"};
                int score = Integer.parseInt(value[4]);

                for (String lang : las){
                    for (String job : jobs){
                        for (String term : terms){
                            for (String food : foods){
                                String v1 = lang+job+term+food;
                                ArrayList<Integer> list;

                                if (hashMap.containsKey(v1) == true){
                                    list = new ArrayList<>();
                                } else {
                                    list = hashMap.get(v1);
                                }

                                list.add(score);
                                hashMap.put(v1, list);
                            }
                        }
                    }
                }
            }

            for (ArrayList list : hashMap.values()){
                list.sort(null);
            }

            for (String str : query){
                String[] value = str.split(" and ");
                String las = value[0];
                String job = value[1];
                String term = value[2];
                String[] foods = value[3].split(" ");
                String food = foods[0];
                int score = Integer.parseInt(foods[1]);
                String key = las+job+term+food;

                int v2 = getScore(score, hashMap.get(key));

            }


    }

    public static int getScore(int score, ArrayList<Integer> list){
        int start = 0;
        int end = list.size();

        while (start < end){
            int mid = (start + end) / 2;

            if (list.get(mid) >= score){
                end = mid;
            } else{
                start = mid + 1;
            }
        }

        return list.size() - start;
    }

}
