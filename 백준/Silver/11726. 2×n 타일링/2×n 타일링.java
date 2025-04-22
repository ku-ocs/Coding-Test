import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] D = new int[num+1];

        if (num == 1) {
            System.out.println(1);
            return;
        }

        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i<= num; i++) {
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }

        System.out.println(D[num]);
    }
}