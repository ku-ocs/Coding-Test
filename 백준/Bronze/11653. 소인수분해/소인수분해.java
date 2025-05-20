import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        int max = (int) Math.sqrt(N);
        for (int i = 2; i <= max; i++) {
            while (N % i == 0) {
                N /= i;
                bw.write(i + "\n");
            }
        }

        if (N != 1) bw.write(N + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}