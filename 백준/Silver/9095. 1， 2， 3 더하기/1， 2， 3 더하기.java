import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] D = new int[12];
        D[1] = 1;
        D[2] = D[1] + 1;
        D[3] = D[2] + D[1] + 1;

        for(int i = 4; i <= 11; i++) {
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            bw.write(D[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}