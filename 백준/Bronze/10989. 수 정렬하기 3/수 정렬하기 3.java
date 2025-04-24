import java.io.*;

public class Main {
    static int N;
    static int[] arr = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx]++;
        }

        for (int i = 1; i <= 10000; i++) {
            int cnt = arr[i];

            for (int j = 1; j <= cnt; j++) {
                bw.write(i + "\n");
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}