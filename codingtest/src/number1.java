public class number1 {


    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        Integer[] choices = {5,3,2,7,5};
        String answer = "";
        int aNum=0;
        int nNum=0;
        int cNum=0;
        int fNum=0;
        int mNum=0;
        int jNum=0;
        int rNum=0;
        int tNum=0;

        for (int i=0; i< survey.length; i++){
            switch (survey[i]){
                case "AN":
                    if (choices[i]-4 <= 0){
                        aNum += -(choices[i] - 4);
                    } else{
                        nNum += (choices[i] - 4);
                    }
                    break;
                case "NA":
                    if (choices[i]-4 <= 0){
                        nNum += -(choices[i] - 4);
                    } else{
                        aNum += (choices[i] - 4);
                    }
                    break;
                case "CF":
                    if (choices[i]-4 <= 0){
                        cNum += -(choices[i] - 4);
                    } else{
                        fNum += (choices[i] - 4);
                    }
                    break;
                case "FC":
                    if (choices[i]-4 <= 0){
                        fNum += -(choices[i] - 4);
                    } else{
                        cNum += (choices[i] - 4);
                    }
                    break;
                case "RT":
                    if (choices[i]-4 <= 0){
                        rNum += -(choices[i] - 4);
                    } else{
                        tNum += (choices[i] - 4);
                    }
                    break;
                case "TR":
                    if (choices[i]-4 <= 0){
                        tNum += -(choices[i] - 4);
                    } else{
                        rNum += (choices[i] - 4);
                    }
                    break;
                case "JM":
                    if (choices[i]-4 <= 0){
                        jNum += -(choices[i] - 4);
                    } else{
                        mNum += (choices[i] - 4);
                    }
                    break;
                case "MJ":
                    if (choices[i]-4 <= 0){
                        mNum += -(choices[i] - 4);
                    } else{
                        jNum += (choices[i] - 4);
                    }
                    break;
            }
        }
        answer = new MBTI(rNum-tNum, cNum-fNum, jNum-mNum, aNum-nNum).getMBTI();
        System.out.printf(answer);
    }



    public static class MBTI{
        char M; // R or T R이 1
        char B; // C or F C가 1
        char T; // J or M J가 1
        char I; // A or N N이 1

        // 사전 순
        public MBTI(int m, int b, int t, int i){
            if (m >=0){
                M = 'R';
            }else{
                M = 'T';
            }
            if (b >=0){
                B = 'C';
            } else{
                B = 'F';
            }
            if (t >=0){
                T = 'J';
            } else{
                T = 'M';
            }
            if (i >=0){
                I = 'A';
            } else{
                I = 'N';
            }
        }

        public String getMBTI(){
            return String.valueOf(M)+String.valueOf(B)+String.valueOf(T)+String.valueOf(I);
        }
    }
}
