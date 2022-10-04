public class 고객_가입기간 {
    public static void main(String[] args) {
        int[] periods = {20, 23, 24};
        int[][] payments = {{100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000},
                {100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000},
                {350000,50000,50000,50000,50000,50000,50000,50000,50000,50000,50000,50000}};
        int[] estimates = {100000, 100000, 100000};
        int[] result = {0,0};

        int n = periods.length;
        boolean isVip = false;
        boolean isVip2 = false;

        while(--n >= 0){
            int cnt = 2;
            int payment = addPayments(payments[n]);

            while (cnt-- >=0){
                if (cnt == 0){
                    payments[n][0] = estimates[n];
                    periods[n]++;
                    payment = addPayments(payments[n]);
                }

                if (periods[n] >= 60 && payment >= 600000 && payment < 900000){
                    if (cnt == 1){
                        isVip2 = true;
                    } else{
                        isVip = true;
                    }
                } else if(payment >= 900000 && periods[n] >= 24){
                    if (cnt == 1){
                        isVip2 = true;
                    } else{
                        isVip = true;
                    }
                } else{
                    if (cnt == 1){
                        isVip2 = false;
                    } else{
                        isVip = false;
                    }
                }
            }

            if (isVip == false && isVip2 == true){
                result[0]++;
            }

            if (isVip == true && isVip2 == false){
                result[1]++;
            }
        }
        for (int i=0;i<2;i++){
            System.out.print(result[i]);
        }
    }
    public static int addPayments(int payments[]){
        int sum = 0;
        for (int i=0; i<payments.length; i++){
            sum += payments[i];
        }
        return sum;
    }
}
