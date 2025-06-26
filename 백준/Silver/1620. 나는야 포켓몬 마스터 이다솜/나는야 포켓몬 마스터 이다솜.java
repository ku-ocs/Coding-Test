import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        Map<String, String> map = new HashMap<>();

        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());

        int idx = 1;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            String sIdx = idx+"";
            map.put(name, sIdx);
            map.put(sIdx, name);
            idx++;
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            bw.write(map.get(question) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
