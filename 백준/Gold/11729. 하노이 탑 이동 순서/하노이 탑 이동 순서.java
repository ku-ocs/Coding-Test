import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(1, 3, n);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void hanoi(int s, int e, int n) {
        cnt++;
        if (n == 1) {
            sb.append(s).append(" ").append(e).append("\n");
            return;
        }

        hanoi(s, 6 - s - e, n-1);
        sb.append(s).append(" ").append(e).append("\n");
        hanoi(6 - s - e, e, n-1);
    }
}
