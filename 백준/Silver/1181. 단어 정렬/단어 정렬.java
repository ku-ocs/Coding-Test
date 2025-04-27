import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<String> list = new ArrayList<>();
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            list.add(s);
        }

        set = new TreeSet<>(list);
        list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                }
                return 0;
            }
        });

        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}