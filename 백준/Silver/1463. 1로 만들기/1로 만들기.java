import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] D = new int[1000001];
        D[1] = 0;

        for(int i = 2; i <= num; i++) {
            int val;
            if (i % 3 == 0) {
                val = D[i/3] + 1;
                D[i] = D[i] == 0 ? val : Math.min(D[i], val);
            }
            if (i % 2 == 0) {
                val = D[i/2] + 1;
                D[i] = D[i] == 0 ? val : Math.min(D[i], val);
            }
            val = D[i-1] + 1;
            D[i] = D[i] == 0 ? val : Math.min(D[i], val);
        }
        
        System.out.println(D[num]);
    }
}