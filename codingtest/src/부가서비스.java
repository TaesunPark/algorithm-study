import java.util.ArrayList;
import java.util.List;

public class 부가서비스 {
    public static List<Node> nodeList;
    public static int n;
    public static void main(String[] args) {
        n = 5; // 부가 서비스 번호
        String[] plans = {"100 1 3", "500 4", "2000 5"};
        String[] clients = {"300 3 5", "1500 1", "100 1 3", "50 1 2"};
        ArrayList<Integer> service = new ArrayList<>();
        int[] result = new int[clients.length];
        nodeList = new ArrayList<>();

        for (int i=0; i<plans.length; i++){
            String[] tempList = plans[i].split(" ");
            int[] list = new int[tempList.length - 1];
            int cnt = 0;

            for (int j=1; j<tempList.length; j++){
                list[cnt++] = Integer.parseInt(tempList[j]);
            }

            nodeList.add(new Node(i+1, Integer.parseInt(tempList[0]), list));
        }


        for (int i=0; i<clients.length; i++){
            String[] tempList = clients[i].split(" ");
            int data = Integer.parseInt(tempList[0]);
            int[] list = new int[tempList.length-1];
            int cnt = 0;
            for (int j=1; j<tempList.length; j++){
                list[cnt++] = Integer.parseInt(tempList[j]);
            }

            for (int j=0; j< nodeList.size(); j++){
                if (nodeList.get(j).data >= data && hasList(j, list) == true){
                    result[i] = nodeList.get(j).getN();
                    break;
                }
            }
        }

        for (int i=0; i< result.length; i++){
            System.out.print(result[i]);
        }

    }
    public static boolean hasList(int j, int[] list){
        for (int i=0; i<list.length; i++){
            boolean check = false;
            for (int k=0; k<nodeList.get(j).list.length; k++){
                if (list[i] == nodeList.get(j).list[k]){
                    check = true;
                    break;
                }
            }
            if (check == false) return false;
        }
        return true;
    }
    public static class Node{
        int m; // 요금제 번호
        int data; // 제공 데이터
        int[] list;

        public Node(int m, int data, int[] list){
            this.m = m;
            this.data = data;
            if (m != 1) {
                this.list = new int[nodeList.get(m - 2).list.length + list.length];

                for (int i=0; i<list.length; i++){
                    this.list[i] = list[i];
                }

                int cnt = list.length;

                if (m > 1) {
                    for (int i = 0; i < nodeList.get(m - 2).list.length; i++) {
                        this.list[cnt++] = nodeList.get(m - 2).list[i];
                    }
                }

            } else{
                this.list = list;
            }
        }

        public int getN(){
            return m;
        }

        public int[] getList(){
            return list;
        }
    }
}
