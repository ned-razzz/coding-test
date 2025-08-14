package class2.p2164;

import java.io.*;
import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> cards = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
        ArrayDeque<Integer> deckQueue = new ArrayDeque<>(cards);

        Integer last = 0;
        boolean isEvenTurn = false;

        while (true) {
            // 맨 앞 카드 제거
            Integer polled = deckQueue.poll();

            //마지막 카드일 경우 끝
            if (deckQueue.peek() == null) {
                last = polled;
                break;
            }

            // 짝수 턴에만 뒤에 다시 넣기
            if (isEvenTurn) {
                deckQueue.offer(polled);
            }

            isEvenTurn = !isEvenTurn;
        }

        System.out.println(last);
    }
}
