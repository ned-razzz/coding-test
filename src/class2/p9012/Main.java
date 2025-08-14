package class2.p9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        IntStream.range(0, t)
                .mapToObj(__ -> {
                    try {
                        return br.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(line -> {
                    if (IsVPS(line)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                });

    }

    private static boolean IsVPS(String line) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] chars = line.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                stack.offerFirst(c);
            } else if (c == ')') {
                Character popped = stack.pollFirst();
                // (가 없는데 )가 나왔으면 VPS 아님
                if (popped == null) {
                    return false;
                }
            }
        }
        // (가 남아 있는데 문자열이 끝났으면 VPS 아님
        Character peeked = stack.peekFirst();
        if (peeked != null) {
            return false;
        }

        return true;
    }
}
