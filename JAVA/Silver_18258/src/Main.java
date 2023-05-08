import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push")) {
                deque.offer(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                if(deque.isEmpty())
                    result.append(-1).append("\n");
                else{
                    result.append(deque.poll()).append("\n");
                }
            } else if (input[0].equals("size")) {
                result.append(deque.size()).append("\n");
            } else if (input[0].equals("empty")) {
                if(deque.isEmpty())
                    result.append(1).append("\n");
                else
                    result.append(0).append("\n");
            } else if (input[0].equals("front")) {
                if(deque.isEmpty())
                    result.append(-1).append("\n");
                else {
                    result.append(deque.peekFirst()).append("\n");
                }
            }else{
                if(deque.isEmpty())
                    result.append(-1).append("\n");
                else {
                    result.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(result);
    }
}
/**
 * 매 입력마다 System.out.println을 했을 때는 오답, StringBuilder를 통해서 최종 결과만 출력했을 때는 정답
 *
 * 왜?
 *
 * 매 입력이 들어올 때마다 출력을 하는 경우, System.out.println은 매번 출력 버퍼를 비워야 하기 때문에 많은 시간이 소요됨.
 * 따라서, StringBuilder를 사용하여 결과를 한 번에 출력하는 것이 효율적임.
 * StringBuilder는 문자열 연산을 더욱 효율적으로 수행할 수 있도록 설계된 클래스이며, 문자열을 추가할 때마다 내부적으로 버퍼에 문자열을 저장함.
 * 이 방법을 사용하면 매 입력이 들어올 때마다 출력 버퍼를 비우는 시간이 절약되어 빠른 속도로 결과를 출력할 수 있음.
 */