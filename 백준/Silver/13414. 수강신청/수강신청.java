import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        LinkedHashSet<String> set = new LinkedHashSet<>();

        int k = Integer.parseInt(stz.nextToken());
        int l = Integer.parseInt(stz.nextToken());



        for (int i = 0; i < l; i++) {
            String num = br.readLine();
            set.remove(num);
            set.add(num);
        }

        Iterator<String> iter = set.iterator();

        int cnt = 0;
        while (cnt < k && iter.hasNext()) {
            bw.write(iter.next() + "\n");
            cnt++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
