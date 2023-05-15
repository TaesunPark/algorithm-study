import java.util.Scanner;

public class 오리 {
    public static void main(String[] args) {
        int[] duck_cnt = new int[5]; //q u a c k
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] duck_sound = new char[input.length()];
        char[] duck_sound_cmp = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            duck_sound[i] = input.charAt(i);
            duck_sound_cmp[i] = duck_sound[i];
        }
        int result = 0;

        while (true) {
            boolean check = false;

            while (true) {
                // quack 보내기.
                char[] duck = {'q', 'u', 'a', 'c', 'k'};
                int[] pass = new int[5];
                int cnt = 0;

                for (int i = 0; i < duck_sound.length; i++) {
                    if (duck[cnt] == duck_sound[i]) {
                        duck_sound[i] = 'p';
                        pass[cnt] = i;
                        cnt++;
                    }

                    if (cnt == 5) {
                        check = true;
                        break;
                    }
                }

                if (cnt != 5) {
                    for (int i = 0; i < cnt; i++) {
                        duck_sound[pass[i]] = duck_sound_cmp[pass[i]];
                    }
                }
                break;
            }

            if (check == false) break;
            result++;

        }

        System.out.print(result);
    }
}
