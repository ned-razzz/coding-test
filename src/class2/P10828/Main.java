package class2.P10828;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 스택 배열 구현
        int[] stack = new int[100_000];
        int lastIndex = -1;
        
        // 명령어 갯수
        int n = Integer.parseInt(br.readLine());

        // 명령 수행
        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.contains("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack[++lastIndex] = value;
            }
            else if (command.equals("pop")) {
                if (lastIndex == -1) {
                    sb.append(-1).append('\n');
                    continue;
                }
                int value = stack[lastIndex--];
                sb.append(value).append('\n');
            }
            else if (command.equals("size")) {
                sb.append(lastIndex+1).append('\n');
            }
            else if (command.equals("empty")) {
                if (lastIndex == -1) {
                    sb.append(1).append('\n');
                }
                else {
                    sb.append(0).append('\n');
                }
            }
            else if (command.equals("top")) {
                if (lastIndex == -1) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(stack[lastIndex]).append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
