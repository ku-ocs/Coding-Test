import java.io.*;

public class Main {
    static int N;
    static int[][] arr = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr[0] = new int[]{1, 0};
        arr[1] = new int[]{0, 1};
        for (int i = 2; i <= 40; i++) {
            arr[i] = new int[] {arr[i-1][0] + arr[i-2][0], arr[i-1][1] + arr[i-2][1]};
        }

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[n][0] + " " + arr[n][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}