import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n+1];
        int[] P = new int[n+1];

        for(int i = 2; i <= n; i++) {
            D[i] = D[i-1] + 1;
            P[i] = i-1;

            if(i % 3 == 0 && D[i/3] < D[i]) {
                D[i] = D[i/3]+1;
                P[i] = i/3;
            }

            if(i % 2 == 0 && D[i/2] < D[i]) {
                D[i] = D[i/2]+1;
                P[i] = i/2;
            }
        }

        bw.write(D[n] + "\n");
        while (true) {
            bw.write(n + " ");
            if (n == 1) {
                break;
            }
            n = P[n];
        }

        bw.flush();
        bw.close();
        br.close();
    }
}