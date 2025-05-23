import java.io.*;

public class Main {
    static int N, temp1 = 1, temp2 = 6, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        temp1 = 1;
        temp2 = 1;
        answer = 1;

        while (true) {
            if(N <= temp1) {
                System.out.println(answer);
                break;
            }
            temp1 += temp2++ * 6;
            answer++;
        }
    }
}