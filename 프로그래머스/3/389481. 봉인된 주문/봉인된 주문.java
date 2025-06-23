import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer;

        long[] LBans = convertToLong(bans);
        long target = searchTargetN(n, LBans);
        answer = convertToString(target);

        return answer;
    }

    public static String convertToString(long target) {
        String s = "";
        while (target > 0) {
            long lc = target % 26;
            target /= 26;
            if (lc == 0) {
                target--;
                s = 'z' + s;
            } else s = (char) (lc + 96) + s;
        }

        return s;
    }

    public static long[] convertToLong(String[] bans) {
        List<Long> list = new LinkedList<>();
        for (String ban : bans) {
            char[] bs = ban.toCharArray();
            long num = 0;
            int exp = bs.length - 1;
            for (int i = 0; i < bs.length; i++) {
                char c = bs[i];
                num += (long) (c - 96) * (Math.pow(26, exp--));
            }
            list.add(num);
        }
        return list.stream().mapToLong(Long::longValue).sorted().toArray();
    }

    public static long searchTargetN(long n, long[] LBans) {
        for (long l : LBans) {
            if (n >= l) n++;
            else break;
        }

        return n;
    }
}