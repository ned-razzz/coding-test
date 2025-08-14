package class2.p10845;

import java.io.*;

/**
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] queue = new int[10_000];
        int frontIndex = 0;
        int backIndex = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.contains("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                queue[backIndex++] = value;
            } else if (command.equals("pop")) {
                if (backIndex-frontIndex == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                int value = queue[frontIndex++];
                sb.append(value).append('\n');
            } else if (command.equals("size")) {
                sb.append(backIndex-frontIndex).append('\n');
            } else if (command.equals("empty")) {
                if (backIndex-frontIndex == 0) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (command.equals("front")) {
                if (backIndex-frontIndex == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(queue[frontIndex]).append('\n');
            } else if (command.equals("back")) {
                if (backIndex-frontIndex == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(queue[backIndex-1]).append('\n');
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
