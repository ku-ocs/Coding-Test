import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer;
    static int[] tab;
    static LinkedList<Integer> plug = new LinkedList<>();
    static LinkedList<Integer> tempPlug = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        tab = new int[K];

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            tab[i] = Integer.parseInt(stz.nextToken());
        }

        for (int i = 0; i < K; i++) {
            int device = tab[i];
            // plug 에 device 값이 있다면  continue
            if (plug.contains(device)) {
                continue;
            }

            // plug 에 꼽혀있는 device 의 숫자가 플러그 개수보다 작다면 플러그에 추가 후 continue
            if (plug.size() < N) {
                plug.add(device);
                continue;
            }

            // plug 가 꽉찼다면 아래 로직 실행
            // 현재 시점에서 가장 나중에 등장하는 device 값을 확인하기 위한 tempPlug 사용
            // tempPlug 초기화 및 현재 플러그에 있는 장치값들 입력
            tempPlug.clear();
            tempPlug.addAll(plug);
            for (int j = i; j < K; j++) {
                // index 별로가 아닌 장치번호를 지우기 위해 Integer 로 형변환
                int tempDevice = tab[j];
                // 장치가 1개 남아있다 = 남아있는 장치가 제일 마지막에 사용되는 것
                if (tempPlug.size() == 1) {
                    break;
                }

                // 장치가 2개 이상일 때 지금 시점에서 사용하는 장치 중 빠른 시일내에 사용하는 장치를 tempPlug 에서 제거
                if(tempPlug.contains(tempDevice)) {
                    tempPlug.remove((Integer) tempDevice);
                }
            }

            // tempPlug 의 크기가 1 이상일 경우 - 제일 나중에 남아있는 장치 or 사용하지 않는 장치이므로 pop 을 통해 번호 가져옴.
            plug.remove(tempPlug.pop());
            plug.add(device);
            answer++;
        }

        System.out.println(answer);
    }
}
