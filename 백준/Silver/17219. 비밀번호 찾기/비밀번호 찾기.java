import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, String> map = new HashMap<>();

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            String addr = stz.nextToken();
            String pwd = stz.nextToken();
            map.put(addr, pwd);
        }

        for (int i = 0; i < M; i++) {
            String addr = br.readLine();
            bw.write(map.get(addr)+ "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
