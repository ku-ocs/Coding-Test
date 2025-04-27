import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long C;
    static Map<Long, Integer> map = new HashMap<>();
    static List<Long> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        C = Long.parseLong(stz.nextToken());


        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(stz.nextToken());
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
            list.add(num);
        }

        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (map.get(o1) != map.get(o2)) {
                    return map.get(o2) - map.get(o1);
                } else {
                    return list.indexOf(o1) - list.indexOf(o2);
                }
            }
        });

        for (long l : list) {
            bw.write(l + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}