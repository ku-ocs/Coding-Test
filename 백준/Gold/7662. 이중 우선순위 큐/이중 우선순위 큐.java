    import java.io.*;
    import java.util.StringTokenizer;
    import java.util.TreeMap;

    public class Main {
        static TreeMap<Integer, Integer> map = new TreeMap<>();
        static int T;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer stz;
            T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int t = Integer.parseInt(br.readLine());
                map.clear();
                for (int j = 0; j < t; j++) {
                    stz = new StringTokenizer(br.readLine(), " ");

                    String d = stz.nextToken();
                    int n = Integer.parseInt(stz.nextToken());

                    if (d.equals("I")) {
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        continue;
                    }

                    if (map.isEmpty()) {
                        continue;
                    }

                    if (n == 1) {
                        int max = map.lastKey();
                        remove(max);
                    } else if (n == -1) {
                        int min = map.firstKey();
                        remove(min);
                    } else {
                        remove(n);
                    }
                }

                if (map.isEmpty()) {
                    bw.write("EMPTY" + "\n");
                    continue;
                }

                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        public static void remove(int n) {
            int val = map.get(n);
            if (val > 1) {
                map.put(n, val - 1);
            } else {
                map.remove(n);
            }
        }
    }
