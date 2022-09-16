package 프로그래머스.kakao2022;

import java.util.ArrayList;
class Solution2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        ArrayList<String> id_arrayList = new ArrayList<>();
        ArrayList<Node> node_arrayList = new ArrayList<>();
        int idxCnt = 0;
        for(String s : id_list){
            id_arrayList.add(s);
            node_arrayList.add(new Node(idxCnt));
            idxCnt = idxCnt + 1;
        }

        for(String s : report){
            String[] names = s.split(" ");
            String myName = names[0];
            String sName = names[1];
            int myNameIdx = id_arrayList.indexOf(myName);
            int sNameIdx = id_arrayList.indexOf(sName);

            if(node_arrayList.get(myNameIdx).doS(sNameIdx)){
                node_arrayList.get(sNameIdx).addCnt();
            }
        }
        int i = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(Node node:node_arrayList){
            if(k <= node.cnt){
                result.add(node.myIdx);
            }
        }
        int cnt1 = 0;
        for(Node node:node_arrayList){

            for(Integer idx : result){
                if(node.isExisted(idx) >= 0){
                    answer[cnt1] += 1;
                }
            }

            cnt1 += 1;
        }

        return answer;
    }
    static class Node{
        int cnt; // 신고 당함
        ArrayList<Integer> s;
        int myIdx;
        int sCnt;

        public Node(int myIdx){
            cnt = 0;
            s = new ArrayList<>();
            sCnt = 0;
            this.myIdx = myIdx;
        }

        public void addCnt(){
            this.cnt += 1;
        }

        public int isExisted(int index){
            return s.indexOf(index);
        }

        // 신고
        public boolean doS(int index){

            if(s.indexOf(index) < 0){
                s.add(index);
                return true;
            }
            return false;
        }

    }
}