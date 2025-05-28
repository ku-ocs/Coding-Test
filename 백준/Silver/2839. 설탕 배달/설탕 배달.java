import java.io.*;

public class Main {
    static int N, num3, num5, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num5 = N / 5;
        temp = N % 5;
        while (temp % 3 != 0) {
            temp += 5;
            num5--;
            if (temp > N) {
                System.out.println(-1);
                return;
            }
        }

        num3 = temp / 3;
        System.out.println(num3 + num5);
    }
}