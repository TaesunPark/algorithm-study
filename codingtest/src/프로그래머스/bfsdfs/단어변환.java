package 프로그래머스.bfsdfs;

import java.util.Queue;
import java.util.LinkedList;

class Solution4 {
    public static boolean[] check;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }

    public static int bfs(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<Node>();
        check = new boolean[words.length];

        int min = 0;

        for(int i=0; i<words.length; i++){
            int cnt = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) continue;
                cnt++;
            }
            if(cnt == 1){
                queue.add(new Node(words[i], 1));
                check[i] = true;
            }

        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int cnt = node.cnt;
            String value = node.value;

            if(value.equals(target)){
                if(min == 0) min = Integer.MAX_VALUE;
                min = Math.min(min, cnt);
            }

            for(int i=0; i<words.length; i++){
                if(check[i] == true) continue;

                int cnt1 = 0;

                for(int j=0; j<value.length(); j++){
                    if(value.charAt(j) == words[i].charAt(j)) continue;
                    cnt1++;
                }

                if(cnt1 == 1){
                    queue.add(new Node(words[i], cnt + 1));
                    check[i] = true;
                }

            }

        }

        return min;
    }

    public static class Node{
        String value;
        int cnt;
        public Node(String value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }
    }

}