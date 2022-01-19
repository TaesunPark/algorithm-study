package 바킹독.연습문제0x0B;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ1629 {

    public static long a, b, c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.print(pow(a,b,c));
    }

    public static long pow(long a, long b, long m){
        if(b==1) return a % m;
        long val = pow(a, b/2, m);
        val = val * val % m;
        if(b%2 == 0) return val;
        return val * a % m;
    }

}
