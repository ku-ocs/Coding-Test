import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stz;
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            String name = stz.nextToken();
            String act = stz.nextToken();

            if (act.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
